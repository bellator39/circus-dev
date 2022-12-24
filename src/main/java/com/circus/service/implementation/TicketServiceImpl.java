package com.circus.service.implementation;

import com.circus.domain.Circus;
import com.circus.domain.Customer;
import com.circus.domain.Ticket;
import com.circus.repository.api.TicketRepositoryApi;
import com.circus.service.api.CircusShowServiceApi;
import com.circus.service.api.CustomerServiceApi;
import com.circus.service.api.TicketServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class TicketServiceImpl implements TicketServiceApi {

    private final CustomerServiceApi customerService;
    private final CircusShowServiceApi circusShowService;
    private final TicketRepositoryApi ticketRepository;

    @Override
    public boolean saveTicket(Ticket ticketSave) {
        Customer customerCheck = customerService.getCustomerById(ticketSave.getIdCustomer());
        Circus circusCheck = circusShowService.getCircusShowById(ticketSave.getIdShow());
        ticketSave.setDateBuy(LocalDateTime.now());
        if(circusCheck!=null && customerCheck!=null){
            Integer countTicketShow =circusCheck.getCountAvailableTicket();
            countTicketShow--;
            circusCheck.setCountAvailableTicket(countTicketShow);
            circusShowService.updateCircusShow(circusCheck);
            log.info("Save ticket with service, id customer {} id show {} in {}",customerCheck.getId(),circusCheck.getId(),new Date());
            return ticketRepository.saveTicket(ticketSave);
        }else{
            log.error("Cannot save ticket, customer or circus equals null in {}", new Date());
            return false;
        }
    }

    @Override
    public Ticket getTicketById(Long idTicket) {
        if(idTicket!=null){
            log.info("Get ticket by id with service, id {} in {}",idTicket,new Date());
            return ticketRepository.getTicketById(idTicket);
        }else{
            log.error("Cannot get ticket by id, equals null in {}",new Date());
            return null;
        }
    }

    @Override
    public List<Ticket> findAllTicket() {
        log.info("Get all ticket with service in {}", new Date());
        return ticketRepository.findAllTicket();
    }

    @Override
    public boolean deleteTicketById(Long idTicket) {
        Ticket ticketCheck = ticketRepository.getTicketById(idTicket);
        Customer customerCheck = customerService.getCustomerById(ticketCheck.getIdCustomer());
        Circus circusCheck = circusShowService.getCircusShowById(ticketCheck.getIdShow());
        if(circusCheck!=null && customerCheck!=null){
            log.info("Delete ticket by id with service, id {} in {}",idTicket,new Date());
            return ticketRepository.deleteTicketById(idTicket);
        }else{
            log.error("Cannot delete ticket by id, equals null in {}",new Date());
            return false;
        }
    }

    @Override
    public List<Ticket> findAllByCustomerId(Long idCustomer) {
        Customer customerCheck = customerService.getCustomerById(idCustomer);
        if(customerCheck!=null) {
            log.info("Get ticket by customer id with service, id {} in {}",idCustomer,new Date());
            return ticketRepository.findAllByCustomerId(idCustomer);
        }else {
            log.error("Cannot get ticket by customer id, equals null in {}",new Date());
            return null;
        }
    }
}
