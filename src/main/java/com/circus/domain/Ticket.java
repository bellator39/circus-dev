package com.circus.domain;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Ticket {
    private Long id;
    private Long idShow;
    private Long idUser;
    private LocalDateTime dateBuy;
}
