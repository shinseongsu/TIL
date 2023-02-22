package com.netty.nettyspringboot.global.support.netty;

import com.netty.nettyspringboot.ui.ProductController;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Slf4j
@Component
@Sharable
@RequiredArgsConstructor
public class NettyHandler extends ChannelInboundHandlerAdapter {

    private final ProductController productController;

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        String remoteAddress = ctx.channel().remoteAddress().toString();
        log.info("Remote Address: " + remoteAddress);
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("요청값 ====> {}", msg.toString());

        productController.productSave(msg.toString().substring(4, 4));

        final String message = "success ok";
        final byte[] bytes = message.getBytes(StandardCharsets.UTF_8);

        final ChannelFuture f = ctx.write(String.format("%04d", bytes.length)  +  message);
        f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
