package com.mlimavieira.samplespringvalidation.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfig {

    @Bean
    public DozerBeanMapper dozerBeanMapper() {

        DozerBeanMapper dozerBean = new DozerBeanMapper();

        return dozerBean;
    }
}
