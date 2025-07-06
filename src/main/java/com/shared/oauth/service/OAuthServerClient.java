package com.shared.oauth.service;


import com.shared.oauth.config.credentials.AuthProperties;
import com.shared.oauth.enums.ErrorEnum;
import com.shared.oauth.exception.ApiException;
import com.shared.oauth.model.dto.users.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@Service
public class OAuthServerClient {
    private final WebClient webClient;
    @Autowired
    AuthProperties authProperties;

    public OAuthServerClient(
            WebClient.Builder webClientBuilder
    ) {
        this.webClient = webClientBuilder.build();
    }

    public Map<String, Object> exchangeCode(
            String code,
            String redirectUri,
            String codeVerifier
    ) {



        return webClient.post()
                .uri(authProperties.getBaseUrl()+"/oauth2/token")
                .header(HttpHeaders.AUTHORIZATION, getBasicAuthHeader())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(buildTokenRequest(code, redirectUri, codeVerifier)))
                .retrieve()
                .onStatus(HttpStatusCode::isError, this::handleOAuthError)
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .block();
    }

    private String getBasicAuthHeader() {
            String basicAuth = "Basic " +Base64.getEncoder()
                .encodeToString((authProperties.getClientId() + ":" + authProperties.getClientSecret()).getBytes(StandardCharsets.UTF_8));
            return basicAuth;

    }

    private MultiValueMap<String, String> buildTokenRequest(
            String code,
            String redirectUri,
            String codeVerifier
    ) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "authorization_code");
        formData.add("code", code);
        formData.add("redirect_uri", redirectUri);
        formData.add("client_id", authProperties.getClientId());
        formData.add("code_verifier", codeVerifier); // Essential for PKCE flow

        return formData;
    }

    private Mono<? extends Throwable> handleOAuthError(ClientResponse response) {
        return response.bodyToMono(String.class)
                .flatMap(errorBody -> Mono.error(new ApiException(
                        ErrorEnum.BAD_REQUEST
                )));
    }


    public UserInfoResponse fetchUserInfo(Jwt jwt) {
        try {
            return webClient.get()
                    .uri(authProperties.getBaseUrl()+"/oauth2/userinfo")  // Use configured userinfo endpoint
                    .headers(headers -> headers.setBearerAuth(jwt.getTokenValue()))
                    .retrieve()
                    .onStatus(
                            HttpStatusCode::isError,
                            response -> response.bodyToMono(String.class)
                                    .flatMap(errorBody -> Mono.error(new ApiException(
                                            ErrorEnum.UNAUTHORIZED_ACCESS,
                                            "Failed to fetch user info: " + response.statusCode() + " - " + errorBody
                                    )))
                    )
                    .bodyToMono(UserInfoResponse.class)
                    .block();
        } catch (WebClientResponseException ex) {
            throw new ApiException(
                    ErrorEnum.UNAUTHORIZED_ACCESS,
                    "OAuth server error: " + ex.getStatusCode() + " - " + ex.getResponseBodyAsString()
            );
        } catch (Exception ex) {
            throw new ApiException(
                    ErrorEnum.INTERNAL_SERVER_ERROR,
                    "Unexpected error fetching user info: " + ex.getMessage()
            );
        }
    }

}
