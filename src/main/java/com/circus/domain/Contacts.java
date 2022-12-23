package com.circus.domain;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Contacts {
    private Long id;
    private String name;
    private String soname;
    private String email;
    private String message;
    private LocalDateTime date_send;
}
