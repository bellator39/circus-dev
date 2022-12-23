package com.circus.domain;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class TeamCircus {
    private Long id;
    private String name;
    private String soname;
    private String work_position;
    private String describe;
    private String link_facebook;
    private LocalDateTime date_create;
}
