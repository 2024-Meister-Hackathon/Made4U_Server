package org.example.made4u.core.domain.user.dto.request;

import org.example.made4u.persistence.user.entity.VeganType;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public record CreateUserRequest (
        String email,
        String password,
        String nickname,
        String[] tend,
        String[] favor,
        String vegetarian,
        String religion
) { }
