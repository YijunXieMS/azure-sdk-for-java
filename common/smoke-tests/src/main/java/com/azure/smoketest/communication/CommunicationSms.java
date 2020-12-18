package com.azure.smoketest.communication;

import com.azure.communication.common.PhoneNumber;
import com.azure.communication.sms.SmsClient;
import com.azure.communication.sms.SmsClientBuilder;
import com.azure.communication.sms.models.SendSmsOptions;
import com.azure.communication.sms.models.SendSmsResponse;

import java.util.ArrayList;
import java.util.List;

public class CommunicationSms {
    private static SmsClient smsClient;

    private static void sendSms() {
        // Currently Sms services only supports one phone number
        List<PhoneNumber> to = new ArrayList<>();
        to.add(new PhoneNumber("<to-phone-number>"));

        // SendSmsOptions is an optional field. It can be used
        // to enable a delivery report to the Azure Event Grid
        SendSmsOptions options = new SendSmsOptions();
        options.setEnableDeliveryReport(true);

        // Send the message and check the response for a message id
        SendSmsResponse response = smsClient.sendMessage(
            new PhoneNumber("<leased-phone-number>"),
            to,
            "message from smoke test",
            options /* Optional */);

        System.out.println("MessageId: " + response.getMessageId());
    }

    public static void main(String[] args) {
        // Your can find your connection string from your resource in the Azure Portal
        String connectionString = System.getenv("AZURE_COMMUNICATION_SMS_CONNECTION_STRING");

        smsClient = new SmsClientBuilder()
            .connectionString(connectionString)
            .buildClient();
        sendSms();

    }
}
