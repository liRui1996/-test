package com.example.demo;

import com.example.demo.Producer.AyMoodProducer;
import com.example.demo.consumer.AyMoodConsumer;
import com.example.demo.model.AyMood;
import com.example.demo.model.AyUser;
import com.example.demo.service.AyMoodService;
import com.example.demo.service.AyUserService;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.jms.*;
import javax.print.attribute.standard.Destination;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

@SpringBootTest
class DemoApplicationTests {


	@Resource
	private AyMoodService ayMoodService;
	@Test
	void contextLoads() {
		AyMood ayMood = new AyMood();
		ayMood.setId("1");
		ayMood.setUserId("101");
		ayMood.setContent("张三");
		ayMood.setPraiseNum(0);
		ayMood.setPublishTime(new Date());
		ayMood = ayMoodService.save(ayMood);
		System.out.println(ayMood.getContent());
	}

	@Resource
	private AyMoodProducer ayMoodProducer;

	@Test
	void sendMq(){
//			Destination destination = new ActiveMQQueue("ay.queue");
		ayMoodProducer.SendMessage("ay.queue","nihao");



	}
	@Test
	void sendMqSave(){
		final  String queue = "ay.queue.asyn.save";
		AyMood ayMood = new AyMood();
		ayMood.setId("2");
		ayMood.setUserId("102");
		ayMood.setContent("李四");
		ayMood.setPraiseNum(1);
		ayMood.setPublishTime(new Date());
		ayMoodProducer.SendMessage(queue,ayMood);

	}




//	网上找的发送样例
	@Test
	public void testQueueProducer() throws Exception {
		AyMood ayMood = new AyMood();
		ayMood.setId("2");
		ayMood.setUserId("102");
		ayMood.setContent("李四");
		ayMood.setPraiseNum(1);
		ayMood.setPublishTime(new Date());


		// 第一步：创建ConnectionFactory对象，需要指定服务端ip及端口号。
		//brokerURL服务器的ip及端口号
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin","admin","tcp://localhost:61616");
		connectionFactory.setTrustAllPackages(true);
		// 第二步：使用ConnectionFactory对象创建一个Connection对象。
		Connection connection = connectionFactory.createConnection();
		// 第三步：开启连接，调用Connection对象的start方法。
		connection.start();
		// 第四步：使用Connection对象创建一个Session对象。
		//第一个参数：是否开启事务。true：开启事务，第二个参数忽略。
		//第二个参数：当第一个参数为false时，才有意义。消息的应答模式。1、自动应答2、手动应答。一般是自动应答。
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 第五步：使用Session对象创建一个Destination对象（topic、queue），此处创建一个Queue对象。
		//参数：队列的名称。
		Queue queue = session.createQueue("ay.queue.asyn.save");
		// 第六步：使用Session对象创建一个Producer对象。
		MessageProducer producer = session.createProducer(queue);
		// 第七步：创建一个Message对象，创建一个TextMessage对象。
        /*TextMessage message = new ActiveMQTextMessage();
        message.setText("hello activeMq,this is my first test.");*/
		TextMessage textMessage = (TextMessage) session.createObjectMessage(ayMood);
		// 第八步：使用Producer对象发送消息。
		producer.send(textMessage);
		// 第九步：关闭资源。
		producer.close();
		session.close();
		connection.close();
	}
	@Resource
	private AyUserService ayUserService;
	@Test
	public void testAsync(){
		long start = System.currentTimeMillis();
		System.out.println("第一次查询所有用户");
		List<AyUser> ayUserList = ayUserService.findAll();
		System.out.println("第二次查询所有用户");
		List<AyUser> ayUserList1 = ayUserService.findAll();
		System.out.println("第三次查询所有用户");
		List<AyUser> ayUserList2 = ayUserService.findAll();
		System.out.println("第四次查询所有用户");
		List<AyUser> ayUserList3 = ayUserService.findAll();
		long end = System.currentTimeMillis();
		System.out.println("总耗时："+(end-start)+"毫秒");
	}

	@Test
	public void testAsync2() throws InterruptedException {
		long start = System.currentTimeMillis();
		System.out.println("第一次查询所有用户");
		Future<List<AyUser>> ayUserList = ayUserService.findASynAll();
		System.out.println("第二次查询所有用户");
		Future<List<AyUser>>  ayUserList1 = ayUserService.findASynAll();
		System.out.println("第三次查询所有用户");
		Future<List<AyUser>>  ayUserList2 = ayUserService.findASynAll();
		System.out.println("第四次查询所有用户");
		Future<List<AyUser>>  ayUserList3 = ayUserService.findASynAll();
		while (true){
			if (ayUserList.isDone()&&ayUserList1.isDone()&&ayUserList2.isDone()&&ayUserList3.isDone()){
				break;
			}else{
				Thread.sleep(10);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("总耗时："+(end-start)+"毫秒");
	}


}
