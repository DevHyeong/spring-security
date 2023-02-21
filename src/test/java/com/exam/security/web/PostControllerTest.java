package com.exam.security.web;

import com.exam.security.MockTestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PostControllerTest extends MockTestConfig {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("시큐리티 적용 테스트")
    void testSecurity () throws Exception{
        mockMvc.perform(get("/post/1"))
                .andExpect(status().is4xxClientError());
    }

}