package com.ssm.controller.redis;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserRedisController {

	@Resource(name="redisTemplate")
    private ListOperations<String, String[]> listUser;
     
    @RequestMapping("/list")
    @ResponseBody
    public List<String[]> list(){
        List<String[]> list=listUser.range("user", 0, -1);
        return list;
    }
     
    @RequestMapping("/add")
    @ResponseBody
    public void add(String... user){
        listUser.leftPush("user", user);
    }
}
