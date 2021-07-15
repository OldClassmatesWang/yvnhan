package com.baizhou.yvnhan.service;

import com.baizhou.yvnhan.dto.TokenInfo;

/**
 * @author HaiPeng Wang
 * @date 2021/7/15 16:13
 * @Description:
 */

public interface TokenService {

    /**
     * 从Redis获取token的信息
     * @param accessToken
     * @return
     */
    TokenInfo getTokenInfo(String accessToken);

    /**
     * 更新Redis中的token信息
     * @param accessToken
     */
    void refreshToken(String accessToken,String userId);
}
