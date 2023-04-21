package com.hong.controller;

import cn.hutool.http.Header;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.hong.config.HttpComponentsClientRestfulHttpRequestFactory;
import com.hong.feign.TestFeign;
import com.hong.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;
    @Autowired
    private TestFeign testFeign;

    @GetMapping("/test")
    public String dataToCache(@RequestParam("type") String type,String sbbm){
        helloService.dataToCache(type,sbbm);
        return "ok";
    }
    @GetMapping("/hello")
    public String hello(String name){
        return "hello"+name;
    }
    @GetMapping("test/fegin")
    public String testFegin(){
        Map map = new HashMap();
        map.put("aa","bbb");
        //String test = testFeign.hello("张三");
        //System.out.println("result --> "+test);
        String test2 = testFeign.test(map);
        System.out.println("resutl -> "+ test2);
        return "ok-feign";
    }
    @GetMapping("/body")
    public String body(@RequestBody Map map){
        return "body";
    }

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ttt")
    public ResponseEntity<Object> ttt() {
        String domain = "http://pcs.slof.com:80/kdr/kay:dsc:1.0/";
        String beng = "services/single/getDqBeng.json";

        String url ="http://127.0.0.1:8082/body";
        String url2 ="http://127.0.0.1:8082/hello";
        //String resop = restTemplate.getForObject(url2, String.class);

        Map map = new HashMap();
        Map header = new HashMap();
        header.put("password","Sczh!2021");
        header.put("username","sczh");
        map.put("header",header);



        RestTemplate restTemplate = new RestTemplate();
        //修改restTemplate的RequestFactory使其支持Get携带body参数
        restTemplate.setRequestFactory(new HttpComponentsClientRestfulHttpRequestFactory());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Accept-Encoding","gzip,deflate,br");
        headers.set("Accept-Encoding","deflate");

        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(map), headers);

        ResponseEntity<String> exchange = restTemplate.exchange(domain+beng, HttpMethod.GET, httpEntity, String.class);

        System.out.println(exchange.getBody());

        HttpHeaders head = new HttpHeaders();
        head.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(JSON.toJSONString(map), headers);
        log.info("url:" + url + ",httpEntity:" + JSON.toJSONString(entity));
        ResponseEntity<Object> response = restTemplate.exchange(domain+beng, HttpMethod.GET, httpEntity, Object.class);
        log.info("{}请求的返回内容:{}", url, JSON.parseObject(JSON.toJSONString(response.getBody())));
        return null;
    }


}
