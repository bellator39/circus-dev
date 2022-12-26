package com.circus.controller;


import com.circus.domain.Ticket;
import com.circus.service.api.CircusShowServiceApi;
import com.circus.service.api.TicketServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class TickerController {
    private final TicketServiceApi ticketService;
    private final CircusShowServiceApi circusShowService;

    @GetMapping("/myticket/{idcustomer}")
    public String customerTicket(@PathVariable("idcustomer") Long idcustomer,
                                 Model model) {
        model.addAttribute("tickets", ticketService.findAllByCustomerId(idcustomer));
        model.addAttribute("circusShowService", circusShowService);
        model.addAttribute("datenow", LocalDateTime.now());
        return "ticketpage";
    }

    @PostMapping("/ticket/buy/{idshow}/{iduser}")
    public String buyTicket(@PathVariable("idshow") Long idshow,
                            @PathVariable("iduser") Long iduser,
                            @RequestParam("count") Long count,
                            Model model) {
        Ticket ticketBuy = Ticket.builder()
                .idShow(idshow)
                .idCustomer(iduser)
                .countTicket(count)
                .build();
        ticketService.saveTicket(ticketBuy);
        model.addAttribute("message", "message");
        return "redirect:/myticket/" + iduser;
    }
    @GetMapping("/ticket/delete/{id}/{userid}")
    public String deleteTicket (@PathVariable("id")Long id,
                                @PathVariable("userid")Long userid) {
    ticketService.deleteTicketById(id);
    return "redirect:/myticket/"+userid;
    }
}
