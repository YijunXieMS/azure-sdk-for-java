package com.azure.smoketest.keyvault;


import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.CertificateException;

import com.azure.keyvault.jca.org.apache.hc.client5.http.classic.methods.HttpGet;
import com.azure.keyvault.jca.org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import com.azure.keyvault.jca.org.apache.hc.client5.http.impl.classic.HttpClients;
import com.azure.keyvault.jca.org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import com.azure.keyvault.jca.org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import com.azure.keyvault.jca.org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import com.azure.keyvault.jca.org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder;
import com.azure.keyvault.jca.org.apache.hc.client5.http.ssl.TrustSelfSignedStrategy;
import com.azure.keyvault.jca.org.apache.hc.core5.http.ClassicHttpResponse;
import com.azure.keyvault.jca.org.apache.hc.core5.http.io.HttpClientResponseHandler;
import com.azure.keyvault.jca.org.apache.hc.core5.ssl.SSLContexts;
import com.azure.security.keyvault.jca.KeyVaultJcaProvider;  //TODO: keyvault jca doesn't export it.
import com.azure.security.keyvault.jca.KeyVaultLoadStoreParameter;

import javax.net.ssl.SSLContext;

public class KeyVaultJCA {

    private static void clientSSL() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException {
        KeyVaultJcaProvider provider = new KeyVaultJcaProvider();
        Security.addProvider(provider);

        KeyStore ks = KeyStore.getInstance("AzureKeyVault");
        KeyVaultLoadStoreParameter parameter = new KeyVaultLoadStoreParameter(
            System.getProperty("azure.keyvault.uri"),
            System.getProperty("azure.keyvault.aadAuthenticationUrl"),
            System.getProperty("azure.tenant.id"),
            System.getProperty("azure.client.id"),
            System.getProperty("azure.client.secret"));
        ks.load(parameter);

        SSLContext sslContext = SSLContexts
            .custom()
            .loadTrustMaterial(ks, new TrustSelfSignedStrategy())
            .build();

        SSLConnectionSocketFactory sslSocketFactory = SSLConnectionSocketFactoryBuilder
            .create()
            .setSslContext(sslContext)
            .setHostnameVerifier((hostname, session) -> {
                return true;
            })
            .build();

        PoolingHttpClientConnectionManager cm = PoolingHttpClientConnectionManagerBuilder
            .create()
            .setSSLSocketFactory(sslSocketFactory)
            .build();

        String result = null;

        try (CloseableHttpClient client = HttpClients.custom().setConnectionManager(cm).build()) {
            HttpGet httpGet = new HttpGet("https://localhost:8766");
            HttpClientResponseHandler<String> responseHandler = (ClassicHttpResponse response) -> {
                int status = response.getCode();
                String result1 = "Not success";
                if (status == 204) {
                    result1 = "Success";
                }
                return result1;
            };
            result = client.execute(httpGet, responseHandler);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static void serverSSL() {
        //TODO:
    }
    public static void main(String[] args) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        clientSSL();
        serverSSL();
    }
}
