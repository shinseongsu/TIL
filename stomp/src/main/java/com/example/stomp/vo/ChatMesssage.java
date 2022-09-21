package com.example.stomp.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMesssage {

    private String roomId;
    private String writer;
    private String message;

    @Override
    public String toString() {
        return "ChatMesssage{" +
            "roomId='" + roomId + '\'' +
            ", writer='" + writer + '\'' +
            ", message='" + message + '\'' +
            '}';
    }
}
