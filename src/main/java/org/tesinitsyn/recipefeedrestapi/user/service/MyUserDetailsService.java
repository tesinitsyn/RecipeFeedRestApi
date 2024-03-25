package org.tesinitsyn.recipefeedrestapi.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.tesinitsyn.recipefeedrestapi.user.config.MyUserDetails;
import org.tesinitsyn.recipefeedrestapi.user.model.User;
import org.tesinitsyn.recipefeedrestapi.user.respository.UserRepository;

import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + "not found"));
    }
}
