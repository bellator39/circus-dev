package com.circus.domain;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class CircusNews {
    private Long id;
    private String newsName;
    private String newsText;
    private LocalDateTime date_publication;
    private Long idAuthor;
    private Long tagNews;
}
