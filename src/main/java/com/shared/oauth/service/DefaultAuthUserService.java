package com.shared.oauth.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@ConditionalOnMissingBean(AuthUserService.class)
public class DefaultAuthUserService implements AuthUserService {

    private static final Logger logger = LoggerFactory.getLogger(DefaultAuthUserService.class);

    private static final String IMPLEMENTATION_MESSAGE =
            "Please implement AuthUserService in your project for proper user management functionality";

    @Override
    public void syncUserFromJwt(Jwt jwt) {
        logger.warn("syncUserFromJwt called but not implemented. {}", IMPLEMENTATION_MESSAGE);
        logJwtDetails(jwt);
    }

    @Override
    public Optional<? extends Object> findUserByEmail(String email) {
        logger.warn("findUserByEmail called but not implemented. Email: {}. {}", email, IMPLEMENTATION_MESSAGE);
        return Optional.empty();
    }

    @Override
    public Optional<? extends Object> findUserById(String id) {
        logger.warn("findUserById called but not implemented. ID: {}. {}", id, IMPLEMENTATION_MESSAGE);
        return Optional.empty();
    }

    @Override
    public Optional<? extends Object> findActiveUserByUserId(String id) {
        logger.warn("findActiveUserByUserId called but not implemented. ID: {}. {}", id, IMPLEMENTATION_MESSAGE);
        return Optional.empty();
    }

    @Override
    public boolean existsByUserId(String userId) {
        logger.warn("existsByUserId called but not implemented. UserID: {}. {}", userId, IMPLEMENTATION_MESSAGE);
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        logger.warn("existsByEmail called but not implemented. Email: {}. {}", email, IMPLEMENTATION_MESSAGE);
        return false;
    }

    private void logJwtDetails(Jwt jwt) {
        logger.info("JWT Details - Subject: {}, Email: {}, Name: {}",
                jwt.getSubject(),
                jwt.getClaim("email"),
                jwt.getClaim("name"));
    }
}