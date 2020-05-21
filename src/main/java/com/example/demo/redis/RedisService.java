package com.example.demo.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;
//    @Autowired
//    RedisPoolFactory redisPoolFactory;

    public <T> T get(String key,Class<T> clazz){
//        Jedis jedis = jedisPool.getResource();
//        JedisPool jedisPool = redisPoolFactory.JedisPoolFactory();
        Jedis jedis = jedisPool.getResource();
        String str = jedis.get(key);
        return StringToBean(str,clazz);
    }
    public boolean set(String key, String value){
//        JedisPool jedisPool = redisPoolFactory.JedisPoolFactory();
        Jedis jedis = jedisPool.getResource();
        if(key!=null||key!=""&&value!=null){
            jedis.set(key,value);
            return true;
        }
        return false;
    }

    private <T> T StringToBean(String str, Class<T> clazz) {
        if(str==null||str.length()<=0||clazz==null){
            return null;
        }
        if(clazz==int.class||clazz==Integer.class){
            return (T)Integer.valueOf(str);
        }else if(clazz==String.class){
            return (T)str;
        }else if(clazz==long.class||clazz==Long.class){
            return (T)Long.valueOf(str);
        }else{
            return JSON.toJavaObject(JSON.parseObject(str),clazz);
        }
    }
}
