package com.hong.controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/get")
public class RestController {

    @Autowired
    private RestTemplate restTemplate;
    String url = "http://127.0.0.1:8082/body";

    /**
     * 使用getForObject  url直接携带参数访问  返回的结果是String
     * @return
     */
    @GetMapping("/get1")
    public String getTest1(@RequestParam String id){

        String resop = restTemplate.getForObject(url, String.class);
        return resop+"远程调用get1";
    }

    /**
     * 使用getForObject  url的参数使用map方式   需要使用这种格式id={id}  返回的结果是String
     * @param id
     * @return
     */
    @GetMapping("/get2")
    public String getTest2(@RequestParam String id){

        Map<String,String> map = new HashMap();
        map.put("id","1");
        String resop = restTemplate.getForObject(url, String.class,map);

        return resop+"远程调用get2";
    }

    /**
     * 使用getForEntity   url直接携带参数访问  返回的结果是ResponseEntity类型
     * response.getBody()得到 get返回的data
     * @param id
     * @return
     */
    @GetMapping("/get3")
    public String getTest3(@RequestParam String id){

        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
        String body = response.getBody();
        return body+"远程调用get3";
    }

    /**
     * 使用getForEntity   url直接参数使用map  返回的结果是ResponseEntity类型
     * response.getBody()得到 get返回的data
     * @param id
     * @return
     */
    @GetMapping("/get4")
    public String getTest4(@RequestParam String id){

        Map<String,String> map = new HashMap();
        map.put("id","1");
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class,map);
        String body = response.getBody();
        return body+"远程调用get4";
    }

    /**
     * 使用exchange   请求头部body携带json数据
     *  * 当使用get请求需要携带 body中的参数的时候  需要重写Http  版本号必须是4.3以上
     *    定义HttpGetRequestWithEntity实现HttpEntityEnclosingRequestBase抽象类，以支持GET请求携带body数据
     * @param id
     * @return
     */
    @GetMapping("/get5")
    public String getTest5(@RequestParam String id){

        /**
         * 1）url: 请求地址；
         *      2）method: 请求类型(如：POST,PUT,DELETE,GET)；
         *      3）requestEntity: 请求实体，封装请求头，请求内容
         *      4）responseType: 响应类型，根据服务接口的返回类型决定
         *      5）uriVariables: url中参数变量值
         */

        String jsonData = "{\"test\":\"1234\",\"score\":\"1\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(jsonData, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        return responseEntity.getBody()+"远程调用get5"+responseEntity.getStatusCode();
    }

    /**
     * url参数 使用map  方式
     * @param id
     * @return
     */
    @GetMapping("/get6")
    public String getTest6(@RequestParam String id){
        //封装url参数
        Map<String,String> map = new HashMap();
        map.put("id","1");
        //设置头部body携带json数据
        String jsonData = "{\"test\":\"6666\",\"score\":\"88888\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(jsonData, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class,map);

        return responseEntity.getBody()+"远程调用get6"+responseEntity.getStatusCode();
    }

    /**
     * 使用本接口访问 直接携带json数据 封装成远程调用的参数 去访问
     *
     * 当使用get请求需要携带 body中的参数的时候  需要重写Http  版本号必须是4.3以上
     * 定义HttpGetRequestWithEntity实现HttpEntityEnclosingRequestBase抽象类，以支持GET请求携带body数据
     *
     */
    @GetMapping("/getbody")
    public String getBody(@RequestParam String id, @RequestBody JSONObject json){

        //封装url参数
        Map<String,String> map = new HashMap();
        map.put("id",id);
        //设置头部body携带json数据
        String jsonData = json.toJSONString();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(jsonData, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class,map);

        return responseEntity.getBody()+"远程调用get7"+responseEntity.getStatusCode();
    }

    /**
     * postForObject  直接带参数
     * @param id
     * @return
     */
    @PostMapping("/post1")
    public String postTest1(@RequestParam String id){
        String s = restTemplate.postForObject(url, null, String.class);
        return id+"测试post"+s;
    }

    /**
     * postForObject 使用map  封装 参数
     * @param id
     * @return
     */
    @PostMapping("/post2")
    public String postTest2(@RequestParam String id){
        //封装url参数
        Map<String,String> map = new HashMap();
        map.put("id",id);
        String s = restTemplate.postForObject(url, null, String.class, map);
        return id+"测试post"+s;
    }


    /**
     * postForObject  头部携带Json 数据
     * @param id
     * @param json
     * @return
     */
    @PostMapping("/postbody")
    public String postBody(@RequestParam String id, @RequestBody JSONObject json){

        //封装url参数
        Map<String,String> map = new HashMap();
        map.put("id",id);

        //设置头部body携带json数据
        String jsonData = json.toJSONString();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(jsonData, headers);
        String s = restTemplate.postForObject(url, httpEntity, String.class, map);

        return id+"测试post接收json数据"+s;
    }

    /**
     * post  使用通用的 exchange 访问
     * 返回的结果是ResponseEntity  从中拿数据getBody
     */
    @PostMapping("/postbody2")
    public String postBody2(@RequestParam String id, @RequestBody JSONObject json){

        //封装url参数
        Map<String,String> map = new HashMap();
        map.put("id",id);

        //设置头部body携带json数据
        String jsonData = json.toJSONString();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(jsonData, headers);
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class, map);

        return "测试post接收json数据"+exchange.getBody()+":"+exchange.getStatusCode();
    }


}

