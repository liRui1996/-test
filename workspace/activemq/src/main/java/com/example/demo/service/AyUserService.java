package com.example.demo.service;

import com.example.demo.model.AyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

public interface AyUserService {
    AyUser findById(String id);

    List<AyUser> findAll();

    AyUser save(AyUser ayUser);

    void delete(String id);

    //分页
    Page<AyUser> findAll(Pageable pageable);

    //    自定义查询方法

    List<AyUser> findByName(String name);
    //like查询
    List<AyUser> findByNameLike(String name);
    //通过主键集合查询 in(?，？，？)
    List<AyUser> findByIdIn(Collection<String> ids);

    void redissave(List list);

    AyUser FindByNameAndPassword(String id);

    AyUser FindById(String id);

    Future<List<AyUser>> findASynAll();

}
