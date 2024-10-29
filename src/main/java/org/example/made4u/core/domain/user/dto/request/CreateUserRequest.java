package org.example.made4u.core.domain.user.dto.request;

import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public record CreateUserRequest (
        String email,
        String password,
        String nickname,
        Optional<String> profile,
        String[] tend,
        String[] favor,
        Boolean isVegetarian
) { }
