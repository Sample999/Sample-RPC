package com.sample.demo.netty.test;

import com.alibaba.fastjson.JSON;
import com.sample.demo.netty.client.ClientSocket;
import com.sample.demo.netty.future.SyncWrite;
import com.sample.demo.netty.msg.Request;
import com.sample.demo.netty.msg.Response;
import io.netty.channel.ChannelFuture;

/**
 * @description:
 * @author: sample
 * @date: 2023/6/13
 */
public class StartClient {

    private static ChannelFuture future;

    public static void main(String[] args) {
        System.out.println("hi, it's client");
        ClientSocket clientSocket = new ClientSocket();
        new Thread(clientSocket).start();

        while (true) {
            try {
                // 获取future
                if(null == future) {
                    future = clientSocket.getFuture();
                    Thread.sleep(500);
                    continue;
                }

                // 构建发送参数
                Request request = new Request();
                request.setParam("查询用户信息");
                SyncWrite syncWrite = new SyncWrite();
                Response response = syncWrite.writeAndSync(future.channel(), request, 1000);
                System.out.println("远程调用结果：" + JSON.toJSON(response));
                Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
