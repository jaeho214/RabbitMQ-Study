package com.example.rabbitmq_study.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WebSocketChatMessage {
    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType{
        CHAT,
        JOIN,
        LEAVE
    }
}
