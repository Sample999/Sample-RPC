package com.sample.demo.rpc.test;

import com.sample.demo.rpc.test.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: sample
 * @date: 2023/6/14
 */
public class ApiTest {

    public static void main(String[] args) {
        String[] configs = {"sample-rpc-consumer.xml", "sample-rpc-provider.xml"};
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(configs);
        classPathXmlApplicationContext.getBean("consumer_sample");
        classPathXmlApplicationContext.getBean("provider_helloService");
        classPathXmlApplicationContext.getBean("consumer_helloService");
    }

}
