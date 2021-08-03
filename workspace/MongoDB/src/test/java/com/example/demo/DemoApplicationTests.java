package com.example.demo;

import com.example.demo.model.AyUserAttachmentRel;
import com.example.demo.service.AyUserAttachmentRelService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

}
