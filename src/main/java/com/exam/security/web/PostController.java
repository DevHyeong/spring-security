package com.exam.security.web;

import com.exam.security.config.SecuredUser;
import com.exam.security.domain.post.entity.Post;
import com.exam.security.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @PostMapping(value = "/post/create")
    public void create(@AuthenticationPrincipal SecuredUser securedUser, @RequestBody Post post){
        postService.create(post, securedUser);
    }

    @GetMapping(value = "/post/{email}/{id}")
    @PostAuthorize("isPostAuthenticated(returnObject)")
    public Post getPost(@PathVariable final String email, @PathVariable final Long id){
        return postService.getPost(email, id);
    }

    @GetMapping(value = "/post/{email}")
    public List<Post> getPosts(@PathVariable final String email){
        return postService.getPosts(email);
    }

}
