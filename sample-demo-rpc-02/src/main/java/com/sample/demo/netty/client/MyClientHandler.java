package com.sample.demo.netty.client;

import com.sample.demo.netty.future.SyncWriteFuture;
import com.sample.demo.netty.future.SyncWriteMap;
import com.sample.demo.netty.msg.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @description:
 * @author: sample
 * @date: 2023/6/13
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object obj) throws Exception {
        Response msg = (Response) obj;
        String requestId = msg.getRequestId();
        SyncWriteFuture syncWriteFuture = (SyncWriteFuture) SyncWriteMap.syncKey.get(requestId);
        if(syncWriteFuture != null) {
            syncWriteFuture.setResponse(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
