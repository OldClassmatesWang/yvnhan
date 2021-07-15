package com.baizhou.yvnhan.service.impl;

import com.baizhou.yvnhan.dto.TokenInfo;
import com.baizhou.yvnhan.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author HaiPeng Wang
 * @date 2021/7/15 16:16
 * @Description:
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired


    /**
     * 从Redis获取token的信息
     *
     * @param accessToken
     * @return
     */
    @Override
    public TokenInfo getTokenInfo(String accessToken) {
        return null;
    }

    /**
     * 更新Redis中的token信息
     *
     * @param accessToken
     * @param userId
     */
    @Override
    public void refreshToken(String accessToken, String userId) {

    }
}
