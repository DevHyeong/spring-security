package com.exam.security.domain.post.repository;

import com.exam.security.domain.post.domain.Post;
import com.exam.security.domain.user.domain.User;
import com.exam.security.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testGetPost(){
        User user = new User();
        user.setEmail("wogud19@naver.com");
        user.setPassword("1234");
        user.setNickname("생각하는개발자");
        userRepository.save(user);

        Post post = new Post();
        post.setId(1l);
        post.setTitle("제목1");
        post.setContent("내용내용");
        post.setUserId(user.getId());
        post.setUser(user);
        postRepository.save(post);

        User user1 = new User();
        user1.setEmail("wogud4222@naver.com");
        user1.setPassword("1234");
        user1.setNickname("생각하는개발자12");
        userRepository.save(user1);

        Post post1 = new Post();
        post1.setId(1l);
        post1.setTitle("제목12222");
        post1.setContent("내용내용22222");
        post1.setUser(user1);
        post1.setUserId(user1.getId());
        postRepository.save(post1);

        assertEquals(postRepository.findAll().size(), 2);
    }

    @Test
    void testGetPost2(){
        User user = new User();
        user.setEmail("wogud19@naver.com");
        user.setPassword("1234");
        user.setNickname("생각하는개발자");
        userRepository.save(user);

        Post post = new Post();
        post.setId(1l);
        post.setTitle("제목1");
        post.setContent("내용내용");
        post.setUser(user);
        post.setUserId(user.getId());
        postRepository.save(post);

        Post post1 = new Post();
        post1.setId(1l);
        post1.setTitle("제목12222");
        post1.setContent("내용내용22222");
        post1.setUser(user);
        post1.setUserId(user.getId());
        postRepository.save(post1);

        assertEquals(postRepository.findAll().size(), 1);

    }

    @Test
    void testGetPosts(){
        User user = new User();
        user.setEmail("wogud19@naver.com");
        user.setPassword("1234");
        user.setNickname("생각하는개발자");
        userRepository.save(user);

        Post post = new Post();
        post.setId(1L);
        post.setTitle("제목1");
        post.setContent("내용내용");
        post.setUserId(user.getId());
        post.setUser(user);
        postRepository.save(post);

        Post post1 = new Post();
        post1.setId(2L);
        post1.setTitle("제목2");
        post1.setContent("내용은 별거없다아아아아아아");
        post1.setUserId(user.getId());
        post1.setUser(user);
        postRepository.save(post1);

        List<Post> result = postRepository.findByUserEmail(user.getEmail());

        for(Post p : result){
            assertEquals(user, p.getUser());
        }
    }

}