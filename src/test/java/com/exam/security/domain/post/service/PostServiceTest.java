package com.exam.security.domain.post.service;

import com.exam.security.common.exception.PostNotFoundException;
import com.exam.security.domain.post.entity.Post;
import com.exam.security.domain.post.repository.PostRepository;
import com.exam.security.domain.user.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Test
    void testGetPostThrowsPostNotFoundException() {
        final String email = "wogud19@naver.com";

        when(postRepository.findByUserEmailAndId(email, 1L))
                .thenReturn(null);
        assertThrows(PostNotFoundException.class, ()->postService.getPost(email, 1L));
    }

    @Test
    void testGetPost() {

        User user = new User();
        user.setEmail("wogud4222@naver.com");
        user.setPassword("1234");
        user.setNickname("생각하는개발자12");

        Post post = new Post();
        post.setId(1l);
        post.setTitle("제목1");
        post.setContent("내용내용");
        post.setUserId(user.getId());
        post.setUser(user);

        when(postRepository.findByUserEmailAndId(user.getEmail(), user.getId()))
                .thenReturn(post);
        Post result = postService.getPost(user.getEmail(), user.getId());

        assertEquals(result.getId(), post.getId());
        assertEquals(result.getTitle(), post.getTitle());
    }

}