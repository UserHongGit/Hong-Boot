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

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class SendGet {
    public static String sendJsonByGetReq(String url,String param,String encoding)throws  Exception{
        String body = "";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGetWithEntity myGet = new HttpGetWithEntity(url);
        HttpEntity httpEntity = new StringEntity(param, ContentType.APPLICATION_JSON);

        myGet.setEntity(httpEntity);
        myGet.setHeader("Content-Type","application/json;charset=UTF-8");

        CloseableHttpResponse response = client.execute(myGet);
        HttpEntity entity = response.getEntity();

        if(entity!= null){
            InputStream inputStream = entity.getContent();
            GZIPInputStream gzipStream = new GZIPInputStream(inputStream);
            String data = IOUtils.toString(gzipStream,"utf-8");
            System.out.println("GZIP解压 , 接收到的参数 >>>> "+ data);
            //body = EntityUtils.toString(entity,encoding);
            //body = EntityUtils.toString(new GzipDecompressingEntity(response.getEntity()),encoding);
        }
        response.close();
        return body;
    }
}
