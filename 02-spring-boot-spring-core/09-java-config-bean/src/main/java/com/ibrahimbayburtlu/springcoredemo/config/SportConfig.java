package com.ibrahimbayburtlu.springcoredemo.config;

import com.ibrahimbayburtlu.springcoredemo.common.Coach;
import com.ibrahimbayburtlu.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }

}
