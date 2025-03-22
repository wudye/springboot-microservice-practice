package com.mwu.config.keycloak;

import lombok.Getter;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;

public class KeycloakProperties {

    @Value("${app.config.keycloak.server-url}")
    private String serverUrl;

    @Getter
    @Value("${app.config.keycloak.realm}")
    private String realm;

    @Value("${app.config.keycloak.clientId}")
    private String clientId;

    @Value("${app.config.keycloak.client-secret}")
    private String clientSecret;

    private static Keycloak keycloakInstance = null;

    public Keycloak getInstance() {
        if (keycloakInstance == null) {
//            keycloakInstance = Keycloak.getInstance(
//                    serverUrl,
//                    realm,
//                    clientId,
//                    clientSecret,
//                    "admin-cli");
//        }


            keycloakInstance = KeycloakBuilder
                    .builder()
                    .serverUrl(serverUrl)
                    .realm(realm)
                    .grantType("client_credentials")
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .build();

        }
        return keycloakInstance;

    }
}
