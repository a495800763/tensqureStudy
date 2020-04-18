package com.tensquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @program: com.tensquare
 * @author: liumq
 * @create: 2020-04-18 10:22
 **/
@SpringBootApplication
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class,args);
    }


    @Bean
    public IdWorker idWorker()
    {
        return new IdWorker(1,1);
    }

}
