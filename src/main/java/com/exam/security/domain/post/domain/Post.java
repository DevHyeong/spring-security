package com.exam.security.domain.post.domain;

import com.exam.security.domain.common.BaseEntity;
import com.exam.security.domain.user.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    private User user;
}
