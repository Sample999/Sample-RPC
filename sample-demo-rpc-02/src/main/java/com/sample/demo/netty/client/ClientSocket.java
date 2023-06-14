package com.sample.demo.netty.client;

import com.sample.demo.netty.codec.RpcDecoder;
import com.sample.demo.netty.codec.RpcEncoder;
import com.sample.demo.netty.msg.Request;
import com.sample.demo.netty.msg.Response;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @description:
 * @author: sample
 * @date: 2023/6/13
 */
public class ClientSocket implements Runnable{

    private ChannelFuture future;

    @Override
    public void run() {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            Bootstrap handler = bootstrap.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.AUTO_READ, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(
                                    new RpcDecoder(Response.class),
                                    new RpcEncoder(Request.class),
                                    new MyClientHandler()
                            );
                        }
                    });

            ChannelFuture f = handler.connect("127.0.0.1", 7397).sync();
            this.future = f;
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    public ChannelFuture getFuture() {
        return future;
    }

    public void setFuture(ChannelFuture future) {
        this.future = future;
    }
}
