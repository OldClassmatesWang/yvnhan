package com.baizhou.yvnhan.bean.redis.impl;

import com.baizhou.yvnhan.bean.redis.RedisRepository;
import com.baizhou.yvnhan.bean.util.RedisUtil;
import com.baizhou.yvnhan.dto.TokenInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import static com.baizhou.yvnhan.bean.redis.RedisKeyTemplate.*;

/**
 * @author HaiPeng Wang
 * @date 2021/7/15 16:20
 * @Description:
 */
@Component
public class RedisRepositoryImpl implements RedisRepository {


    @Autowired
    RedisUtil redisUtil;

    @Autowired
    StringRedisTemplate redisTemplate;
    /**
     * 保存手机号和验证码的键值对<phone, messageCode>
     *
     *记录验证码信息
     *    键：Verification_Code:verificationCode
     *    值：{ verificationCode, phoneNumber }
     * @param phone
     * @param messageCode 验证码
     */
    @Override
    public void saveMessageCode(String phone, String messageCode) {
        redisUtil.set(
                redisTemplate,
                redisUtil.buildKey(T_VERIFICATION_CODE, phone), //{Verification:18636xxxxxx}
                messageCode);
    }

    /**
     * 保存sessionId 图形验证码
     *     记录验证码信息
     *    键：Verification_Code:verificationCode
     *    值：{ verificationCode, phoneNumber }
     * @param sessionId
     * @param code
     */
    @Override
    public void saveImageCode(String sessionId, String code) {
        redisUtil.set(redisTemplate,
                redisUtil.buildKey(T_VERIFICATION_CODE, sessionId),//{Verification:sersionId}
                code);
    }

    /**
     * 根据key：手机号 查询验证码
     *
     * @param phone
     * @return
     */
    @Override
    public String selectMessageCodeByPhone(String phone) {
        return redisUtil.<String>get(
                redisTemplate,
                redisUtil.buildKey(T_VERIFICATION_CODE, phone),
                String.class);
    }

    /**
     * 根据session搜索图形验证码
     *
     * @param sessionId
     * @return
     */
    @Override
    public String selectCodeBySession(String sessionId) {
        return redisUtil.<String>get(redisTemplate, redisUtil.buildKey(T_VERIFICATION_CODE, sessionId), String.class);
    }

    /**
     * 删除session和code的键值对
     *
     * @param sessionId
     * @return
     */
    @Override
    public void deleteSessionCode(String sessionId) {
        redisUtil.del(redisTemplate, redisUtil.buildKey(T_VERIFICATION_CODE, sessionId));
    }

    /**
     * 删除手机号和验证码的键值对
     *
     * @param phone
     */
    @Override
    public void deleteMessageCode(String phone) {
        redisUtil.del(redisTemplate, redisUtil.buildKey(T_VERIFICATION_CODE, phone));
    }

    /**
     * 认证
     *
     * @param tokenInfo
     */
    @Override
    public void saveAccessToken(TokenInfo tokenInfo) {
        String key  = redisUtil.buildKey(T_ACCESS_TOKEN, tokenInfo.getAccessToken());
        redisUtil.set(redisTemplate,key , tokenInfo.getUserId());
        redisUtil.expire(redisTemplate,key);
    }

    /**
     * 登录认证
     *
     * @param tokenInfo
     */
    @Override
    public void saveLoginAccessToken(TokenInfo tokenInfo) {
        String key = redisUtil.buildKey(T_USER_CURRENT_TOKEN, tokenInfo.getUserId());
        redisUtil.set(redisTemplate,key , tokenInfo.getAccessToken());
        redisUtil.expire(redisTemplate,key);
    }

    /**
     * 查询认证
     *
     * @param accessToken
     * @return
     */
    @Override
    public String selectAccessToken(String accessToken) {

        return redisUtil.<String>get(redisTemplate, redisUtil.buildKey(T_ACCESS_TOKEN, accessToken), String.class);
    }

    /**
     * 查询登录认证
     *
     * @param userId
     * @return
     */
    @Override
    public String selectLoginAccessToken(String userId) {

        return redisUtil.<String>get(redisTemplate, redisUtil.buildKey(T_USER_CURRENT_TOKEN, userId), String.class);
    }

    /**
     * 删除认证
     *
     * @param accessToken
     */
    @Override
    public void deleteAccessToken(String accessToken) {
        redisUtil.del(redisTemplate, redisUtil.buildKey(T_ACCESS_TOKEN, accessToken));
    }

    /*
     * 删除登录认证
     *
     * @param userId
     */
    @Override
    public void deleteLoginAccessToken(String userId) {
        redisUtil.del(redisTemplate, redisUtil.buildKey(T_USER_CURRENT_TOKEN, userId));
    }

    /**
     * 刷新token时间
     *
     * @param accesstoken
     * @param userId
     * @return
     */
    @Override
    public void refreshLoginToken(String accesstoken, String userId) {
        redisUtil.expire(redisTemplate,accesstoken);
        redisUtil.expire(redisTemplate,userId);
    }

    @Override
    public void saveLoginTime(String userId, String loginTime) {
        redisUtil.set(redisTemplate,redisUtil.buildKey(T_USER_LOGIN_TIME, userId), loginTime);
    }

    @Override
    public String selectLoginTimeByUser(String userId) {

        return redisUtil.<String>get(redisTemplate,redisUtil.buildKey(T_USER_LOGIN_TIME, userId), String.class);
    }

    @Override
    public void deleteLoginTime(String userId) {
        redisUtil.del(redisTemplate, redisUtil.buildKey(T_USER_LOGIN_TIME, userId));

    }
}
