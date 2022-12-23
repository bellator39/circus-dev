package com.circus.domain;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Circus {
    private Long id;
    private String name;
    private String describe;
    private String urlPathLogoPhoto;
    private Integer countAvailableTicket;
    private LocalDateTime dateShow;
    private Float priceShow;
    private TypeShow typeShow;
}
