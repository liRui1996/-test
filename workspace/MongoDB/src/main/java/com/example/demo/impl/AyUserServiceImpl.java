package com.example.demo.impl;

import com.example.demo.dao.AyUserDao;
import com.example.demo.error.BusinessException;
import com.example.demo.model.AyUser;
import com.example.demo.repository.AyUserRepository;
import com.example.demo.service.AyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

//@Transactional 开始事务管理 注解放到类上面所有public方法都生效 放到方法上面只有当前方法生效
//@Transactional
@Service
public class AyUserServiceImpl implements AyUserService {

    @Resource
    private AyUserRepository ayUserRepository;
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private AyUserDao ayUserDao;
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
    public List<AyUser> findAll()
    {
        System.out.println("开始做任务");
        long start = System.currentTimeMillis();
        List<AyUser> ayUserList = ayUserRepository.findAll();
        long end = System.currentTimeMillis();
        System.out.println("完成任务，耗时："+(end-start)+"毫秒秒");
        return ayUserList;
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

    @Override
    public AyUser FindByNameAndPassword(String id) {
        return ayUserDao.FindByNameAndPassword(id);
    }

    @Override
    public AyUser FindById(String id) {
        return ayUserDao.FindById(id);
    }

    @Override
    @Async
    public Future<List<AyUser>> findASynAll() {
        System.out.println("开始做任务");
        long start = System.currentTimeMillis();
        List<AyUser> ayUserList = ayUserRepository.findAll();
        long end = System.currentTimeMillis();
        System.out.println("完成任务，耗时："+(end-start)+"毫秒秒");
        return new AsyncResult<List<AyUser>>(null);
    }

    @Override
    @Retryable(value = {BusinessException.class},maxAttempts = 5,backoff = @Backoff(delay = 5000,multiplier = 2))
    public AyUser findByNameAndPasswordRetry(String name, String password) {
        System.out.println("[findByNameAndPasswordRetry]方法失败重试了！");
        throw new BusinessException();
        //return null;
    }
}

