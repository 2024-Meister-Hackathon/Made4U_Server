package org.example.made4u.core.domain.user.service;

import org.example.made4u.core.domain.user.dto.request.CreateUserRequest;
import org.springframework.web.multipart.MultipartFile;

public interface CommandUserService {

    void createUser(CreateUserRequest request, MultipartFile file);

    void deleteUser();
}
