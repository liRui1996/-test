package com.example.demo.repository;

import com.example.demo.model.AyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AyUserRepository extends JpaRepository<AyUser,String>{

//    自定义查询方法

    List<AyUser> findByName(String name);
    //like查询
    List<AyUser> findByNameLike(String name);
    //通过主键集合查询 in(?,?,?)
    List<AyUser> findByIdIn(Collection<String> ids);



}
