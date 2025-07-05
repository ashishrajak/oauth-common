package com.shared.oauth.controller;


import com.shared.oauth.exception.ApiException;
import com.shared.oauth.service.TokenExchangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private final WebClient webClient;
    private final TokenExchangeService tokenExchangeService;

    public AuthController(WebClient.Builder webClientBuilder, TokenExchangeService tokenExchangeService) {
        this.webClient = webClientBuilder.build();
        this.tokenExchangeService =tokenExchangeService;
    }

    @PostMapping("/token")
    public ResponseEntity<Map<String, Object>> exchangeCodeForToken(
            @RequestParam String code,
            @RequestParam String state,
            @RequestParam String redirect_uri,
            @RequestParam String client_id,
            @RequestParam String code_verifier) {

        try {
            Map<String, Object> tokenResponse = tokenExchangeService
                    .exchangeCodeForTokens(code, redirect_uri, code_verifier);
            return ResponseEntity.ok(tokenResponse);
        } catch (ApiException e) {
            return ResponseEntity.status(401).body(Map.of(
                    "error", "oauth_error",
                    "error_description", e.getMessage()
            ));
        } catch (JwtException e) {
            return ResponseEntity.status(401).body(Map.of(
                    "error", "invalid_token",
                    "error_description", "JWT validation failed"
            ));
        }
    }
}

