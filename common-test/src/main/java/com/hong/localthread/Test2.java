package com.hong.localthread;


import com.alibaba.ttl.TransmittableThreadLocal;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.concurrent.*;

/**
 * 线程之间的变量传递
 *  通过阿里TransmittableThreadLocal实现
 *  直接将ThreadLocal替换成TransmittableThreadLocal
 */
public class Test2 {
    static TransmittableThreadLocal<Map<String,String>> threadLocal = new TransmittableThreadLocal<>();

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Test2 t = new Test2();
        map.put("value","当前thread数据");
        threadLocal.set(map);

        List<Integer> bigli = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<List<Integer>> subli = Lists.partition(bigli, 2);
        List<Future<?>> futureList = Lists.newArrayList();


        subli.forEach(e->{
            CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
                String s = t.doBusiness(e);
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
    }


    public String doBusiness(List<Integer> subli){
        System.out.println("subThread start --> doBusiness() --> Thread:"
                +Thread.currentThread().getName()
                +", get Main local Var:"+threadLocal.get()
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
}
