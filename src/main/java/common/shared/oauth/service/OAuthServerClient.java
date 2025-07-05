package common.shared.oauth.service;


import common.shared.oauth.config.credentials.AuthProperties;
import common.shared.oauth.enums.ErrorEnum;
import common.shared.oauth.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
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
                .uri(authProperties.getTokenUrl())
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
}
