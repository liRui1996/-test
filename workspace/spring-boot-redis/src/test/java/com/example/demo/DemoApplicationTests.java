package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {



	@Resource
	private RedisTemplate redisTemplate;



	@Autowired(required = false)
	public void setRedisTemplate(RedisTemplate redisTemplate) {
		RedisSerializer stringSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringSerializer);
		redisTemplate.setValueSerializer(stringSerializer);
		redisTemplate.setHashKeySerializer(stringSerializer);
		redisTemplate.setHashValueSerializer(stringSerializer);
		this.redisTemplate = redisTemplate;
	}


	@Resource
	private StringRedisTemplate stringRedisTemplate;
	@Test
	void contextLoads() {
		/*两种方式访问redis*/

		//不用反序列化string 只针对键值都是字符串的类型
		stringRedisTemplate.opsForValue().set("qwe","aaa");
		String name1 =  stringRedisTemplate.opsForValue().get("qwe");
		//System.out.println(name1);
		stringRedisTemplate.delete("qwe");

		//	使用redisTemplate需要反序列化string类型 否则存储到redis的是序列化的类型
		redisTemplate.opsForValue().set("String_name","valve");
		String name = (String) redisTemplate.opsForValue().get("String_name");
		System.out.println(name);
		//redisTemplate.delete("String_name");


		List list = new ArrayList();
		list.add("1");
		list.add("2");
		System.out.println(list);
		//会报错因为系列化制定了string类型
		redisTemplate.opsForList().leftPush("user_list",list);
		redisTemplate.opsForList().leftPush("user_list","111");
		redisTemplate.opsForList().leftPush("user_list","222");
		System.out.println(redisTemplate.opsForList().range("user_list",0,-1));
//		redisTemplate.delete("user_list");

		redisTemplate.opsForSet().add("user_set","aaa","BBBB","CCC");
		System.out.println(redisTemplate.opsForSet().members("user_set"));
//		redisTemplate.delete("user_set");

		redisTemplate.opsForHash().put("user_hash","name1","value1");
		redisTemplate.opsForHash().put("user_hash","name2","value2");
		System.out.println(redisTemplate.opsForHash().entries("user_hash"));
//		redisTemplate.delete("user_hash");

		redisTemplate.opsForZSet().add("user_zset","value1",0);
		redisTemplate.opsForZSet().add("user_zset","value2",2);
		System.out.println(redisTemplate.opsForZSet().range("user_zset",0,-1));
//		redisTemplate.delete("user_zset");







	}

}
