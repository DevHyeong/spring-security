package com.exam.security.domain.follow.entity;

import com.exam.security.domain.common.BaseEntity;
import com.exam.security.domain.user.entity.Role;
import com.exam.security.domain.user.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Follow extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User fromUser;

    @ManyToOne
    private User toUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "grade")
    private Role role;

    public Follow(User fromUser, User toUser){
        Assert.isTrue(!fromUser.getId().equals(toUser.getId()), "fromUser와 toUser가 동일한 회원입니다.");
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    public void init(){
        this.role = Role.NORMAL;
    }


}
