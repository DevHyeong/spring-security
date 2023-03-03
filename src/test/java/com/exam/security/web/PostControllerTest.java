package com.exam.security.web;

import com.exam.security.MockTestConfig;
import com.exam.security.config.UserDetailsService;
import com.exam.security.domain.post.entity.Post;
import com.exam.security.domain.user.entity.Role;
import com.exam.security.domain.user.entity.User;
import com.exam.security.domain.user.service.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.TestExecutionEvent;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PostControllerTest extends MockTestConfig {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @BeforeEach
    public void setUp() throws Exception{

        System.out.println("start");

        User user = new User();
        user.setEmail("wogud19@naver.com");
        user.setPassword("1234");
        user.setNickname("생각하는개발자");
        userService.join(user);
    }

    @Test
    @DisplayName("시큐리티 적용 테스트")
    void testSecurity () throws Exception{
        mockMvc.perform(get("/post/1"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @WithUserDetails(value = "wogud19@naver.com", setupBefore = TestExecutionEvent.TEST_EXECUTION)
    void testCreatePost() throws Exception{
        Post post = new Post();
        post.setTitle("제목222");
        post.setContent("내용111");
        post.setRole(Role.NORMAL);

        mockMvc.perform(post("/post/create")
                        .content(new ObjectMapper().writeValueAsString(post))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/post/wogud19@naver.com/1"))
                .andDo(print());

    }

    @Test
    @WithUserDetails(value = "wogud19@naver.com", setupBefore = TestExecutionEvent.TEST_EXECUTION)
    void testGetPost() throws Exception{

        mockMvc.perform(get("/post/wogud19@naver.com/1"))
                .andDo(print());

    }

}