package com.hong.common;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 关于测试时候, 任务执行完毕, JVM不退出问题
 *      executor.shutdown();
 *      创建的子线程, 有核心线程Worker, 他创建出来以后就会等着干活, 而不是干完你这件事,就自杀,
 *      所有测试时候, 想要子线程执行完任务就停止, 需要手动的在下边shutdown(),这样JVM就会退出去了
 */
public class Test1 {
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

        Test1 m = new Test1();
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
        executor.shutdown();
        System.out.println(Thread.currentThread().getName()+"end --- ");


    }
}
