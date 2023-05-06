package com.hong.util;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.date.DateUnit;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Test {
    public static TimedCache<String, String> timedCache = CacheUtil.newTimedCache(DateUnit.DAY.getMillis() * 1);


}
