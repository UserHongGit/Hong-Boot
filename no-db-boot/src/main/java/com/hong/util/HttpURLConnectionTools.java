package com.hong.util;

import com.alibaba.fastjson2.JSON;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;


public class HttpURLConnectionTools {
    public String doPost(String URL, String jsonStr) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        InputStream is = null;
        StringBuilder result = new StringBuilder();
        HttpURLConnection conn = null;
        try {
            java.net.URL url = new URL(URL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            // 发送POST请求必须设置为true
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 设置连接超时时间和读取超时时间
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(10000);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            // 获取输出流
            out = new OutputStreamWriter(conn.getOutputStream());
            out.write(jsonStr);
            out.flush();
            out.close();
            // 取得输入流，并使用Reader读取
            if (200 == conn.getResponseCode()) {
                // 获取响应头content-encoding数据，如果是gzip就解压（以后可能要改成部分对比.contains()而不是全部对比）
                String contentEncoding = conn.getHeaderField("content-encoding");
                if((contentEncoding != null)&&(contentEncoding.equals("gzip"))){
                    is = new GZIPInputStream(conn.getInputStream());
                }else{
                    is = conn.getInputStream();
                }
                in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String line;
                while ((line = in.readLine()) != null) {
                    result.append(line);
                    System.out.println(line);
                }
            } else {
                System.out.println("ResponseCode is an error code:" + conn.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return result.toString();
    }
    public String doGet(String URL) {
        HttpURLConnection conn = null;
        InputStream is = null;
        BufferedReader br = null;
        StringBuilder result = new StringBuilder();
        try {
            // 创建远程url连接对象
            URL url = new URL(URL);
            // 通过远程url连接对象打开一个连接，强转成HTTPURLConnection类
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            // 设置连接超时时间和读取超时时间
            conn.setConnectTimeout(15000);
            conn.setReadTimeout(60000);
            conn.setRequestProperty("accept-encoding","gzip, deflate, br");
            conn.setRequestProperty("User-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36 Edg/98.0.1108.62");

            // 设置请求体（可选）
            //Map map = new HashMap<>();
            //map.put("aa","bbb");
            //conn.setDoOutput(true);
            //DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            //out.writeBytes(JSON.toJSONString(map));
            //out.flush();
            //out.close();

            // 发送请求
            conn.connect();
            // 通过conn取得输入流，并使用Reader读取
            if (200 == conn.getResponseCode()) {
                // 获取响应头content-encoding数据，如果是gzip就解压（以后可能要改成部分对比.contains()而不是全部对比）
                String contentEncoding = conn.getHeaderField("content-encoding");
                if((contentEncoding != null)&&(contentEncoding.equals("gzip"))){
                    is = new GZIPInputStream(conn.getInputStream());
                }else{
                    is = conn.getInputStream();
                }
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line);
                    System.out.println(line);
                }
            } else {
                System.out.println("ResponseCode is an error code:" + conn.getResponseCode());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            conn.disconnect();
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(new HttpURLConnectionTools().doGet("http://localhost:8082/body"));
        //System.out.println(new HttpURLConnectionTools().doGet("http://api.wpbom.com/api/neran.php"));
    }
}