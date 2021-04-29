package com.empregospernambuco1.service;

import com.empregospernambuco1.model.User;
import com.empregospernambuco1.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto userRegistrationDto);
    User findByEmail(String email);
}
