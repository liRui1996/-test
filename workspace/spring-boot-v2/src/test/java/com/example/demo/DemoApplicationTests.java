package com.example.demo;

import com.example.demo.model.AyUserAttachmentRel;
import com.example.demo.model.Bookproperties;
import com.example.demo.model.Userproperites;
import com.example.demo.service.AyUserAttachmentRelService;
import com.example.dome.api.AyUserDubboService;
import com.example.dome.domain.AyUser;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	@Resource
	private AyUserAttachmentRelService ayUserAttachmentRelService;
	@Test
	void MongoDb() {
		AyUserAttachmentRel ayUserAttachmentRel = new AyUserAttachmentRel();
		ayUserAttachmentRel.setId("1");
		ayUserAttachmentRel.setUserId("1");
		ayUserAttachmentRel.setFilename("简历.doc");
		ayUserAttachmentRelService.save(ayUserAttachmentRel);
		System.out.println("保存成功");

	}
	@Reference(version = "1.0")
	private AyUserDubboService ayUserDubboService;
	@Test
	void dubbotest(){

		AyUser ayUser = ayUserDubboService.FindBuUserNameAndPassword("a","a");
		System.out.println(ayUser.toString());

	}

	@Resource
	private Bookproperties bookproperties;
	@Resource
	private Userproperites userproperites;
	@Test
	void test(){
//
//		System.out.println(bookproperties.getAuther());
//		System.out.println(bookproperties.getName());
//		System.out.println(bookproperties.getAll());
		System.out.println(bookproperties.toString());
		System.out.println(userproperites.getUserName());
	}

}
