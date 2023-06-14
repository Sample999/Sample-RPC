package com.sample.demo.rpc.config.spring.bean;

import com.sample.demo.rpc.config.ProviderConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @description:
 * @author: sample
 * @date: 2023/6/14
 */
public class ProviderBean extends ProviderConfig implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 发布生产者
        doExport();
    }
}
