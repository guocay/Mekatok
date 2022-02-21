package com.github.guokaia.mekatok.jdbc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Liquibase 设置
 * @author GuoKai
 * @date 2022/2/6
 */
@SuppressWarnings("all")
@Configuration(proxyBeanMethods = false)
public class LiquibaseAutoConfiguration implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        /*
            设置 LiquibaseProperties, 修改用于记录版本的表名
         */
        if (bean instanceof LiquibaseProperties){
            LiquibaseProperties properties = (LiquibaseProperties) bean;
            properties.setDatabaseChangeLogTable("T_AA_DATABASE_CHANGELOG");
            properties.setDatabaseChangeLogLockTable("T_AA_DATABASE_CHANGELOG_LOCK");
        }
        return bean;
    }
}
