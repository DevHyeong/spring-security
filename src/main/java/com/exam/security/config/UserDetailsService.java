package com.exam.security.config;

import com.exam.security.domain.follow.entity.Follow;
import com.exam.security.domain.follow.repository.FollowRepository;
import com.exam.security.domain.user.entity.User;
import com.exam.security.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException(username));

        List<Follow> follows = followRepository.findByFromUserId(user.getId());
        List<SimpleGrantedAuthority> grantedAuthorities = follows.stream()
                .map(e-> new SimpleGrantedAuthority(e.getToUser().getId() + "/" + e.getRole()))
                .collect(Collectors.toList());

        return new SecuredUser(user, grantedAuthorities);
    }
}
