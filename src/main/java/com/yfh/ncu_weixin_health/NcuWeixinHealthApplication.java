package com.yfh.ncu_weixin_health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class NcuWeixinHealthApplication {

    public static void main(String[] args) {
        SpringApplication.run(NcuWeixinHealthApplication.class, args);
    }

}
