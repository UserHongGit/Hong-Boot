package com.hong.tongdun;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 同盾线程池用法测试
 *      这样是可以让子线程多个任务并行的
 */
public class Main2 {
    public String dosth(){
        System.out.println(Thread.currentThread().getId() +"-----------------");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName()+"ok";
    }
    public static void main(String[] args) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(10);
        executor.setCorePoolSize(1);
        executor.setQueueCapacity(0);
        executor.setKeepAliveSeconds(300);
        // 线程池对拒绝任务(无线程可用)的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        Main2 m = new Main2();
        Future<String> submit = executor.submit(() -> m.dosth());
        Future<String> submit2 = executor.submit(() -> m.dosth());
        Future<String> submit3 = executor.submit(() -> m.dosth());
        try {
            String s = submit.get();
            System.out.println("submit --> "+s);
            String s1 = submit2.get();
            System.out.println("submit2 --> "+s1);
            String s3 = submit3.get();
            System.out.println("submit3 --> "+s1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"end --- ");


    }
}
