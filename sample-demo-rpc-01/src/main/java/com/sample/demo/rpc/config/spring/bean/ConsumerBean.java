package com.sample.demo.rpc.config.spring.bean;

import com.sample.demo.rpc.config.ConsumerConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @description:
 * @author: sample
 * @date: 2023/6/14
 */
public class ConsumerBean<T> extends ConsumerConfig<T> implements FactoryBean {


    @Override
    public Object getObject() throws Exception {
        return refer();
    }


    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }


}
