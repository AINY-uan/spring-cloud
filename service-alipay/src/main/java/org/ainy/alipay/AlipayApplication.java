package org.ainy.alipay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: yuandong
 * @Description: Alipay服务启动类
 * @Date: 2019-08-01 16:30
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan(basePackages = "org.ainy.db.dao")
public class AlipayApplication {

    public static void main(String[] args) {

        SpringApplication.run(AlipayApplication.class, args);
    }
}
