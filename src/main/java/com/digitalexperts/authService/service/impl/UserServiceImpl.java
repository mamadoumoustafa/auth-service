package com.digitalexperts.authService.service.impl;

import com.digitalexperts.authService.bo.User;
import com.digitalexperts.authService.repository.UserRepository;
import com.digitalexperts.authService.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByMail(String mail) {
        return userRepository.findByEmailEqualsIgnoreCase(mail);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
