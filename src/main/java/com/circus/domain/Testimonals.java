package com.circus.domain;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Builder
public class Testimonals {
    private Long id;
    private String name;
    private String soname;
    private String text;
    private String rating;
    private LocalDateTime date_send;
}
