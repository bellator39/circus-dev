package com.circus.controller;


import com.circus.service.api.CircusShowServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class CircusShowController {

    private final CircusShowServiceApi circusShowService;

    @GetMapping("/circusshow")
    public String circusShowlist(Model model){
        model.addAttribute("circusShow",circusShowService.findAllCircusShow());
        return "circusshowlist";
    }

    @GetMapping("/circusshow/{id}")
    public String circusShowlist(@PathVariable("id")Long id,
                                 Model model){
        model.addAttribute("circusShowCurr",circusShowService.getCircusShowById(id));
        return "circusshowsingle";
    }

}
