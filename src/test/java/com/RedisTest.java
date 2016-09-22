package com;
import org.springframework.context.ApplicationContext;

public class RedisTest {
	
	private ApplicationContext ac;

	/*@Test
	public void set(){
		ac = new ClassPathXmlApplicationContext(new String[]{"classpath:/spring/spring-redis.xml"});
        RedisClientTemplate redisClient = (RedisClientTemplate)ac.getBean("redisClientTemplate");
        redisClient.set("a", "abc");
        System.out.println(redisClient.get("a"));
	}*/

}
