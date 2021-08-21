package com.digitalexperts.authService.service;

import com.digitalexperts.authService.bo.User;

public interface UserService {

    User findByUsername(String username);
    User findByMail(String mail);
    User save(User user);

}
