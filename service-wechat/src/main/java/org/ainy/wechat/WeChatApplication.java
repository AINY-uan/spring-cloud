package org.ainy.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author AINY
 * @description WeChat启动类
 * @date 2019-08-01 16:38
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class WeChatApplication {

    public static void main(String[] args) {

        SpringApplication.run(WeChatApplication.class, args);
    }
}
