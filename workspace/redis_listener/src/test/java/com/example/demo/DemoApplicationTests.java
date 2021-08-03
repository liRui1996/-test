package com.example.demo;


import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	public AyUserService ayUserService;
	@Test
	void contextLoads() {

		List<AyUser> userList = ayUserService.findAll();
		System.out.println(userList.size());
//		List<AyUser> userList1 = ayUserService.findByName("����");
//		System.out.println(userList1.size());
//		List<AyUser> userList2 = ayUserService.findByNameLike("%%");
//		System.out.println(userList2.size());
//
//		List<String> ids = new ArrayList<>();
//		ids.add("1");
//		ids.add("2");
//		List<AyUser> userList3 = ayUserService.findByIdIn(ids);
//		System.out.println(userList3.size());
//
//		//��ҳ��ѯ
//		//rt sort = NEW;
//		//Sort.Direction.ASC ���� Sort.Direction.DESC ����
//		PageRequest pageRequest = PageRequest.of(0,2,Sort.by(Sort.Direction.DESC, "id"));
//		Page<AyUser> userlist4 = ayUserService.findAll(pageRequest);
//
//		System.out.println(userlist4.getPageable()+"/"+userlist4.getSize());
//
//		for (AyUser ayUser: userlist4
//			 ) {
//			System.out.println(ayUser.toString());
//
//		}
//		���
//		AyUser ayUser = new AyUser();
//		ayUser.setId("3");
//		ayUser.setName("����");
//		ayUser.setPassword("111111");
//		ayUserService.save(ayUser);
////		ɾ��
//		ayUserService.delete("3");



	}

}
