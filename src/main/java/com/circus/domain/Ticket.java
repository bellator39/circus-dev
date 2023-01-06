package com.circus.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

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
    private UUID uuid_order;
    private Float summa_order;
    private String status;

}
