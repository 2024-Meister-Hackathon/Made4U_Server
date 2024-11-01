package org.example.made4u.infrastructure.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public record JwtProperties (
        String secret,
        String header,
        String prefix,
        Long access_expire,
        Long refresh_expire
) { }
