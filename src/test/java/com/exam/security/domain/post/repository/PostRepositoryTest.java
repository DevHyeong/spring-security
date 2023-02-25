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
    void testSavePost(){
        User user = new User();
        user.setEmail("wogud19@naver.com");
        user.setPassword("1234");
        user.setNickname("생각하는개발자");

        userRepository.save(user);

        Post post = new Post();
        post.setTitle("제목1");
        post.setContent("내용내용");

        postRepository.save(post);

        Post post1 = new Post();
        post.setTitle("제목2");
        post.setContent("내용은 별거없다아아아아아아");
        post.setUser(user);

        postRepository.save(post1);

        List<Post> result = postRepository.findByUserEmail(user.getEmail());

        for(Post p : result){
            assertEquals(user, p.getUser());
        }
    }

}