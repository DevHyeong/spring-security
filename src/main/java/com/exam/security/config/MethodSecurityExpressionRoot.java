package com.exam.security.config;

import com.exam.security.domain.post.entity.Post;
import com.exam.security.domain.user.entity.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

@Slf4j
@Getter
@Setter
public class MethodSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    private Object filterObject;
    private Object returnObject;

    /**
     * Creates a new instance
     *
     * @param authentication the {@link Authentication} to use. Cannot be null.
     */
    public MethodSecurityExpressionRoot(Authentication authentication, MethodInvocation methodInvocation) {
        super(authentication);
    }

    public boolean isPostAuthenticated(Post post){
        SecuredUser securedUser = (SecuredUser) getAuthentication().getPrincipal();
        String authority = post.getUserId() + "/" + post.getRole();

        if(post.getUserId().equals(securedUser.getUser().getId())){
            return true;
        }

        if(post.getRole().equals(Role.NORMAL)){
            return true;
        }

        /**
         *  @Question
         *  권한 계층을 어디서 어떻게 구현해야할까..?
         *
         *
         * */
        //RoleHierarchyImpl

        return securedUser.getAuthorities().stream()
                .filter(e-> e.getAuthority().equals(authority))
                .findFirst()
                .isPresent();

    }


    @Override
    public Object getThis() {
        return getThis();
    }
}
