package com.exam.security.domain.user.service;

import com.exam.security.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testJoin() throws Exception{
        User user = new User();
        final String password = "asdf1234!@";
        user.setEmail("test1234@gmail.com");
        user.setNickname("생각하는개발자");
        user.setPassword(password);

        User result = userService.join(user);
        assertEquals(user.getPassword(), result.getPassword());
        assertNotEquals(password, result.getPassword());
    }


}