package common.shared.oauth.config.credentials;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "auth")
@Data
public class AuthProperties {
    private String tokenUrl;
    private String clientId;
    private String clientSecret;

    // Getters and setters
}

