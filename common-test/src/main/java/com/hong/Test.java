package com.hong;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.date.DateUnit;
import com.alibaba.fastjson2.JSON;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static TimedCache<String, String> timedCache = CacheUtil.newTimedCache(DateUnit.DAY.getMillis() * 1);

    public static void main(String[] args) {
        String aa = timedCache.get("aa");
        System.out.println("before -- "+aa);

        timedCache.put("aa","bb", DateUnit.MINUTE.getMillis() * 50);

        String aaa = timedCache.get("aa");
        System.out.println("after -- "+aaa);

        System.out.println("----");
        //Map<String,String> map = new HashMap<String,String>();
        //map.put("a","aaa");
        //map.put("b","bbb");
        //map.put("c","ccc");
        //String json= JSON.toJSONString(map);
        //System.out.println(json);//输出{"a":"aaa","b":"bbb","c":"ccc"}

    }
}
