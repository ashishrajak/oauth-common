package com.shared.oauth.model.dto.users;

public record AddressResponse(
        String street,
        String city,
        String state,
        String zip,
        String country,
        String postalCode
) {}
