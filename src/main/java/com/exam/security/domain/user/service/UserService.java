package com.exam.security.domain.user.service;

import com.exam.security.domain.user.entity.User;
import com.exam.security.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ShaPasswordEncoder shaPasswordEncoder;

    public User join(User user){
        user.setPassword(shaPasswordEncoder.encode(user.getEmail(), user.getPassword()));
        return userRepository.save(user);
    }
}
