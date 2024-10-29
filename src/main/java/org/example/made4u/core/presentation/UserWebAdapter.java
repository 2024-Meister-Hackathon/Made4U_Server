package org.example.made4u.core.presentation;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.user.dto.request.CreateUserRequest;
import org.example.made4u.core.domain.user.dto.request.LoginRequest;
import org.example.made4u.core.domain.user.dto.response.LoginResponse;
import org.example.made4u.core.domain.user.service.CommendUserService;
import org.example.made4u.core.domain.user.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserWebAdapter {
    private final LoginService loginService;
    private final CommendUserService commendUserService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.loginResponse(request);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody CreateUserRequest request) {
        commendUserService.createUser(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser() {
        commendUserService.deleteUser();
    }
}
