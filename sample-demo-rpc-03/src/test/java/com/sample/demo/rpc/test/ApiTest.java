package com.sample.demo.rpc.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApiTest {

    public static void main(String[] args) {
        String[] configs = {"sample-rpc-center.xml", "sample-rpc-provider.xml", "sample-rpc-consumer.xml"};
        new ClassPathXmlApplicationContext(configs);
    }

}
