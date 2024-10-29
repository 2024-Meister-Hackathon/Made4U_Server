package org.example.made4u.core.common.security.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.infrastructure.security.auth.CustomUserDetail;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Boolean passwordMatches(String rawPassword, String encryptedPassword) {
        return passwordEncoder.matches(rawPassword, encryptedPassword);
    }

    @Override
    public String getCurrentUserEmail() {
        return ((CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).email();
    }
}
