package com.circus.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class RoleUser implements GrantedAuthority {
    private Long id;
    private String nameRole;
    @Override
    public String getAuthority() {
        return getNameRole();
    }
}
