package com.baizhou.yvnhan.controller;


import com.baizhou.yvnhan.entity.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wanghaipeng
 * @since 2021-07-14
 */
@Controller
@RequestMapping("/yvnhan/book")
public class BookController {

    @ApiOperation("test 用于测试mvc架构是否成功")
    @ResponseBody
    @RequestMapping(path = "/test")
    public User test(@ApiParam("用户名") String username){
        User user = new User();
        user.setName("JJJJJJ");
        return user;
    }
}

