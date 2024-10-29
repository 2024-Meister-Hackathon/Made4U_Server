package org.example.made4u.core.domain.user.dto.request;

public record LoginRequest(
        String email,
        String password
) {
}
