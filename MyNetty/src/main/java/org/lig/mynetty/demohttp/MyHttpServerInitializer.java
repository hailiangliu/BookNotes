package org.lig.mynetty.demohttp;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.ssl.SslContext;

/**
 *
 *
 */
public class MyHttpServerInitializer extends ChannelInitializer {

    private final SslContext sslContext;

    public MyHttpServerInitializer(SslContext sslContext) {
        this.sslContext = sslContext;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();
        if (sslContext != null) {
            channelPipeline.addLast(sslContext.newHandler(ch.alloc()));
        }

        channelPipeline.addLast(new HttpRequestDecoder());
        channelPipeline.addLast(new HttpResponseEncoder());
        channelPipeline.addLast(new MyHttpServerHandler());

    }
}
