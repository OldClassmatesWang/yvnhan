package com.baizhou.yvnhan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.baizhou.yvhan.mapper")
@SpringBootApplication
public class YvnhanApplication {

    public static void main(String[] args) {
        SpringApplication.run(YvnhanApplication.class, args);
    }

}
