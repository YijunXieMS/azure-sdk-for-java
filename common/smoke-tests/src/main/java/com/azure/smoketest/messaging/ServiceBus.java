package com.azure.smoketest.messaging;

import com.azure.core.util.IterableStream;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import com.azure.messaging.servicebus.ServiceBusReceiverClient;
import com.azure.messaging.servicebus.ServiceBusSenderClient;

public class ServiceBus {
    private static ServiceBusReceiverClient receiverClient;
    private static ServiceBusSenderClient senderClient;

    private static void sendEvent() {
        senderClient.sendMessage(new ServiceBusMessage("test message"));
    }

    private static void receiveEvent() {
        IterableStream<ServiceBusReceivedMessage> receivedMessages = receiverClient.receiveMessages(1);
    }

    public static void main(String[] args) {
        receiverClient = new ServiceBusClientBuilder()
            .connectionString(System.getenv("AZURE_SERVICEBUS_EVENT_HUB_NAME"))
            .receiver()
            .queueName("AZURE_SERVICEBUS_SMOKE_QUEUE_NAME")
            .buildClient();

        senderClient = new ServiceBusClientBuilder()
            .connectionString(System.getenv("AZURE_SERVICEBUS_EVENT_HUB_NAME"))
            .sender()
            .buildClient();

        try {
            sendEvent();
            receiveEvent();
        } finally {
            receiverClient.close();
            senderClient.close();
        }
    }
}
