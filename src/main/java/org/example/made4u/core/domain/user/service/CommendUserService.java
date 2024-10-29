package org.example.made4u.core.domain.user.service;

import org.example.made4u.core.domain.user.dto.request.CreateUserRequest;

public interface CommendUserService {
    void createUser(CreateUserRequest request);

    void deleteUser();
}
