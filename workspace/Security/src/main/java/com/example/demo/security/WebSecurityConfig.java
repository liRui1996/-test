package com.example.demo.security;

import com.example.demo.impl.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //用Resource依赖注入的话就需要在类里面加入@Service把类加入到容器
    @Resource
    private CustomUserService customUserService;

    //用bean的话相当于产生了一个bean对象放入到容器 对应的类不能用 @Service
//    @Bean
//    public CustomUserService customUserService(){
//        return new CustomUserService();
//    }
    @Override
     protected void configure(HttpSecurity http){
        try {
            http
                    .formLogin()       //启用默认登录页面
                    .failureUrl("/login?error")       //登录失败返回页面
                    .defaultSuccessUrl("/ayUser/test")  //登录成功跳转页面
                    .permitAll();           //登录页面全部权限可访问
            super.configure(http);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(customUserService)
                .passwordEncoder(new MyPasswordEncoder());
//        auth
//                .inMemoryAuthentication()
//                .passwordEncoder(new MyPasswordEncoder())
//                .withUser("张三").password("123456").roles("ADMIN")
//                .and()
//                .withUser("李四").password("654321").roles("USER");

    }



}
