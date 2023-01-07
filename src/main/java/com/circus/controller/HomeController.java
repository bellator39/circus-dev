package com.circus.controller;

import com.circus.domain.Contacts;
import com.circus.service.api.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CircusShowServiceApi circusShowService;
    private final CircusNewsServiceApi circusNewsService;
    private final TagNewsServiceApi tagNewsService;
    private final TeamServiceApi teamService;
    private final ContactServiceApi contactService;

    private final TestimonalsServiceApi testimonalsService;


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("circusShow", circusShowService.findAllCircusShow());
        model.addAttribute("lastnews", circusNewsService.findAllCircusNews().stream().limit(3).collect(Collectors.toList()));
        model.addAttribute("tagservice", tagNewsService);
        model.addAttribute("testimonals",testimonalsService.listTestimonals());
        return "index";
    }

    @GetMapping("/aboutus")
    public String about(Model model) {
        model.addAttribute("teams", teamService.findAllTeam());
        return "aboutus";
    }

    @GetMapping("/gallery")
    public String gallery(Model model) {
        return "gallery";
    }


    @GetMapping("/contactus")
    public String contactuspage(Model model) {
        return "contacts";
    }

    @PostMapping("/contactus")
    public String contactussend(@RequestParam("name") String name,
                                @RequestParam("soname") String soname,
                                @RequestParam("email") String email,
                                @RequestParam("message") String message
    ,Model model) {
        Contacts contactsSend = Contacts.builder()
                .name(name)
                .soname(soname)
                .email(email)
                .message(message)
                .build();

        contactService.saveContact(contactsSend);
        model.addAttribute("message","Ваше сообщение отправленно! Спасибо, что вы с нами!");
        return "contacts";
    }
}
