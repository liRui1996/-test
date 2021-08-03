package com.example.demo.impl;

import com.example.demo.model.AyUser;
import com.example.demo.repository.AyUserRepository;
import com.example.demo.service.AyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
//@Transactional 开始事务管理 注解放到类上面所有public方法都生效 放到方法上面只有当前方法生效
//@Transactional
@Service
public class AyUserServiceImpl implements AyUserService {

    @Resource
    private AyUserRepository ayUserRepository;
    @Resource
    private RedisTemplate redisTemplate;
    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
       // redisTemplate.setKeySerializer(stringSerializer);
        //redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }
    @Override
    public AyUser findById(String id) {
        return ayUserRepository.findById(id).get();
    }

    @Override
    public List<AyUser> findAll() {
        return ayUserRepository.findAll();
    }

    //@Transactional
    @Override
    public AyUser save(AyUser ayUser) {
        AyUser saveUser = ayUserRepository.save(ayUser);
        //出现空指针异常 测试事务是否开启
        String error = null;
        error.split("/");
        return saveUser;

    }

    @Override
    public void delete(String id) { ayUserRepository.deleteById(id); }

    @Override
    public Page<AyUser> findAll(Pageable pageable){return ayUserRepository.findAll(pageable);}

    @Override
    public List<AyUser> findByName(String name) { return ayUserRepository.findByName(name); }

    @Override
    public List<AyUser> findByNameLike(String name) { return ayUserRepository.findByNameLike(name); }

    @Override
    public List<AyUser> findByIdIn(Collection<String> ids) { return ayUserRepository.findByIdIn(ids);}

    @Override
    public void redissave(List list) {
        System.out.println(list);
        redisTemplate.delete("all");
        redisTemplate.opsForList().leftPushAll("all",list);
        List<AyUser> list1 =redisTemplate.opsForList().range("all",0,-1);
        for (AyUser ayUser: list1
             ) {
            System.out.println(ayUser.getName()+"-"+ayUser.getPassword());

        }
        System.out.println(redisTemplate.opsForList().range("all",0,-1));

//        插入
        AyUser  ayUser =findById("1");
        redisTemplate.opsForList().leftPush("all",ayUser);
        System.out.println("添加后："+redisTemplate.opsForList().range("all",0,-1));

    }
}

