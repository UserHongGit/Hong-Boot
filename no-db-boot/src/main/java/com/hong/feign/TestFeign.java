package com.hong.feign;

import com.hong.call.ccus.req.CcusBengRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author leon
 * @date 2023/4/18
 */
@FeignClient(name = "TestFegin", url = "http://localhost:8082")
public interface TestFeign {
    @GetMapping("/body")
    String test(@RequestBody Map map);


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam String name);
}
