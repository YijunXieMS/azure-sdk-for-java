package com.azure.smoketest.communication;

import com.azure.communication.administration.CommunicationIdentityClient;
import com.azure.communication.administration.CommunicationIdentityClientBuilder;
import com.azure.communication.administration.PhoneNumberClient;
import com.azure.communication.administration.PhoneNumberClientBuilder;
import com.azure.communication.administration.models.PhonePlanGroup;
import com.azure.communication.common.CommunicationUser;
import com.azure.core.http.rest.PagedIterable;

public class CommunicationAdministration {
    private static CommunicationIdentityClient communicationIdentityClient;
    private static PhoneNumberClient phoneNumberClient;

    private static void createNewUser() {
        CommunicationUser user = communicationIdentityClient.createUser();
        System.out.println("User id: " + user.getId());
    }

    private static void listPhonePlanGroups() {
        String countryCode = "US";
        String locale = "en-us";

        PagedIterable<PhonePlanGroup> phonePlanGroups = phoneNumberClient
            .listPhonePlanGroups(countryCode, locale, true);

        for (PhonePlanGroup phonePlanGroup
            : phonePlanGroups) {
            System.out.println("Phone Plan GroupId: " + phonePlanGroup.getPhonePlanGroupId());
            System.out.println("Phone Plan NumberType: " + phonePlanGroup.getPhoneNumberType());
        }
    }

    public static void main(String[] args) {
        String connectionString = System.getenv("AZURE_COMMUNICATION_CONNECTION_STRING");
        communicationIdentityClient = new CommunicationIdentityClientBuilder()
            .connectionString(connectionString)
            .buildClient();

        phoneNumberClient = new PhoneNumberClientBuilder()
            .connectionString(connectionString)
            .buildClient();

        createNewUser();
        listPhonePlanGroups();
    }
}
