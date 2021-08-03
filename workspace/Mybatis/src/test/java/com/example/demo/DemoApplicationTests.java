package com.example.demo;

import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

	@Resource
	private AyUserService ayUserService;
	@Test
	void contextLoads() {
		AyUser ayUser = ayUserService.FindById("1");
		System.out.println(ayUser.getName()+"--"+ayUser.getPassword());

	}

}
