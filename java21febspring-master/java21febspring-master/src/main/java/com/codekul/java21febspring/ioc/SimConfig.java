package com.codekul.java21febspring.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimConfig {

    @Bean
    public Jio getJio(){
        return new Jio();
    }

}
