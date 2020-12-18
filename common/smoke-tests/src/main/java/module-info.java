// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

module com.azure.smoketest {
    requires transitive com.azure.identity;
    requires transitive com.azure.security.keyvault.secrets;
    requires transitive com.azure.security.keyvault.keys;
    requires transitive com.azure.security.keyvault.certificates;
    requires transitive com.azure.security.keyvault.administration;
    requires azure.security.keyvault.jca;
    // TODO: this is automatic module. keyvault jca should add a module-info.java

    requires transitive com.azure.messaging.eventhubs;
    requires transitive com.azure.messaging.eventgrid;
    requires transitive com.azure.messaging.servicebus;

    requires transitive com.azure.storage.blob;
    requires transitive com.azure.storage.blob.batch;
    requires transitive com.azure.storage.blob.changefeed;
    requires transitive com.azure.storage.blob.nio;
    requires transitive com.azure.storage.blob.cryptography;
    requires transitive com.azure.storage.file.datalake;
    requires transitive com.azure.storage.file.share;

    requires transitive com.azure.data.tables;
    requires transitive com.azure.data.appconfiguration;

    requires transitive com.azure.ai.anomalydetector;
    requires transitive com.azure.ai.formrecognizer;
    requires transitive com.azure.ai.metricsadvisor;
    //TODO: metricsadvisor needs to export package administration
    requires transitive com.azure.ai.textanalytics;

    requires transitive com.azure.communication.administration;
    requires transitive com.azure.communication.chat;
    requires transitive com.azure.communication.sms;

    requires transitive com.azure.search.documents;
    requires transitive com.azure.cosmos;
}
