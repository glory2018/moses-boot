package com.ibm.mosesboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Moses
 */
@SpringBootApplication
@MapperScan("com.ibm.mosesboot.mapper")
public class MosesbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MosesbootApplication.class, args);
    }
}

