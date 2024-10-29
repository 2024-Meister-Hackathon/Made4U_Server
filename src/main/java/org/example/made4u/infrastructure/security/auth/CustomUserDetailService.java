package org.example.made4u.infrastructure.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService {
    public CustomUserDetail getCustomUserDetailByEmail(String email) {

        return new CustomUserDetail("email");
    }
}
