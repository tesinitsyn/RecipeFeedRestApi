package org.tesinitsyn.recipefeedrestapi.user.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.tesinitsyn.recipefeedrestapi.user.model.User;
import org.tesinitsyn.recipefeedrestapi.user.service.UserService;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/new-user")
    public ResponseEntity<User> addUser(@RequestBody User user) {

        User createUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String test() {
        return "Hello world";
    }

}
