package com.futao.shardingspherelearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author futao
 * @since 2022/11/18
 */
@MapperScan("com.futao.shardingspherelearn.mapper")
@SpringBootApplication
public class ShardingSphereLearnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereLearnApplication.class, args);
    }
}
