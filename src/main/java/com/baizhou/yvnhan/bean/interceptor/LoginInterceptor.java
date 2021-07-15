package com.baizhou.yvnhan.bean.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author HaiPeng Wang
 * @date 2021/7/14 16:21
 * @Description:
 */

/**
 * 自定义一个拦截器的方式就是实现HandlerInterceptor
 * 和mvcconfigure 不同这里才是拦截器定义的地方，springmvc 只是将你的拦截器放到了容器里面而这里是定义
 * 相应的拦截器的属性包括在每一个controller 执行前进行还是在每一个controller 执行后进行等等类似的
 * 这里的话将token 的配置也在这里进行一个实现
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {


}
