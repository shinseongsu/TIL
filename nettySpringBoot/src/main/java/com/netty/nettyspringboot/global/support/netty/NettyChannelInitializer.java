package com.netty.nettyspringboot.global.support.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NettyChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final NettyHandler nettyHandler;
    private final NettyDecoder nettyDecoder;
    private final NettyEncoder nettyEncoder;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(nettyDecoder);
        pipeline.addLast(nettyEncoder);

        pipeline.addLast(nettyHandler);
    }
}
