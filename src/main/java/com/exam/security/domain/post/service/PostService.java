package com.exam.security.domain.post.service;

import com.exam.security.common.exception.PostNotFoundException;
import com.exam.security.config.SecuredUser;
import com.exam.security.domain.post.entity.Post;
import com.exam.security.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    public void create(Post post, SecuredUser securedUser){
        post.setUser(securedUser.getUser());
        post.setUserId(securedUser.getUser().getId());

        Post p = postRepository.findTop1ByUserIdOrderByIdDesc(post.getUserId())
                .orElse(new Post(0L));
        /**
         *  @Question
         *  비즈니스 로직에서 id 값을 +1 해주고 있기 때문에,
         *  잘못하면 이전 포스트를 update 할 수도 있는 위험 존재.
         *
         * */
        post.setId(p.getId() + 1L);

        postRepository.save(post);
    }


    public Post getPost(String email, Long id){
        Post post = postRepository.findByUserEmailAndId(email, id);

        if(post == null)
            throw new PostNotFoundException();

        return post;
    }

    public List<Post> getPosts(String email) {
        List<Post> posts = postRepository.findByUserEmail(email);

        if(posts == null && posts.size() < 1)
            throw new PostNotFoundException();

        return posts;
    }
}
