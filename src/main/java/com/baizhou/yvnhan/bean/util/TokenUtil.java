package com.baizhou.yvnhan.bean.util;

import java.util.Random;
import java.util.UUID;

/**
 * @author HaiPeng Wang
 * @date 2021/7/15 14:42
 * @Description:
 */
public class TokenUtil {

    final static int RAND_UPPER = 0;
    final static int RAND_LOWER = 1;
    final static int RAND_RANGE = 2;
    final static String TOKEN_PREFIX = "ANSWER";  //token的前缀

    private static Random random = new Random();



    public static String getToken(){
        //返回一个UUID的字符串，然后将这个字符串的-替换成空字符，然后再把所有的大写字母转成小写字母
        String str=  UUID.randomUUID().toString().replace("-","").toLowerCase();
        //到此得到一个uuid
        return TOKEN_PREFIX + randomLowerUpperCase(str);
    }

    private static String randomLowerUpperCase(String uuid) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < uuid.length(); i++) {
            int rand = random.nextInt(RAND_RANGE);  //生成一个随机数大小介于0 ~ 2 之间，又因为是整数，所以只会是0 1 两种
            if (rand == RAND_UPPER) {
                stringBuilder.append(String.valueOf(uuid.charAt(i)).toUpperCase());
            } else if (rand == RAND_LOWER) {
                stringBuilder.append(String.valueOf(uuid.charAt(i)).toLowerCase());
            }
          } // 保证UUID 大小写都有
        return stringBuilder.toString();
    }

}
