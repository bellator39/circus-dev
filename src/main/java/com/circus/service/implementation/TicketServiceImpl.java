package com.circus.service.implementation;

import com.circus.domain.Circus;
import com.circus.domain.Customer;
import com.circus.domain.Ticket;
import com.circus.repository.api.TicketRepositoryApi;
import com.circus.service.api.CircusShowServiceApi;
import com.circus.service.api.CustomerServiceApi;
import com.circus.service.api.MailSenderServiceApi;
import com.circus.service.api.TicketServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class TicketServiceImpl implements TicketServiceApi {

    private final CustomerServiceApi customerService;
    private final CircusShowServiceApi circusShowService;
    private final TicketRepositoryApi ticketRepository;
    private final MailSenderServiceApi mailSenderServiceApi;

    @Override
    public boolean saveTicket(Ticket ticketSave) {
        Customer customerCheck = customerService.getCustomerById(ticketSave.getIdCustomer());
        Circus circusCheck = circusShowService.getCircusShowById(ticketSave.getIdShow());
        ticketSave.setDateBuy(LocalDateTime.now());
        if(circusCheck!=null && customerCheck!=null){
            UUID uuid_order = UUID.randomUUID();
            Float summa_order = circusCheck.getPriceShow() * ticketSave.getCountTicket();
            ticketSave.setUuid_order(uuid_order);
            ticketSave.setSumma_order(summa_order);
            ticketSave.setStatus("ОБРАБОТКА");
            Integer countTicketShow =circusCheck.getCountAvailableTicket();
            countTicketShow= Math.toIntExact(countTicketShow - ticketSave.getCountTicket());
            circusCheck.setCountAvailableTicket(countTicketShow);
            circusShowService.updateCircusShow(circusCheck);
            String message_with_number_ticket = "Здраствуйте, " + customerCheck.getName() +
                    " спасибо, за приобритение билетов. Номер вашего заказа - " + uuid_order
                    + ". Предъявтье его контролеру на входе. Спасибо, что вы с нами!";
            mailSenderServiceApi.send(customerCheck.getEmail(),"Билеты на шоу",message_with_number_ticket);
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

    @Override
    public List<Ticket>findAllTicketOnToday(){
        List<Circus>circusShowToday = circusShowService.findAllCircusShow().stream().filter(o1 -> o1.getDateShow()
                .format(DateTimeFormatter.ISO_DATE)
                .equals(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE)))
                .toList();
        List<Ticket>sourceTicket = ticketRepository.findAllTicket();
        List<Ticket>resultTicketOnToday = new LinkedList<>();
        for (Ticket ticket:sourceTicket
             ) {
            for (Circus circus:circusShowToday
                 ) {
                if(circus.ContaintId(ticket.getIdShow())){
                    resultTicketOnToday.add(ticket);
                }
            }
        }
        System.out.println("TICKET"+resultTicketOnToday);
        return resultTicketOnToday;
    }
}
