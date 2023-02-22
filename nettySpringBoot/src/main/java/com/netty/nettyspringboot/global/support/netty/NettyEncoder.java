package com.netty.nettyspringboot.global.support.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Component
@ChannelHandler.Sharable
public class NettyEncoder extends MessageToMessageEncoder<CharSequence> {

    @Override
    protected void encode(ChannelHandlerContext ctx, CharSequence msg, List<Object> out) throws Exception {
        log.info("응답값 ====> {}", msg.toString());
        if (msg.length() == 0) {
            return;
        }

        ByteBuf byteBuf = Unpooled.wrappedBuffer(msg.toString().getBytes(StandardCharsets.UTF_8));
        // ByteBuf byteBuf = ByteBufUtil.encodeString(ctx.alloc(), CharBuffer.wrap(msg), StandardCharsets.UTF_8);
        out.add(byteBuf);
    }
}
