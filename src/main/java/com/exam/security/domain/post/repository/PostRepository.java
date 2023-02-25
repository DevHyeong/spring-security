package com.exam.security.domain.post.repository;

import com.exam.security.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserEmail(String email);
}
