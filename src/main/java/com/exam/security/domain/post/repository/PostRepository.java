package com.exam.security.domain.post.repository;

import com.exam.security.domain.post.domain.Post;
import com.exam.security.domain.post.domain.pk.PostPk;
import com.exam.security.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, PostPk> {
    Post findByUserEmailAndId(String email, Long id);
    List<Post> findByUserEmail(String email);
}
