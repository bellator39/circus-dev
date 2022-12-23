package com.circus.domain;

import lombok.*;

import javax.management.relation.Role;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Customer {
    private Long id;
    private String name;
    private String soname;
    private String username;
    private String password;
    private String email;
    private Role role;
    private LocalDateTime date_registration;
}
