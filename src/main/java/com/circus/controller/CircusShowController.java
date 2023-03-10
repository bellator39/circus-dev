package com.circus.controller;


import com.circus.domain.Testimonals;
import com.circus.domain.TypeShow;
import com.circus.service.api.CircusShowServiceApi;
import com.circus.service.api.TestimonalsServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CircusShowController {

    private final CircusShowServiceApi circusShowService;

    private final TestimonalsServiceApi testimonalsService;

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

    @PostMapping("/circusshow/find")
    public String circuShowFind(@RequestParam("name")String name,Model model){
        model.addAttribute("circusShow",circusShowService.findAllByName(name));
        return "circusshowlist";
    }

    @GetMapping("/circusshow/type/{typeId}")
    public String circusShowByType(@PathVariable("typeId")Long typeId, Model model){
        TypeShow typeShow = TypeShow.builder()
                .id(typeId)
                .build();
        model.addAttribute("circusShow",circusShowService.findAllCircusShowByTypeShow(typeShow));

        return "circusshowlist";
    }

    @GetMapping("/circusshow/testimonals")
    public String circusTestimonalsPage(){
        return "testimonals";
    }

    @PostMapping("/circusshow/testimonals")
    public String circusTesimonals(@RequestParam("name")String name,
                                   @RequestParam("soname")String soname,
                                   @RequestParam("text")String text,
                                   @RequestParam("rating")Integer rating){

        Testimonals testimonals = Testimonals.builder()
                .name(name)
                .soname(soname)
                .text(text)
                .rating(rating.toString())
                .build();

        testimonalsService.saveTestimonals(testimonals);
        return "redirect:/";
    }

}
