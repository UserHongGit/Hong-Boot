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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class CcusClient {
    private String domain = "http://pcs.slof.com:80/kdr/kay:dsc:1.0/";
    @Autowired
    private CcusApi ccusApi;

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
        body.put("head",reqJson);
        log.info("请求:{},url:{},param:{}", annotation.name(), url, JSON.toJSONString(body));
        String respJson = null;



        CcusBengRequest request = new CcusBengRequest();
        log.info("feign调用----");
        respJson = ccusApi.getDqBeng(request);
        log.info("fegin-response: ",respJson);


        //============================================
        //try {
        //    //使用Http
        //    String s = SendGet.sendJsonByGetReq(url, JSON.toJSONString(body), "utf-8");
        //    System.out.println(s);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}

        //=================================================

//        //respJson = HttpUtil.get(url, body);
//        //String respJson = HttpUtil.post(url, reqJson);
//        HttpResponse result = HttpUtil.createGet(url)
////                    .header(Header.CONTENT_TYPE,"")
//                .header(Header.ACCEPT_ENCODING,"deflate")
////                    .header(Header.ACCEPT_ENCODING,"gzip")
//                .body(reqJson)
//                .execute();
//        respJson = result.body();
//        log.info("响应:{},url:{},data:{}", annotation.name(), url, respJson);
//        List<T> ret = JSON.parseArray(respJson, clazz);
        return null;
    }

    public <T> List<T> getData(String type,String sbbm, Class<T> clazz) {
        switch (type) {
            case "BENG":
                CcusBengRequest req = new CcusBengRequest();
                req.setSbbm(sbbm);
                return this.send(req, clazz);
            case "DDF":
                return this.send(new CcusDdfRequest(), clazz);
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
