package org.example.made4u.core.presentation;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.user.dto.request.CreateUserRequest;
import org.example.made4u.core.domain.user.dto.request.LoginRequest;
import org.example.made4u.core.domain.user.dto.response.LoginResponse;
import org.example.made4u.core.domain.user.service.CommandUserService;
import org.example.made4u.core.domain.user.usecase.CreateUserUseCase;
import org.example.made4u.core.domain.user.usecase.DeleteUserUseCase;
import org.example.made4u.core.domain.user.usecase.LoginUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserWebAdapter {
    private final LoginUseCase loginUseCase;
    private final CreateUserUseCase createUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginUseCase.execute(request);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestPart("body") CreateUserRequest request, @RequestPart(value = "file", required = false) MultipartFile file) {
        createUserUseCase.createUser(request, file);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser() {
        deleteUserUseCase.execute();
    }
}
