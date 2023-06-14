package com.sample.demo.rpc.test.service.impl;


import com.sample.demo.rpc.test.service.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public void echo() {
        System.out.println("hi sample demo rpc");
    }

}
