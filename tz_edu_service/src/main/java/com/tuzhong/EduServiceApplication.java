package com.tuzhong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author：BaiYun
 * @create：2020-11-08-15:14
 * @Description：
 */
@MapperScan("com.tuzhong.edu.mapper")
@SpringBootApplication
public class EduServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduServiceApplication.class,args);
    }
}
