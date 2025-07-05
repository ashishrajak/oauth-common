package common.shared.oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TokenExchangeService {
    private final OAuthServerClient oauthServerClient;
    @Lazy
    @Autowired
    private  AuthUserService userService;
    private final JwtDecoder jwtDecoder;

    public TokenExchangeService(
            OAuthServerClient oauthServerClient,

            JwtDecoder jwtDecoder
    ) {
        this.oauthServerClient = oauthServerClient;

        this.jwtDecoder = jwtDecoder;
    }

    public Map<String, Object> exchangeCodeForTokens(
            String code,
            String redirectUri,
            String codeVerifier
    ) {
        // 1. Exchange code for tokens with OAuth server
        Map<String, Object> tokenResponse = oauthServerClient
                .exchangeCode(code, redirectUri, codeVerifier);

        // 2. Extract and validate JWT
        String accessToken = (String) tokenResponse.get("access_token");
        Jwt jwt = jwtDecoder.decode(accessToken);

        // 3. Sync user with local DB
        userService.syncUserFromJwt(jwt);

        return tokenResponse;
    }
}