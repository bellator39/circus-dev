package com.circus.controller;

import com.circus.domain.Ticket;
import com.circus.service.api.ContactServiceApi;
import com.circus.service.api.CustomerServiceApi;
import com.circus.service.api.TicketServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@PreAuthorize("hasAuthority('MANAGER')")
@RequestMapping("/manager")
public class ManagerController {

    private final ContactServiceApi contactService;

    private final TicketServiceApi ticketService;

    private final CustomerServiceApi customerService;

    @GetMapping("/allfeedback")
    public String allFeedback(Model model){
        model.addAttribute("contactList",contactService.findAllContact());
        return "admin/allfeedback";
    }

    @GetMapping("/feedback/delete/{id}")
    public String deleteFeedback(@PathVariable("id")Long idfeedback){
        contactService.deleteContact(idfeedback);
        return "redirect:/manager/allfeedback";
    }

    @GetMapping("/allticketorder")
    public String allTicketOrder(Model model){
        model.addAttribute("ticketOrder",ticketService.findAllTicket());
        model.addAttribute("customerService",customerService);
        return "admin/allticketorder";
    }

}
