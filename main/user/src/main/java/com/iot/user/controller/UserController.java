package com.iot.user.controller;

import com.iot.user.UserService;
import com.iot.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/add")
    public void addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }

    @PostMapping("/user/login")
    public ResponseEntity<Void> login(@RequestBody UserDto userDto) {
        return userService.login(userDto);
    }

    @GetMapping("/user/role")
    public ResponseEntity<String> getUserRole(@RequestBody UserDto userDto) {
        return userService.getUserRole(userDto);
    }
}
