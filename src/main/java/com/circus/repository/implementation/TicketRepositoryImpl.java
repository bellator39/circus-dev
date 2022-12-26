package com.circus.repository.implementation;

import com.circus.domain.CircusNews;
import com.circus.domain.Ticket;
import com.circus.repository.api.TicketRepositoryApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class TicketRepositoryImpl implements TicketRepositoryApi {

    private final JdbcTemplate database;

    private final static String SAVE_TICKET = "insert into tickets(idshow, idcustomer, datebuy,\"countTicket\") values(?,?,?,?)";
    private final static String GET_TICKET_BY_ID = "select * from tickets where id=?";
    private final static String FIND_ALL_TICKET = "select * from tickets";
    private final static String DELETE_TICKET = "delete from tickets where id=?";
    private final static String FIND_ALL_TICKET_BY_CUSTOMER_ID = "select * from tickets where idcustomer=?";

    @Override
    public boolean saveTicket(Ticket ticketSave) {
        log.info("Save ticket with customer id {} in {}", ticketSave.getIdCustomer(), new Date());
        return database.update(SAVE_TICKET, ticketSave.getIdShow(), ticketSave.getIdCustomer(), ticketSave.getDateBuy(),ticketSave.getCountTicket()) > 0;
    }

    @Override
    public Ticket getTicketById(Long idTicket) {
        try {
            log.info("Get ticket by id {} in {}",idTicket,new Date());
            return database.queryForObject(GET_TICKET_BY_ID, new BeanPropertyRowMapper<>(Ticket.class), idTicket);
        } catch (DataAccessException exception) {
            log.error("Error get ticket by id {} with {} in {}", idTicket, exception.getMessage(), new Date());
            return null;
        }
    }

    @Override
    public List<Ticket> findAllTicket() {
        log.info("Find all ticket in {}",new Date());
        return database.query(FIND_ALL_TICKET,new BeanPropertyRowMapper<>(Ticket.class));
    }

    @Override
    public boolean deleteTicketById(Long idTicket) {
        log.warn("Delete ticket with id {} in {}",idTicket,new Date());
        return database.update(DELETE_TICKET,idTicket)>0;
    }

    @Override
    public List<Ticket> findAllByCustomerId(Long idCustomer) {
        log.info("Find all ticket by customer id {} in {}",idCustomer,new Date());
        return database.query(FIND_ALL_TICKET_BY_CUSTOMER_ID,new BeanPropertyRowMapper<>(Ticket.class),idCustomer);
    }
}
