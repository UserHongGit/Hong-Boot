package com.hong.call;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.hong.call.ccus.CcusBaseHead;
import com.hong.call.ccus.CcusUrl;
import com.hong.call.ccus.req.*;
import com.hong.feign.CcusApi;
import com.hong.util.SendGet;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class CcusClient {
    private String domain = "http://pcs.slof.com:80/kdr/kay:dsc:1.0/";
    //@Autowired
    //private CcusApi ccusApi;

    /**
     * 请求实时数据
     *
     * @param
     * @return
     * @author leon
     * @date 2023/4/17 14:23
     */
    public <T> List<T> send(CcusBaseHead req, Class<T> clazz) {
        boolean flag = req.getClass().isAnnotationPresent(CcusUrl.class);
        if (flag == false) {
            throw new RuntimeException("ccus-实时数据地址配置错误");
        }
        CcusUrl annotation = req.getClass().getAnnotation(CcusUrl.class);
        String url = domain + annotation.url();

        String reqJson;
        //空值协议
        if (annotation.NullFlag()) {
            reqJson = JSON.toJSONString(req, JSONWriter.Feature.WriteMapNullValue);
        } else {
            reqJson = JSON.toJSONString(req);
        }

        Map body = new HashMap<>();
        body.put("head",req);
        log.info("请求:{},url:{},param:{}", annotation.name(), url, JSON.toJSONString(body));
        String respJson = null;



        //提示NullPoint
        //CcusBengRequest request = new CcusBengRequest();
        //log.info("feign调用----");
        //respJson = ccusApi.getDqBeng(request);
        //log.info("fegin-response: ",respJson);


        //===============这个可以了=============================
        //try {
        //    //使用Http
        //    respJson = SendGet.sendJsonByGetReq(url, JSON.toJSONString(body), "utf-8");
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}


        //==============HuTool ===================================
        //respJson = HttpUtil.get(url, body);
        //String respJson = HttpUtil.post(url, reqJson);
        HttpResponse result = HttpUtil.createGet(url)
                .header(Header.ACCEPT_ENCODING,"gzip, deflate, br")
                .header(Header.ACCEPT,"*/*")
                .header(Header.CONTENT_TYPE,"application/json")
                .header(Header.CONNECTION,"keep-alive")
                .body(JSON.toJSONString(body))
                .execute();
        respJson = result.body();
//        log.info("响应:{},url:{},data:{}", annotation.name(), url, respJson);
        List<T> ret = JSON.parseArray(respJson, clazz);
        return ret;
    }

    public <T> List<T> getData(String type,String sbbm, Class<T> clazz) {
        switch (type) {
            case "BENG":
                CcusBengRequest r1 = new CcusBengRequest();
                r1.setSbbm(sbbm);
                return this.send(r1, clazz);
            case "DDF":
                CcusDdfRequest r2 = new CcusDdfRequest();
                r2.setSbbm(sbbm);
                return this.send(r2, clazz);
            case "GUAN":
                return this.send(new CcusGuanRequest(), clazz);
            case "KRQT":
                return this.send(new CcusKrqtRequest(), clazz);
            case "LLJ":
                return this.send(new CcusLljRequest(), clazz);
            case "ZNDB":
                return this.send(new CcusZndbRequest(), clazz);
            default:
                throw new RuntimeException("没有做假数据");
        }
    }

}
