package com.exam.security.web;

import com.exam.security.domain.post.domain.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {

    @GetMapping(value = "/post/{id}")
    public Post getPost(@PathVariable final Long id){
        return new Post();
    }

}
