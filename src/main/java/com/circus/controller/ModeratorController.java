package com.circus.controller;

import com.circus.service.api.CircusNewsServiceApi;
import com.circus.service.api.TagNewsServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.function.Function;

@Controller
@RequestMapping("/moderator")
@Slf4j
@PreAuthorize("hasAuthority('MODERATOR')")
@RequiredArgsConstructor
public class ModeratorController {

    private final CircusNewsServiceApi circusNewsService;
    private final TagNewsServiceApi tagNewsService;

    @GetMapping("/allnews")
    public String adminAllNews(Model model){
        model.addAttribute("tagService",tagNewsService);
        model.addAttribute("newsList",circusNewsService.findAllCircusNews());
        return "admin/allnews";
    }

}
