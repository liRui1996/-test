package com.example.demo.Listener;

import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;
import org.hibernate.annotations.Source;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import sun.rmi.log.LogInputStream;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class AyUserListener implements ServletContextListener {

//    @Resource
//    private RedisTemplate redisTemplate;
//    @Resource
//    private AyUserService ayUserService;

    private static final String ALL_USER = "ALL_USER_LIST";
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext 上下文初始化");

        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent.getServletContext());
        AyUserService ayUserService = context.getBean(AyUserService.class);
        List<AyUser> list = ayUserService.findAll();
        System.out.println(list.size());
////        查询所有用户
//       List<AyUser> list =  ayUserService.findAll();
//       //清除缓存中的用户数据
//       redisTemplate.delete("ALL_USER");
//       //将数据放到缓存中
//       redisTemplate.opsForList().leftPushAll("ALL_USER",list);
//       //真实项目需要注释掉 查询所有用户书籍
//        List<AyUser> querylist = redisTemplate.opsForList().range("ALL_USER",0,-1);
//        System.out.println(querylist.size());
//        System.out.println(querylist);


    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext 上下文销毁");
    }
}
