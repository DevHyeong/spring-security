package com.exam.security.domain.post.entity.pk;

import javax.persistence.Column;
import java.io.Serializable;


public class PostPk implements Serializable {

    private Long id;

    @Column(name = "user_id")
    private Long userId;

}
