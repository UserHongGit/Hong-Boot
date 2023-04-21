package com.hong.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class SendGet {
    public static String sendJsonByGetReq(String url,String param,String encoding)throws  Exception{
        String body = "";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGetWithEntity myGet = new HttpGetWithEntity(url);
        //String tmp = "{ \"head\": {\"password\":\"Sczh!2021\",\"username\":\"sczh\"} }";
        HttpEntity httpEntity = new StringEntity(param, ContentType.APPLICATION_JSON);

        myGet.setEntity(httpEntity);
        myGet.setHeader("Content-Type","application/json");
        myGet.setHeader("Accept","*/*");
        myGet.setHeader("Accept-Encoding","gzip, deflate, br");
        myGet.setHeader("Connection","keep-alive");

        CloseableHttpResponse response = client.execute(myGet);
        HttpEntity entity = response.getEntity();

        if(entity!= null){
            body = EntityUtils.toString(entity,encoding);
            System.out.println("直接接收到的数据:"+body);
        }
        response.close();
        return body;
    }
}
