package com.circus.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;



public enum RoleUser implements GrantedAuthority{
    CUSTOMER,ADMIN,MODERATOR,MANAGER;

    @Override
    public String getAuthority() {
        return name();
    }
}

