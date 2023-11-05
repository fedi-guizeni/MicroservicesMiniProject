package com.zyga.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.zyga.customer",
                "com.zyga.amqp",
        }

)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.zyga.fraudClient"
)
public class CustomerMain {
    public static void main(String[] args) {
        SpringApplication.run(CustomerMain.class , args);
    }
}
