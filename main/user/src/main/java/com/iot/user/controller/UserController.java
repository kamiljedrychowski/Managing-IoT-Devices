package com.iot.user.controller;

import com.iot.user.UserService;
import com.iot.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
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
    public void addUser(@RequestBody UserDto userDto){
        userService.addUser(userDto);
        log.info("User added to database");
    }
}
