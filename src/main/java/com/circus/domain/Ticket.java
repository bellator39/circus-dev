package com.circus.domain;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Builder
public class Ticket {
    private Long id;
    private Long idShow;
    private Long idCustomer;
    private LocalDateTime dateBuy;
    private Long countTicket;
}
