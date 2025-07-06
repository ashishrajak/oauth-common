package com.shared.oauth.model.dto.users;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public record ConnectedClientResponse(
    UUID id,
    String clientId,
    Set<String> scopes,
    Instant accessGranted,
    Instant lastUsed
) {}