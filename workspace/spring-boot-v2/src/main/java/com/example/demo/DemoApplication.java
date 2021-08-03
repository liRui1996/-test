package com.example.demo;

import com.example.demo.model.Bookproperties;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//异步调用
@EnableAsync
//重试
@EnableRetry
//dubbo
@EnableDubbo
//配置处理器 如果在ConfigurationProperties处理的类有@Component等注入标签就不需要这个注解了
@EnableConfigurationProperties({Bookproperties.class})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
