package com.baizhou.yvnhan.bean.redis;

/**
 * @author HaiPeng Wang
 * @date 2021/7/15 16:34
 * @Description:
 */
public class RedisKeyTemplate {
    /**
     *记录验证码信息
     * 键：Verification_Code:verificationCode
     * 值：{ verificationCode, phoneNumber }
     */
    public final static String T_VERIFICATION_CODE = "Verification:%s";

    /**
     * 记录token的详细信息
     * 键：ACCESS_TOKEN:accessToken
     * 值：{ accessToken, userId }
     */
    public final static String T_ACCESS_TOKEN = "TOKEN:%s";

    /**
     * 记录用户当前正在使用的token
     * 键：USER_ACCESS_TOKEN:userId
     * 值：accessToken
     */
    public final static String T_USER_CURRENT_TOKEN = "USER_TOKEN:%s";

    /**
     * 记录当前在线用户
     * 键：userId
     * 值：loginTime
     */
    public final static String T_USER_LOGIN_TIME = "LOGIN_TIME:%s";

}
