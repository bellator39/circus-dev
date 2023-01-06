package com.circus.controller;

import com.circus.domain.TeamCircus;
import com.circus.domain.Ticket;
import com.circus.service.api.ContactServiceApi;
import com.circus.service.api.CustomerServiceApi;
import com.circus.service.api.TeamServiceApi;
import com.circus.service.api.TicketServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    private final TeamServiceApi teamService;

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

    @GetMapping("/allticketorder/today")
    public String allTicketOrderOnToday(Model model){
        model.addAttribute("ticketOrder",ticketService.findAllTicketOnToday());
        model.addAttribute("customerService",customerService);
        model.addAttribute("today","td");
        return "admin/allticketorder";
    }

    @GetMapping("/allworker")
    public String allWorker(Model model){
        model.addAttribute("workerList",teamService.findAllTeam());
        return "admin/allworker";
    }

    @GetMapping("/addworker")
    public String addWorkerPage(){
        return "admin/addworker";
    }

    @PostMapping("/addworker")
    public String addWorker(@RequestParam("name")String name,
                            @RequestParam("soname")String soname,
                            @RequestParam("work_position")String workposition,
                            @RequestParam("describe")String describe,
                            @RequestParam("link_facebook")String linkfacebook,
                            @RequestParam("urlphoto")String urlphoto,Model model){
        TeamCircus teamCircus = TeamCircus.builder()
                .name(name)
                .soname(soname)
                .work_position(workposition)
                .describe(describe)
                .link_facebook(linkfacebook)
                .urlphoto(urlphoto)
                .build();

        boolean result_save_team = teamService.saveTeam(teamCircus);

        if(result_save_team){
            return "redirect:/manager/allworker";
        }else{
            model.addAttribute("message","ms");
            return "admin/addworker";
        }
    }

    @GetMapping("/delete/worker/{id}")
    public String deleteWorker(@PathVariable("id")Long id){
        teamService.deleteTeam(id);
        return "redirect:/manager/allworker";
    }

}
