package com.hong.tongdun;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 同盾线程池用法测试
 *      这样是可以让子线程多个任务并行的
 */
public class Main {
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
        executor.setMaxPoolSize(200);
        executor.setCorePoolSize(50);
        executor.setQueueCapacity(1000);
        executor.setKeepAliveSeconds(300);
        // 线程池对拒绝任务(无线程可用)的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        Main m = new Main();
        Future<String> submit = executor.submit(() -> m.dosth());
        Future<String> submit2 = executor.submit(() -> m.dosth());
        try {
            // 这里会直接将submit1 和submit2同时提交, 同时执行dosth, 且是不同的线程
            // 之后同时输出sumit -->  和sumit1 -->
            String s = submit.get();
            System.out.println("submit --> "+s);
            String s1 = submit2.get();
            System.out.println("submit1 --> "+s1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"end --- ");


    }
}
