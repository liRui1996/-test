package com.example.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
//springboot添加配置处理器pom 使用该注释就不需要每个字段加@value
@ConfigurationProperties(prefix = "com.ay.book")
public class Bookproperties {

//    @Value("${com.ay.book.name}")
    private String name;
//    @Value("${com.ay.book.auther}")
    private String auther;

    private String all;

    private String randomValue;
    private int randomInt;
    private long randomLong;
    private String ramdomUuid;
    private int randomLen;
    private int randomRange;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(String randomValue) {
        this.randomValue = randomValue;
    }

    public int getRandomInt() {
        return randomInt;
    }

    public void setRandomInt(int randomInt) {
        this.randomInt = randomInt;
    }

    public long getRandomLong() {
        return randomLong;
    }

    public void setRandomLong(long randomLong) {
        this.randomLong = randomLong;
    }

    public String getRamdomUuid() {
        return ramdomUuid;
    }

    public void setRamdomUuid(String ramdomUuid) {
        this.ramdomUuid = ramdomUuid;
    }

    public int getRandomLen() {
        return randomLen;
    }

    public void setRandomLen(int randomLen) {
        this.randomLen = randomLen;
    }

    public int getRandomRange() {
        return randomRange;
    }

    public void setRandomRange(int randomRange) {
        this.randomRange = randomRange;
    }

    @Override
    public String toString() {
        return "Bookproperties{" +
                "name='" + name + '\'' +
                ", auther='" + auther + '\'' +
                ", all='" + all + '\'' +
                ", randomValue='" + randomValue + '\'' +
                ", randomInt=" + randomInt +
                ", randomLong=" + randomLong +
                ", ramdomUuid='" + ramdomUuid + '\'' +
                ", randomLen=" + randomLen +
                ", randomRange=" + randomRange +
                '}';
    }
}
