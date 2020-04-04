package com.moses.framework;

import com.moses.framework.config.StorageProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Moses
 */
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
@EnableAsync
@MapperScan("com.moses.framework.samples.*.mapper")
public class MosesbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MosesbootApplication.class, args);
    }
}

