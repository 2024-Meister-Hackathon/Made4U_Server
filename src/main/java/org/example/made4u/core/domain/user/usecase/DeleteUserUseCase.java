package org.example.made4u.core.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.user.service.CommandUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteUserUseCase {
    private final SecurityService securityService;
    private final CommandUserService commandUserService;

    public void execute() {
        commandUserService.deleteUserByEmail(securityService.getCurrentUserEmail());
    }
}
