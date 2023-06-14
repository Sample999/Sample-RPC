package com.sample.demo.rpc.config.spring;

import com.sample.demo.rpc.config.spring.bean.ConsumerBean;
import com.sample.demo.rpc.config.spring.bean.ProviderBean;
import com.sample.demo.rpc.config.spring.bean.ServerBean;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @description:
 * @author: sample
 * @date: 2023/6/14
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("consumer", new MyBeanDefinitionParser(ConsumerBean.class));
        registerBeanDefinitionParser("provider", new MyBeanDefinitionParser(ProviderBean.class));
        registerBeanDefinitionParser("server", new MyBeanDefinitionParser(ServerBean.class));
    }
}
