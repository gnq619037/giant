package com.gnq.giant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by NightGuo on 2019/3/15.
 *
 * @Author: NightGuo
 * @Description:
 * @Date: 10:53 2019/3/15
 */
@SpringBootApplication
//@ComponentScan("com.gnq.giant")
public class SpringBootTest {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTest.class);
    }
}
