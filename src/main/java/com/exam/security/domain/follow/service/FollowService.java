package com.exam.security.domain.follow.service;

import com.exam.security.domain.follow.entity.Follow;
import com.exam.security.domain.follow.repository.FollowRepository;
import com.exam.security.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;

    public Follow save(User fromUser, User toUser){
        Follow follow = new Follow(fromUser, toUser);
        follow.init();
        return followRepository.save(follow);
    }

}
