package com.baizhou.yvnhan.bean.exception;


import lombok.Data;

/**
 * @author HaiPeng Wang
 * @date 2021/7/15 11:17
 * @Description: 通用异常类
 */
@Data
public class GlobalException extends Exception{

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public GlobalException(String message) {
        this.message = message;
    }
}
