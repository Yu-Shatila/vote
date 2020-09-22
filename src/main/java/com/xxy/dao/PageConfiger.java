package com.xxy.dao;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author xxy
 * @date 2020-08-26 - 17:37
 */
@Configuration
public class PageConfiger {

    /*@Bean
    public PaginationInnerInterceptor pagination() {
        PaginationInnerInterceptor page = new PaginationInnerInterceptor();
        page.setMaxLimit(500L);
        return page;
    }*/

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }



}
