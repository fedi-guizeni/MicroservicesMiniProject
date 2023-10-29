package com.zyga.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FraudMain {
    public static void main(String[] args) {
        SpringApplication.run(FraudMain.class , args);
    }
}
