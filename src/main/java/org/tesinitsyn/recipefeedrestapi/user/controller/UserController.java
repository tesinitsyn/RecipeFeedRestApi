package org.tesinitsyn.recipefeedrestapi.user.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tesinitsyn.recipefeedrestapi.user.model.User;
import org.tesinitsyn.recipefeedrestapi.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;


    @PostMapping("/new-user")
    public ResponseEntity<User> addUser(@RequestBody User user) {

        User createUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

}
