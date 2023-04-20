package com.hong.service.impl;

import com.hong.bo.*;
import com.hong.call.CcusClient;
import com.hong.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private CcusClient CcusClient;

    String filePath = "D:\\StudyIdea2\\summary-gitee\\工作记录\\中科\\ccus\\井数据\\";
    @Override
    public void dataToCache(String type,String sbbm) {
        log.info("接收到的type:{}",type);
        switch (type) {
            case "BENG":
                List<Beng> d1 = CcusClient.getData(type,sbbm, Beng.class);
                log.info("转换成功, size:{}",d1.size());
                d1.forEach(System.out::println);
                break;
            case "DDF":
                List<Ddf> d2 = CcusClient.getData(type,sbbm, Ddf.class);
                log.info("转换成功, size:{}",d2.size());
                d2.forEach(System.out::println);
                break;
            case "GUAN":
                List<Guan> d3 = CcusClient.getData(type,sbbm, Guan.class);
                log.info("转换成功, size:{}",d3.size());
                d3.forEach(System.out::println);
                break;
            case "KRQT":
                List<Krqt> d4 = CcusClient.getData(type,sbbm, Krqt.class);
                log.info("转换成功, size:{}",d4.size());
                d4.forEach(System.out::println);
                break;
            case "LLJ":
                List<Llj> d5 = CcusClient.getData(type,sbbm, Llj.class);
                log.info("转换成功, size:{}",d5.size());
                d5.forEach(System.out::println);
                break;
            case "ZNDB":
                List<Zndb> d6 = CcusClient.getData(type,sbbm, Zndb.class);
                log.info("转换成功, size:{}",d6.size());
                d6.forEach(System.out::println);
                break;
            default:
                throw new RuntimeException("没有做假数据");
        }


    }







}
