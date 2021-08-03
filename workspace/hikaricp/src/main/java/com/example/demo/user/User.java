
package com.example.demo.user;

import java.io.Serializable;

public class User extends Person {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String name;
    private String password;

    public User() {

    }

    public User(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "this is user:" + "name:" + this.name + "——password:" + this.password + "——age:" + this.age;
    }

}
