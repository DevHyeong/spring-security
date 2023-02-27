package com.exam.security.domain.follow.repository;

import com.exam.security.domain.follow.entity.Follow;
import com.exam.security.domain.user.entity.Role;
import com.exam.security.domain.user.entity.User;
import com.exam.security.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FollowRepositoryTest {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFollower(){
        User fromUser = new User();
        fromUser.setEmail("wogud19@gmail.com");
        fromUser.setNickname("생각하는개발자");
        fromUser.setPassword("1234");
        userRepository.save(fromUser);

        User toUser = new User();
        toUser.setEmail("wogud2@gmail.com");
        toUser.setNickname("생각하는개발자1");
        toUser.setPassword("1234");
        userRepository.save(toUser);

        Follow follow = new Follow(fromUser, toUser);
        follow.init();

        Follow result = followRepository.save(follow);
        assertEquals(result.getFromUser().getNickname(), fromUser.getNickname());
        assertEquals(result.getToUser().getNickname(), toUser.getNickname());

        List<Follow> follows = followRepository.findByFromUserId(fromUser.getId());
        assertEquals(follows.size(), 1);
    }
}