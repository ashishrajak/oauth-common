package com.shared.oauth.model.dto.users;


public record UserProfileResponse(
        String name,
        String givenName,
        String familyName,
        String middleName,
        String nickname,
        String preferredUsername,
        String profile,
        String website,
        String gender,
        String birthdate,
        String zoneinfo,
        String locale,
        AddressResponse address
) {}

