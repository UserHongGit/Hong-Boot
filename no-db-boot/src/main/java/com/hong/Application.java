package com.hong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 环境:
 *      胜软接口是Get+Body传参方式, 且Response为Gzip压缩
 * 项目:
 *   没有数据源
 *   整合OpenFeign调用 --> 需要注意的是, 整合的feign是cloud的,
 *      注意当前项目parent的Boot版本和Cloud的版本一致,
 *      不然会报错: NoSuchMethodError: feign.Response.create(ILjava/lang/Strin
 *                 creating bean with name 'configurationPropertiesBeans' de
 *       再就是, Openfeign支持Get携带参数, 添加httpcomponents 和httpclient的依赖, 而且httpclient使用github的, 不要使用netflix的, 特么的
 *              然后在application.yml开启httpclient.enabled
 * util:
 *      SendGet: HttpClient的方式, 拓展Get请求可以携带Body参数发送, 如果Response为application/json可以正常使用, 暂时Gzip为调试通
 *      HttpURLConnectionTools: 网上找的, 普通的GetPost请求, 主要是为了将Response的Gzip压缩数据, 解压出来, 但是未测试
 *
 * config:
 *      HttpComponentsClientRestfulHttpRequestFactory: 使RestTemplate支持Get携带Body参数发送, 参考HelloController.ttt()方法
 *
 *
 */
@EnableFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
