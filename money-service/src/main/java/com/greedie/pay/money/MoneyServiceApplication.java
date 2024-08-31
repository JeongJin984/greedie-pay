package com.greedie.pay.money;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("com.greedie.pay.common")
public class MoneyServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoneyServiceApplication.class, args);
    }

}