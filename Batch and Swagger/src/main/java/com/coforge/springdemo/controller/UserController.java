package com.coforge.springdemo.controller;

import com.coforge.springdemo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/user")
@RequiredArgsConstructor
public class UserController {

    @GetMapping(path = "{userId}")
    public User getUser(@PathVariable String userId) {
        return null;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return null;
    }

}
