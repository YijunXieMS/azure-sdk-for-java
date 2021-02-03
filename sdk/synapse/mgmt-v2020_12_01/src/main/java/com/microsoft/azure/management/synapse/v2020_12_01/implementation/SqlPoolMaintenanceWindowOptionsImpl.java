/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * abc
 */

package com.microsoft.azure.management.synapse.v2020_12_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.synapse.v2020_12_01.SqlPoolMaintenanceWindowOptions;
import rx.functions.Func1;
import rx.Observable;
import com.microsoft.azure.management.synapse.v2020_12_01.MaintenanceWindowOptions;

class SqlPoolMaintenanceWindowOptionsImpl extends WrapperImpl<SqlPoolMaintenanceWindowOptionsInner> implements SqlPoolMaintenanceWindowOptions {
    private final SynapseManager manager;

    SqlPoolMaintenanceWindowOptionsImpl(SynapseManager manager) {
        super(manager.inner().sqlPoolMaintenanceWindowOptions());
        this.manager = manager;
    }

    public SynapseManager manager() {
        return this.manager;
    }

    @Override
    public Observable<MaintenanceWindowOptions> getAsync(String resourceGroupName, String workspaceName, String sqlPoolName, String maintenanceWindowOptionsName) {
        SqlPoolMaintenanceWindowOptionsInner client = this.inner();
        return client.getAsync(resourceGroupName, workspaceName, sqlPoolName, maintenanceWindowOptionsName)
        .map(new Func1<MaintenanceWindowOptionsInner, MaintenanceWindowOptions>() {
            @Override
            public MaintenanceWindowOptions call(MaintenanceWindowOptionsInner inner) {
                return new MaintenanceWindowOptionsImpl(inner, manager());
            }
        });
    }

}
