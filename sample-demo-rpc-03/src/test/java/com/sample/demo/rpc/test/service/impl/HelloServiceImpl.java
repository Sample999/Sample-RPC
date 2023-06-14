package com.sample.demo.rpc.test.service.impl;

import com.sample.demo.rpc.test.service.HelloService;
import org.springframework.stereotype.Service;


@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public void echo() {
        System.out.println("hi itstack demo rpc");
    }

}
