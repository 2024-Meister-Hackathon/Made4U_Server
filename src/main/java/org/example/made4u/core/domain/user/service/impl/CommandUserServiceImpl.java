package org.example.made4u.core.domain.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.user.dto.request.CreateUserRequest;
import org.example.made4u.core.domain.user.exception.EmailAlreadyExistException;
import org.example.made4u.core.domain.user.service.CommandUserService;
import org.example.made4u.infrastructure.thirdparty.s3.FileUploader;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.entity.VeganType;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandUserServiceImpl implements CommandUserService {
    private final SecurityService securityService;
    private final UserJpaRepository userJpaRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final FileUploader fileUploader;

    @Override
    public void createUser(CreateUserRequest request, MultipartFile file) {
        if (userJpaRepository.findByEmail(request.email()).isPresent()) {
            throw EmailAlreadyExistException.EXCEPTION;
        }

        String profile = null;
        if (file != null) {
            profile = fileUploader.upload(file);
        }

        userJpaRepository.save(UserJpaEntity.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .nickname(request.nickname())
                .profile(profile)
                .email(request.email())
                .favor(String.join(",", request.favor()))
                .tend(String.join(",", request.tend()))
                .vegetarian(VeganType.valueOf(request.vegetarian()))
                .build()
        );
    }

    @Override
    public void deleteUser() {
        String email = securityService.getCurrentUserEmail();

        userJpaRepository.deleteById(email);
    }
}
