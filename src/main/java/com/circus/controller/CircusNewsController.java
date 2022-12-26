package com.circus.controller;

import com.circus.service.api.CircusNewsServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class CircusNewsController {

    private final CircusNewsServiceApi circusNewsService;

    @GetMapping("/circus/news")
    public String circusNewsPage(Model model){
        model.addAttribute("news",circusNewsService.findAllCircusNews());
        return "circusnews";
    }

    @GetMapping("/circus/news/{id}")
    public String circusNewsCurrent(@PathVariable("id")String id){
        return "";
    }

}
