package org.example.made4u.core.domain.user.service;

import org.example.made4u.core.domain.user.dto.request.LoginRequest;
import org.example.made4u.core.domain.user.dto.response.LoginResponse;

public interface LoginService {

    LoginResponse loginResponse(LoginRequest request);
}
