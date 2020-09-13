// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.identity;


/**
 * Fluent credential builder for instantiating a {@link SharedTokenCacheCredential}.
 *
 * @see SharedTokenCacheCredential
 */
public class SharedTokenCacheCredentialBuilder extends AadCredentialBuilderBase<SharedTokenCacheCredentialBuilder> {
    private String username;

    /**
     * Sets the username for the account.
     *
     * @param username The username for the account.
     *
     * @return The updated SharedTokenCacheCredentialBuilder object.
     */
    public SharedTokenCacheCredentialBuilder username(String username) {
        this.username = username;
        return this;
    }

    /**
     * Disallows the use of an unprotected file specified by <code>cacheFileLocation()</code> instead of
     * Gnome keyring on Linux. This is enabled by default.
     *
     * @return An updated instance of this builder.
     */
    public SharedTokenCacheCredentialBuilder disallowUnencryptedCache() {
        this.identityClientOptions.setAllowUnencryptedCache(false);
        return this;
    }

    /**
     * Sets the {@link AuthenticationRecord} captured from a previous authentication.
     *
     * @param authenticationRecord the authentication record to be configured.
     *
     * @return An updated instance of this builder with the configured authentication record.
     */
    public SharedTokenCacheCredentialBuilder authenticationRecord(AuthenticationRecord authenticationRecord) {
        this.identityClientOptions.setAuthenticationRecord(authenticationRecord);
        return this;
    }

    /**
     * Creates a new {@link SharedTokenCacheCredentialBuilder} with the current configurations.
     *
     * @return a {@link SharedTokenCacheCredentialBuilder} with the current configurations.
     */
    public SharedTokenCacheCredential build() {
        return new SharedTokenCacheCredential(username, clientId, tenantId,
                identityClientOptions.enablePersistentCache().setAllowUnencryptedCache(true));
    }
}
