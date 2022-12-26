package com.circus.controller;

import com.circus.domain.TagNews;
import com.circus.service.api.CircusNewsServiceApi;
import com.circus.service.api.TagNewsServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class CircusNewsController {

    private final CircusNewsServiceApi circusNewsService;
    private final TagNewsServiceApi tagNewsService;

    @GetMapping("/circus/news")
    public String circusNewsPage(Model model){
        model.addAttribute("news",circusNewsService.findAllCircusNews());
        return "circusnews";
    }

    @GetMapping("/circus/news/{id}")
    public String circusNewsCurrent(@PathVariable("id")Long id,Model model){
        model.addAttribute("curNews",circusNewsService.getCircusNewsById(id));
        model.addAttribute("tags",tagNewsService.findAllTagNews());
        model.addAttribute("crsr",circusNewsService);
        model.addAttribute("recNews",circusNewsService.findAllCircusNews().stream().limit(3).collect(Collectors.toList()));
        return "circusnewssingle";
    }

    @GetMapping("/circus/news/{idtag}/{tgname}")
    public String newsByTag(@PathVariable("idtag")Long idtag,
                            @PathVariable("tgname")String tgname,
                            Model model){
        TagNews tagNews = TagNews.builder()
                .id(idtag)
                .tagName(tgname)
                .build();
        model.addAttribute("news",circusNewsService.findAllByTag(tagNews));
        return "circusnews";
    }

    @PostMapping("/circus/news/find")
    public String findNewsByName(@RequestParam("name")String name, Model model){
        model.addAttribute("news",circusNewsService.findAllCircusNews().stream().filter(o1->o1.getNewsName().contains(name)).collect(Collectors.toList()));
        return "circusnews";
    }

}
