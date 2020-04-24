package com.tensquare.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @program: tensqureStudy
 * @author: liumq
 * @create: 2020-04-24 20:45
 **/
@SpringBootApplication
public class spitApplication {
    public static void main(String[] args) {
        SpringApplication.run(spitApplication.class,args);
    }

    @Bean
    public IdWorker idWorkker(){
        return new IdWorker();
    }
}
