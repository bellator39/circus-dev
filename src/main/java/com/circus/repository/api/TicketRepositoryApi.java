package com.circus.repository.api;

import com.circus.domain.CircusNews;
import com.circus.domain.Customer;
import com.circus.domain.TagNews;
import com.circus.domain.Ticket;

import java.util.List;

public interface TicketRepositoryApi {
    boolean saveTicket(Ticket ticketSave);
    Ticket getTicketById(Long idTicket);
    List<Ticket> findAllTicket();
    boolean deleteTicketById(Long idTicket);
    List<Ticket>findAllByCustomerId(Long idCustomer);
}
