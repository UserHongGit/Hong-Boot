package com.hong.controller;

import com.google.common.collect.Lists;
import com.hong.interceptor.MyInterceptor;
import com.hong.service.OaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@RestController
public class OaController {
    @Autowired
    OaService oaService;

    public String doBusiness(List<Integer> subli){
        Object o = MyInterceptor.threadLocal.get();
        System.out.println("subThread start --> doBusiness() --> Thread:"
                +Thread.currentThread().getName()
                +", get Main local Var:"+ o
        );
        subli.forEach(e ->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.out.println(e);
        });
        return Thread.currentThread().getName();
    }
    @GetMapping("sboa")
    public String sboa(){
        Map map = (Map)MyInterceptor.threadLocal.get();

        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Integer> bigli = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<List<Integer>> subli = Lists.partition(bigli, 2);
        List<Future<?>> futureList = Lists.newArrayList();


        subli.forEach(e->{
            CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
                MyInterceptor.threadLocal.set(map);
                String s = doBusiness(e);
                return s;
            }, pool);
            futureList.add(future1);
        });
        try {
            while(futureList.size() > 0){
                Iterator<Future<?>> iterator = futureList.iterator();
                while (iterator.hasNext()){
                    Future<?> future = iterator.next();
                    if(future.isDone() && !future.isCancelled()){
                        Object o = future.get();
                        iterator.remove();
                    }else{
                        Thread.sleep(10);  //避免CPU高速运转
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main ok");

        oaService.threadLocalTest();
        return "ok!";
    }

}
