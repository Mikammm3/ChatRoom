package com.mika.chatroom.controller;


import com.mika.chatroom.model.Message;
import com.mika.chatroom.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/getMessageList")
    public List<Message> getMessageList(Integer sessionId) {
        if (sessionId == null || sessionId < 1) {
            return null;
        }
        List<Message> messages = messageService.getHistoryBySessionId(sessionId);
        Collections.reverse(messages);
        return messages;
    }
}
