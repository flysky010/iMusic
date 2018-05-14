package com.ssm.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
 
/**
 * 使用Jedis来测试redis
 * @author hc
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:spring-redis.xml")
public class SpringRedisTest extends AbstractJUnit4SpringContextTests{
 
    @Autowired
    private JedisPool jedisPool;
     
    @Test
    public void basicTest(){
        Jedis jedis = jedisPool.getResource();
        //存值
        jedis.set("user.name", "aaa");
        jedis.set("user.pass", "123");
         
        //取值
        String name = jedis.get("user.name");
        String pass = jedis.get("user.pass");
        //断言
        Assert.assertEquals("aaa", name);
        //Assert.assertEquals("1234", pass);//错误
        Assert.assertEquals("123", pass);
         
        jedis.del("user.name");
        Boolean result = jedis.exists("user.name");
        Assert.assertEquals(false, result);
         
        result = jedis.exists("user.pass");
        Assert.assertEquals(true, result);
         
        jedis.close();
    }
}
//SpringRedisTest

