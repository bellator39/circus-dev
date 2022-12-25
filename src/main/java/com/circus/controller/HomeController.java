package com.circus.controller;

import com.circus.service.api.CircusNewsServiceApi;
import com.circus.service.api.CircusShowServiceApi;
import com.circus.service.api.TagNewsServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CircusShowServiceApi circusShowService;
    private final CircusNewsServiceApi circusNewsService;
    private final TagNewsServiceApi tagNewsService;
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("circusShow",circusShowService.findAllCircusShow());
        model.addAttribute("lastnews",circusNewsService.findAllCircusNews().stream().limit(3).collect(Collectors.toList()));
        model.addAttribute("tagservice",tagNewsService);
        return "index";
    }

    @GetMapping("/aboutus")
    public String about(){
        return "aboutus";
    }
}
