package com.sample.demo.netty.test;

import com.sample.demo.netty.server.ServerSocket;

/**
 * @description:
 * @author: sample
 * @date: 2023/6/13
 */
public class StartServer {

    public static void main(String[] args) {
        new Thread(new ServerSocket()).start();
        System.out.println("sample-demo-netty server start done...");
    }

}
