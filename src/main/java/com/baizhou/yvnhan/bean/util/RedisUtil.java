package com.baizhou.yvnhan.bean.util;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HaiPeng Wang
 * @date 2021/7/15 14:17
 * @Description:
 */
@Component
public class RedisUtil {

    /**
     *
     * @param redisTemplate
     * @param key
     * @return
     * @description 判断是否存在某个键值对
     */
    public boolean exists(StringRedisTemplate redisTemplate, String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     *
     * @param redisTemplate
     * @param key
     * @param value
     * @param <T>
     *  向序列中中放入一个键值对
     */
    public <T> void set (StringRedisTemplate redisTemplate, String key, T  value) {
        redisTemplate.opsForValue().set(key, JsonUtil.toJson(value));
    }

    /**
     *
     * @param redisTemplate
     * @param key
     * @param clazz
     * @param <T>
     * @return
     * 根据key得到一个键值对
     */
    public <T> T get (StringRedisTemplate redisTemplate, String key, Class<T> clazz) {
        String value = redisTemplate.opsForValue().get(key);
        if (null != value) {
            return JsonUtil.toObject(value, clazz);
        }
        return null;
    }

    /**
     * @param redisTemplate
     * @param key
     * 根据key删除一个键值对
     */
    public  void del(StringRedisTemplate redisTemplate, String key) {
        redisTemplate.delete(key
        );
    }


    //right push 就是将字符串添加到序列的右边
    //left push  就是将字符串添加到序列的左边，也就是开头
    public <T> void rPush(StringRedisTemplate redisTemplate, String key, T value) {
        redisTemplate.opsForList().rightPush(key, JsonUtil.toJson(value));
    }

    /**
     *
     * @param redisTemplate
     * @param key
     * @param clazz
     * @param <T>
     * @return
     * 得到序列中key 放着的list
     */
    public  <T> List<T> getList(StringRedisTemplate redisTemplate, String key, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        long size = redisTemplate.opsForList().size(key);
        List<String> records = redisTemplate.opsForList()
                .range(key, 0,  size -  1);
        if (null != records) {
            list = records.stream()
                    .map(record -> JsonUtil.toObject(record, clazz))
                    .collect(Collectors.toList());
        }
        return list;
    }

    /**
     * 设置key 的过期时间，单位是以秒为单位
     * @param redisTemplate
     * @param key
     * @return
     */
    public  boolean expire(StringRedisTemplate redisTemplate , String key){
        Duration duration = Duration.ofSeconds(60*60);
        Boolean expire = redisTemplate.expire(key, duration);
        return expire;
    }

    /**
     * format number by template
     * @param template
     * @param args
     * @return
     */
    public  String buildKey(String template,String ...args){

        return String.format(template,args);
    }
}
