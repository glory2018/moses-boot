package com.ibm.mosesboot;

import com.ibm.mosesboot.config.StorageProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Moses
 */
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
@MapperScan("com.ibm.mosesboot.*.mapper")
public class MosesbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MosesbootApplication.class, args);
    }
}

