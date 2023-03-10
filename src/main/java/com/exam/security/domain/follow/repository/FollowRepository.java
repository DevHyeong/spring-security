package com.exam.security.domain.follow.repository;

import com.exam.security.domain.follow.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findByFromUserId(Long fromUserId);
}
