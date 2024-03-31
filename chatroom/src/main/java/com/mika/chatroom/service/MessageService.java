package com.mika.chatroom.service;


import com.mika.chatroom.mapper.MessageMapper;
import com.mika.chatroom.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public List<Message> getHistoryBySessionId(Integer sessionId) {
        return messageMapper.getHistoryBySessionId(sessionId);
    }

    public Integer addMessage(Message message) {
        return messageMapper.addMessage(message);
    }

}
