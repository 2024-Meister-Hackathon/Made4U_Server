package org.example.made4u.core.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.user.dto.request.CreateUserRequest;
import org.example.made4u.core.domain.user.exception.EmailAlreadyExistException;
import org.example.made4u.core.domain.user.service.CheckUserService;
import org.example.made4u.core.domain.user.service.CommandUserService;
import org.example.made4u.core.domain.user.service.FindUserService;
import org.example.made4u.infrastructure.thirdparty.s3.FileUploader;
import org.example.made4u.persistence.user.entity.ReligionType;
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
public class CreateUserUseCase {
    private final CheckUserService checkUserService;
    private final CommandUserService commandUserService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final FileUploader fileUploader;

    public void createUser(CreateUserRequest request, MultipartFile file) {
        if (checkUserService.checkUserExistsByEmail(request.email())) {
            throw EmailAlreadyExistException.EXCEPTION;
        }

        // 프로필이 만약 있다면 설정
        String profile = null;
        if (file != null) profile = fileUploader.upload(file);

        commandUserService.createUser(UserJpaEntity.builder()
                            .email(request.email())
                            .password(passwordEncoder.encode(request.password()))
                            .nickname(request.nickname())
                            .profile(profile)
                            .email(request.email())
                            .favor(String.join(",", request.favor()))
                            .tend(String.join(",", request.tend()))
                            .vegetarian(VeganType.valueOf(request.vegetarian()))
                            .religion(ReligionType.valueOf(request.religion()))
                            .build()
        );
    }
}
