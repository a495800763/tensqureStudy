package com.tensquare.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @program: tensqureStudy
 * @author: liumq
 * @create: 2020-04-26 23:01
 **/
@SpringBootApplication
public class SearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class,args);
    }

    @Bean
    public IdWorker idWorker()
    {
        return new IdWorker(1,1);
    }

}
