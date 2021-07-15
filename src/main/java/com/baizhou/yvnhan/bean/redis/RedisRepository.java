package com.baizhou.yvnhan.bean.redis;

import com.baizhou.yvnhan.dto.TokenInfo;

/**
 * @author HaiPeng Wang
 * @date 2021/7/15 16:19
 * @Description:
 */
public interface RedisRepository {
    /**
     * 保存手机号和验证码的键值对<phone, messageCode>
     * @param phone
     * @param messageCode 验证码
     */
    void saveMessageCode(String phone, String messageCode);

    /**
     * 保存sessionId 图形验证码
     * @param sessionId
     * @param code
     */
    void saveImageCode(String sessionId,String code);

    /**
     * 根据key：手机号 查询验证码
     * @param phone
     * @return
     */
    String selectMessageCodeByPhone(String phone);

    /**
     * 根据session搜索图形验证码
     * @param sessionId
     * @return
     */
    String selectCodeBySession(String sessionId);

    /**
     * 删除session和code的键值对
     * @param sessionId
     * @return
     */
    void deleteSessionCode(String sessionId);

    /**
     * 删除手机号和验证码的键值对
     * @param phone
     */
    void deleteMessageCode(String phone);



    /**
     * 认证
     * @param tokenInfo
     */
    void saveAccessToken(TokenInfo tokenInfo);

    /**
     * 登录认证
     * @param tokenInfo
     */
    void saveLoginAccessToken(TokenInfo tokenInfo);

    /**
     * 查询认证
     * @param accessToken
     * @return
     */
    String selectAccessToken(String accessToken);

    /**
     * 查询登录认证
     * @param userId
     * @return
     */
    String selectLoginAccessToken(String userId);

    /**
     * 删除认证
     * @param accessToken
     */
    void deleteAccessToken(String accessToken);

    /**
     * 删除登录认证
     * @param userId
     */
    void deleteLoginAccessToken(String userId);

    /**
     * 刷新token时间
     * @param accesstoken
     * @param userId
     * @return
     */
    void refreshLoginToken(String accesstoken,String userId);

    void saveLoginTime(String userId, String loginTime);

    String selectLoginTimeByUser(String userId);

    void deleteLoginTime(String userId);
}
