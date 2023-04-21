package com.hong;

import com.alibaba.fastjson2.JSON;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("a","aaa");
        map.put("b","bbb");
        map.put("c","ccc");
        String json= JSON.toJSONString(map);
        System.out.println(json);//输出{"a":"aaa","b":"bbb","c":"ccc"}

    }
}
