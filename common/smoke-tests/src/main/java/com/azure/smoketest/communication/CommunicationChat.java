package com.azure.smoketest.communication;

import com.azure.communication.chat.ChatClient;
import com.azure.communication.chat.ChatClientBuilder;
import com.azure.communication.chat.ChatThreadClient;
import com.azure.communication.chat.models.ChatMessagePriority;
import com.azure.communication.chat.models.ChatThreadMember;
import com.azure.communication.chat.models.CreateChatThreadOptions;
import com.azure.communication.chat.models.SendChatMessageOptions;
import com.azure.communication.chat.models.SendChatMessageResult;
import com.azure.communication.common.CommunicationUser;
import com.azure.communication.common.CommunicationUserCredential;

import java.util.ArrayList;
import java.util.List;

public class CommunicationChat {
    private static ChatClient chatClient;

    private static  ChatThreadClient createChatThread() {

        CommunicationUser user1 = new CommunicationUser("Id 1");
        CommunicationUser user2 = new CommunicationUser("Id 2");

        List<ChatThreadMember> members = new ArrayList<ChatThreadMember>();

        ChatThreadMember firstThreadMember = new ChatThreadMember()
            .setUser(user1)
            .setDisplayName("Member Display Name 1");

        ChatThreadMember secondThreadMember = new ChatThreadMember()
            .setUser(user2)
            .setDisplayName("Member Display Name 2");

        members.add(firstThreadMember);
        members.add(secondThreadMember);

        CreateChatThreadOptions createChatThreadOptions = new CreateChatThreadOptions()
            .setTopic("Topic")
            .setMembers(members);

        return chatClient.createChatThread(createChatThreadOptions);
    }

    private static void sendChatMessage(ChatThreadClient chatThreadClient) {
        SendChatMessageOptions sendChatMessageOptions = new SendChatMessageOptions()
            .setContent("Message content")
            .setPriority(ChatMessagePriority.NORMAL)
            .setSenderDisplayName("Sender Display Name");

        SendChatMessageResult sendChatMessageResult = chatThreadClient.sendMessage(sendChatMessageOptions);
        String chatMessageId = sendChatMessageResult.getId();
    }

    public static void main(String[] args) {
        String endpoint = "AZURE_COMMUNICATION_CHAT_ENDPOINT";

        // Your user access token retrieved from your trusted service
        String token = "SECRET";
        CommunicationUserCredential credential = new CommunicationUserCredential(token);

        // Initialize the chat client
        final ChatClientBuilder builder = new ChatClientBuilder();
        chatClient = builder
            .endpoint(endpoint)
            .credential(credential)
            .buildClient();

        ChatThreadClient chatThreadClient = createChatThread();
        sendChatMessage(chatThreadClient);

    }
}
