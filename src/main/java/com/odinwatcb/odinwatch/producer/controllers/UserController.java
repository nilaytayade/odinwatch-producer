package com.odinwatcb.odinwatch.producer.controllers;

import com.odinwatcb.odinwatch.producer.entities.UserEntity;
import com.odinwatcb.odinwatch.producer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserEntity createUser(@RequestParam String email, @RequestParam String password) {
        return userService.createUser(email, password);
    }
}
