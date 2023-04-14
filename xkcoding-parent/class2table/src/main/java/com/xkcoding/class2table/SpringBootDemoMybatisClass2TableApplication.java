package com.xkcoding.class2table;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>
 * 启动器
 * </p>
 *
 */
@MapperScan({"com.gitee.sunchenbin.mybatis.actable.dao.*","com.xkcoding.class2table.mapper"}) //逗号前面直接复制不要更改,注意这里可以指定多个包,逗号间隔,逗号后面写自己的dao包路径
@ComponentScan({"com.gitee.sunchenbin.mybatis.actable.manager.*","com.xkcoding.class2table"}) //逗号前面直接复制不要更改,逗号后面写自己的controller层包路径
@SpringBootApplication
public class SpringBootDemoMybatisClass2TableApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoMybatisClass2TableApplication.class, args);
    }
}
