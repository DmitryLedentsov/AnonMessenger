package com.dimka228.messanger.repositories;

import com.dimka228.messanger.entities.Chat;
import com.dimka228.messanger.entities.Message;
import com.dimka228.messanger.models.MessageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {
    @Query(nativeQuery = true, value = "select sender_id as senderId, sender, message from get_messages_for_user_in_chat(:_user_id, :_chat_id)")
    List<MessageInfo> getMessagesForUserInChat(@Param("_user_id") Integer userId, @Param("_chat_id") Integer chatId);
}