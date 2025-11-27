package com.springai.SpringAiDemo.Services;


import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatModel chatModel;
    @Autowired
    public ChatService(ChatModel chatModel){
        this.chatModel = chatModel;
    }

    public String getResponse(String promp){
        return chatModel.call(promp);
    }
}
