package com.dimka228.messenger.services;

import com.dimka228.messenger.dto.ChatUpdateDTO;

import lombok.AllArgsConstructor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaChatsConsumer {

    private final SocketMessagingService socketMessagingService;

    @KafkaListener(topics = "chats-update")
    public void updateChats(ChatUpdateDTO message) {
        socketMessagingService.sendChatOperationToUser(message.getId(), message.getChatData());
    }

    @KafkaListener(topics = "chat-update")
    public void updateChat(ChatUpdateDTO message) {
        socketMessagingService.sendMessageOperationToChat(
                message.getId(), message.getMessageData());
    }
}