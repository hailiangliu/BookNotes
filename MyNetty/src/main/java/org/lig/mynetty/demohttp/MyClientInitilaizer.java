package org.lig.mynetty.demohttp;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.ssl.SslContext;

/**
 *
 *
 */
public class MyClientInitilaizer extends ChannelInitializer {

    private final SslContext sslCtx;

    public MyClientInitilaizer(SslContext sslCtx) {
        this.sslCtx = sslCtx;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        if (null != sslCtx) {
            p.addLast( sslCtx.newHandler( ch.alloc() ) );
        }
        p.addLast( new HttpClientCodec() );
        p.addLast( new HttpContentCompressor() );
        p.addLast( new MyClientHandler());

    }
}
