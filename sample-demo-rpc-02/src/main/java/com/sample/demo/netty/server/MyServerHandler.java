package com.sample.demo.netty.server;

import com.sample.demo.netty.msg.Request;
import com.sample.demo.netty.msg.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object obj){
        Request msg = (Request) obj;
        //反馈
        Response response = new Response();
        response.setRequestId(msg.getRequestId());
        response.setResult(msg.getParam() + " 请求成功，反馈结果请接受处理");
        ctx.writeAndFlush(response);
        //释放
        ReferenceCountUtil.release(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

}