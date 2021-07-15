package com.baizhou.yvnhan.bean.util;

import com.baizhou.yvnhan.bean.enums.BaseError;
import com.baizhou.yvnhan.bean.exception.SysException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author HaiPeng Wang
 * @date 2021/7/15 14:28
 * @Description:
 */
public class JsonUtil {
    /**
     * 对象转换为JSON
     * @param o
     * @return
     */
    public static String toJson(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return o instanceof String ? o.toString() : objectMapper.writeValueAsString(o);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException(BaseError.JSON_TRANS_ERROR);
        }
    }

    /**
     * JSON转换为对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static<T> T toObject(String json, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            return clazz.equals(String.class) ? (T) json : objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException(BaseError.JSON_TRANS_ERROR);
        }
    }
}
