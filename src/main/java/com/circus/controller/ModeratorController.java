package com.circus.controller;

import com.circus.domain.CircusNews;
import com.circus.service.api.CircusNewsServiceApi;
import com.circus.service.api.TagNewsServiceApi;
import com.circus.service.api.TestimonalsServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

@Controller
@RequestMapping("/moderator")
@Slf4j
@PreAuthorize("hasAuthority('MODERATOR')")
@RequiredArgsConstructor
public class ModeratorController {

    private final CircusNewsServiceApi circusNewsService;
    private final TagNewsServiceApi tagNewsService;
    private final TestimonalsServiceApi testimonalsService;

    @GetMapping("/allnews")
    public String adminAllNews(Model model) {
        model.addAttribute("tagService", tagNewsService);
        model.addAttribute("newsList", circusNewsService.findAllCircusNews());
        return "admin/allnews";
    }

    @GetMapping("/delete/{id}")
    public String deleteNewsById(@PathVariable("id") Long id) {
        circusNewsService.deleteCircusNews(id);
        return "redirect:/moderator/allnews";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("editNews", circusNewsService.getCircusNewsById(id));
        return "admin/editnews";
    }

    @GetMapping("/addnews")
    public String addnewsPage(Model model) {
        model.addAttribute("tagList", tagNewsService.findAllTagNews());
        return "admin/addnews";
    }

    @PostMapping("/addnews/{idauthor}")
    public String addNews(@RequestParam("name") String name,
                          @RequestParam("Text") String text,
                          @RequestParam("url") String url,
                          @RequestParam("tag") Long id,
                          @PathVariable("idauthor") Long idauthor,Model model) {
        CircusNews circusNews = CircusNews.builder()
                .newsName(name)
                .newsText(text)
                .urllogonews(url)
                .tagNews(id)
                .idAuthor(idauthor)
                .build();

        boolean newsSaveResult = circusNewsService.saveCircusNews(circusNews);

        if(newsSaveResult){
            return "redirect:/moderator/allnews";
        }else{
            model.addAttribute("tagList", tagNewsService.findAllTagNews());
            model.addAttribute("message","message");
            return "admin/addnews";
        }
     }

    @PostMapping("/edit/{id}")
    public String editNewsById(@PathVariable("id") Long id,
                               @RequestParam("name") String name,
                               @RequestParam("Text") String text,
                               @RequestParam("url") String url) {
        CircusNews circusNews = circusNewsService.getCircusNewsById(id);
        circusNews.setNewsName(name);
        circusNews.setNewsText(text);
        circusNews.setUrllogonews(url);
        circusNewsService.updateCircusNews(circusNews);
        return "redirect:/moderator/allnews";
    }

    @GetMapping("/allTestimonals")
    public String allTestimonals(Model model) {
        model.addAttribute("testimonalsList", testimonalsService.listTestimonals());
        return "admin/alltestimonals";
    }

    @GetMapping("/testimonals/delete/{id}")
    public String deleteTestimonalsById(@PathVariable("id") Long id) {
        testimonalsService.deleteTestimonals(id);
        return "redirect:/moderator/allTestimonals";
    }

}
