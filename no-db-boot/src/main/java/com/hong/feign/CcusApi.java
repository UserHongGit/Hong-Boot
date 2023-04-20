package com.hong.feign;

import com.hong.call.ccus.req.CcusBengRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author leon
 * @date 2023/4/18
 */
@FeignClient(name = "CcusApi", url = "http://pcs.slof.com:80/kdr/kay:dsc:1.0/")
public interface CcusApi {
    @GetMapping("services/single/getDqBeng.json")
    String getDqBeng(@RequestBody CcusBengRequest request);
}
