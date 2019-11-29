/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.config.MybatisPlusConfig
 * @version V1.0
 */
package com.ibm.mosesboot.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Moses
 * @date 2019/11/29
 */
//Spring boot方式
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {
    /**
     * SQL输出拦截器
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //sql格式化
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    /**
     * 分页查询拦截器
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
