package org.lig.mynetty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class MyEchoServer {

    private int port;

    public MyEchoServer(int port) {
        this.port = port;
    }

    public void start() throws Exception{
        final MyEchoServerHandler echoServerHandler = new MyEchoServerHandler();
        // 1. 创建EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();

        try{
            // 2. 创建serverBootstrap
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group)
                    .channel(NioServerSocketChannel.class) // 3. 指定所使用的NIO传输Channel
                    .localAddress(new InetSocketAddress(port))// 4. 使用指定的端口设置套接字地址
                    .childHandler(new ChannelInitializer<SocketChannel>() {//5. 添加一个EchoServerHandler到子Channel的ChannelPipeline
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(echoServerHandler); //MyEchoServerHandler被标注为@Sharreable所以我们可以总是使用同样的实例
                        }
                    });

            ChannelFuture f = bootstrap.bind().sync();//6. 异步的绑定服务器；调用sync()方法阻塞等待直到绑定完成
            f.channel().closeFuture().sync();         //7. 获取Channel的CloseFuture并阻塞当前线程直到它完成
        } finally {
            group.shutdownGracefully().sync(); // 关闭EventLoopGroup，释放所有资源
        }



    }



    public static void main(String[] args) {
        try {
            new MyEchoServer(9527).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
