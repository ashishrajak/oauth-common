package common.shared.oauth.service;

import org.springframework.security.oauth2.jwt.Jwt;
import java.util.Optional;

public interface AuthUserService {

    void syncUserFromJwt(Jwt jwt);
    Optional<? extends Object> findUserByEmail(String email);
    Optional<? extends Object> findUserById(String id);
    Optional<? extends Object> findActiveUserByUserId(String id);
    boolean existsByUserId(String userId);
    boolean existsByEmail(String email);
}
