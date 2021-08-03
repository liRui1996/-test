package com.example.demo.error;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig {
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return (container ->{
            ErrorPage error404page = new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
            ErrorPage error401page = new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
            ErrorPage error405page = new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
            container.addErrorPages(error401page,error404page,error405page);
        });
    }
}
