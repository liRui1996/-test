package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class DemoApplicationTests {
    /**
     * DataSource 由谁定义？ java 官方
     * DataSource 定义了什么？ 定义了从数据库或连接池获取连接Connection的一种规范
     * 我们为什么要耦合于它？  类与之间存在依赖（耦合）时，尽量依赖于抽象规范。
     * 程序运行时这个变量指向的对象类型是谁？HikariDataSource 你是怎么知道的？
     */
    @Autowired
    public DataSource dataSource; //interface

    @Test
    public void testConnection() throws Exception {
        //通过datasource获取连接的一个过程是怎么样的
        System.out.println(dataSource.getConnection());
        //HikariProxyConnection@524566446 wrapping com.mysql.cj.jdbc.ConnectionImpl@73ba6fe6
    }

}
