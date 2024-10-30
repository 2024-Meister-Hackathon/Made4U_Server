package org.example.made4u.core.domain.user.service;

import org.example.made4u.core.domain.user.dto.request.CreateUserRequest;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.springframework.web.multipart.MultipartFile;

public interface CommandUserService {

    void createUser(UserJpaEntity user);

    void deleteUserByEmail(String email);
}
