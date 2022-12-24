package com.circus.service.api;

import com.circus.domain.Ticket;

import java.util.List;

public interface TicketServiceApi {
    boolean saveTicket(Ticket ticketSave);
    Ticket getTicketById(Long idTicket);
    List<Ticket> findAllTicket();
    boolean deleteTicketById(Long idTicket);
    List<Ticket>findAllByCustomerId(Long idCustomer);
}
