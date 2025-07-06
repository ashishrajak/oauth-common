package com.shared.oauth.model.dto.users;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public record UserInfoResponse(
        // User identification
        UUID id,
        String email,
        boolean emailVerified,

        // Authentication info
        String provider,
        String providerId,
        Set<String> roles,
        boolean mfaEnabled,
        Set<String> mfaMethods,
        String status,

        // Contact info
        String phoneNumber,
        boolean phoneVerified,
        String picture,

        // Profile data
        UserProfileResponse profile,

        // Timestamps
        Instant lastLogin,
        Instant createdAt,
        Instant updatedAt,

        // Connected clients
        List<ConnectedClientResponse> connectedClients,

        // Metadata
        Map<String, Object> metadata
) {}