package com.exam.security.domain.post.entity;

import com.exam.security.domain.common.BaseEntity;
import com.exam.security.domain.post.entity.pk.PostPk;
import com.exam.security.domain.user.entity.Role;
import com.exam.security.domain.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@IdClass(PostPk.class)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Id
    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    private String title;
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "grade")
    private Role role;

    public Post(){

    }
    public Post(Long id){
        this.id = id;
    }

}
