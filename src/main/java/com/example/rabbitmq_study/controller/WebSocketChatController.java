package com.example.rabbitmq_study.controller;

import com.example.rabbitmq_study.domain.WebSocketChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketChatController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public WebSocketChatMessage sendMessage(@Payload WebSocketChatMessage message){
        return message;
    }

    @MessageMapping("/chat.newUser")
    @SendTo
    public WebSocketChatMessage newUser(@Payload WebSocketChatMessage message, SimpMessageHeaderAccessor accessor){
        accessor.getSessionAttributes().put("username" , message.getSender());
        return message;
    }
}
