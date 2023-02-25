package com.exam.security.domain.post.service;

import com.exam.security.common.exception.PostNotFoundException;
import com.exam.security.domain.post.domain.Post;
import com.exam.security.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

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
