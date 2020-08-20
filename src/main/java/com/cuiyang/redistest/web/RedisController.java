package com.cuiyang.redistest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class RedisController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    ValueOperations<String, String> valueOperations;
    SetOperations<String, String> setOperations;

    @PostConstruct
    public void init() {
        valueOperations = redisTemplate.opsForValue();
        setOperations = redisTemplate.opsForSet();
    }

    @RequestMapping("get")
    // http://localhost:8080/get?key=
    public String get(String key) {
        return valueOperations.get(key).toString();
    }

    @RequestMapping("set")
    // http://localhost:8080/set?key= & value =
    public void set(String key, String value) {
        valueOperations.set(key, value);
    }

    @RequestMapping("setSet")
    // http://localhost:8080/setSet?key= & value =
    public void setSet(String key, String value) {
        setOperations.add(key,value);
    }


    @RequestMapping("setget")
    // http://localhost:8080/setSet?key=
    public String setget(String key) {
        return "set大小:"+setOperations.size(key)+"成员:"+setOperations.members(key).toString();
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 2);
    }
}
