package com.az.example.conference.controller;

import com.az.example.conference.model.UserDto;
import com.az.example.conference.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/registration")
    public void registration(@RequestBody @Valid UserDto userDto) {
        userService.registration(userDto);

    }
}
