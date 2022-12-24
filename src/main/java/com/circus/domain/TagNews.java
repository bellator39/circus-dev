package com.circus.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Builder
public class TagNews {
    private Long id;
    private String tagName;
}
