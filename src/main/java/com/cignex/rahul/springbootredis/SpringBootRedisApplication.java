package com.cignex.rahul.springbootredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SpringBootRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisApplication.class, args);
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
	    return factory;
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate()
	{
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setEnableTransactionSupport(true);
		return redisTemplate;
	}
}
