package org.lig.mynetty.demohttp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

/**
 *
 *
 */
public class MyHttpServer {

    static final boolean SSL = System.getProperty( "ssl" ) != null;
    static final int PORT = Integer.parseInt(System.getProperty("port", SSL? "8443" : "10088"));


    public static void main(String[] args) throws Exception {
        final SslContext sslCtx;
        if (SSL) {
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            sslCtx = SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey()).build();
        } else {
            sslCtx = null;
        }

        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group( boosGroup, workerGroup )
                    .channel( NioServerSocketChannel.class )
                    .handler( new LoggingHandler( LogLevel.DEBUG ) )
                    .childHandler( new MyHttpServerInitializer( sslCtx ) );
            Channel ch = b.bind(PORT).sync().channel();
            System.err.println("Open your web browser and navigate to " + (SSL? "https" : "http") + "://127.0.0.1:" + PORT + '/');

            ch.closeFuture().sync();
        } finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }
}
