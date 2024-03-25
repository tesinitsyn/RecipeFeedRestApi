package org.tesinitsyn.recipefeedrestapi.user.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.tesinitsyn.recipefeedrestapi.user.model.User;
import org.tesinitsyn.recipefeedrestapi.user.respository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
