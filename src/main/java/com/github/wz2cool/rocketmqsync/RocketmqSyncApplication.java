package com.github.wz2cool.rocketmqsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RocketmqSyncApplication {

    public static void main(String[] args) {

        SpringApplication.run(RocketmqSyncApplication.class, args);
    }

}
