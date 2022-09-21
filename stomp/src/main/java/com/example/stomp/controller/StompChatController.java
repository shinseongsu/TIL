package com.example.stomp.controller;

import com.example.stomp.vo.ChatMesssage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StompChatController {

    private final SimpMessagingTemplate template;

    @MessageMapping(value = "/chat/enter")
    public void enter(ChatMesssage messsage) {
        messsage.setMessage(messsage.getWriter() + "님이 채팅방에 참여하였습니다.");
        template.convertAndSend("/sub/chat/room/" + messsage.getRoomId(), messsage);
    }


    @MessageMapping(value = "/chat/message")
    public void message(ChatMesssage messsage) {
        log.info(messsage.toString());
        template.convertAndSend("/sub/chat/room/" + messsage.getRoomId(), messsage);
    }

}
