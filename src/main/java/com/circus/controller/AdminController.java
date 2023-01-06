package com.circus.controller;


import com.circus.domain.Circus;
import com.circus.domain.Customer;
import com.circus.domain.RoleUser;
import com.circus.service.api.CircusShowServiceApi;
import com.circus.service.api.CustomerServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Slf4j
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin")
public class AdminController {

    private final CustomerServiceApi customerService;
    private final CircusShowServiceApi circusShowService;

    @GetMapping("/allshow")
    public String CircusShowList(Model model){
        model.addAttribute("circusShowList",circusShowService.findAllCircusShow());
        return "admin/allshow";
    }

    @GetMapping("/allcustomer")
    public String CustomerList(Model model){
        model.addAttribute("customerList",customerService.findAllCustomer().stream().filter(o1->!o1.getUsername().equals("Admin")).collect(Collectors.toList()));
        return "admin/allcustomer";
    }

    @GetMapping("/edit/customer/{id}")
    public String editCustomerPage(@PathVariable("id")Long id, Model model){
        model.addAttribute("editCustomer",customerService.getCustomerById(id));
        return "admin/editcustomer";
    }

    @PostMapping("/edit/customer/{id}")
    public String editCustomer(@PathVariable("id")Long id,
                               @RequestParam("name")String name,
                               @RequestParam("soname")String soname,
                               @RequestParam("username")String username,
                               @RequestParam("email")String email,
                               @RequestParam("role")String role,
                               Model model){

        Customer customer = customerService.getCustomerById(id);
        customer.setName(name);
        customer.setSoname(soname);
        customer.setUsername(username);
        customer.setEmail(email);
        customer.setRolename(RoleUser.valueOf(role));

        customerService.updateCustomer(customer);

        return "redirect:/admin/allcustomer";
    }

    @GetMapping("/addshow")
    public String addShowPage(){
        return "admin/addshow";
    }

    @PostMapping("/addshow")
    public String addShow(@RequestParam("name")String name,
                          @RequestParam("countticket")Integer countticket,
                          @RequestParam("price")String price,
                          @RequestParam("urlphoto")String url,
                          @RequestParam("datetime")String datetime,
                          @RequestParam("describe")String describe,
                          @RequestParam("typeshow")Long typeshow, Model model){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        Circus circusShow = Circus.builder()
                .name(name)
                .describe(describe)
                .urlPathLogoPhoto(url)
                .countAvailableTicket(countticket)
                .dateShow(LocalDateTime.parse(datetime,DateTimeFormatter.ISO_DATE_TIME))
                .priceShow(Float.valueOf(price.replace(',','.')))
                .typeShow(typeshow)
                .build();

        boolean result_save_show = circusShowService.saveCircusShow(circusShow);

        if(result_save_show){
            return "redirect:/admin/allshow";
        }else{
            model.addAttribute("message","ms");
            return "admin/addshow";
        }
    }

    @GetMapping("/delete/show/{id}")
    public String deleteShow(@PathVariable("id")Long id){
        circusShowService.deleteCircusShow(id);
        return "redirect:/admin/allshow";
    }

    @GetMapping("/edit/show/{id}")
    public String EditShowPage(@PathVariable("id")Long id,
                               Model model){
        model.addAttribute("editShow",circusShowService.getCircusShowById(id));
        model.addAttribute("price",circusShowService.getCircusShowById(id).getPriceShow().toString().replace('.',','));
        return "admin/editshow";
    }

    @PostMapping("/edit/show/{id}")
    public String EditShow(@RequestParam("name")String name,
                          @RequestParam("countticket")Integer countticket,
                          @RequestParam("price")String price,
                          @RequestParam("urlphoto")String url,
                          @RequestParam("datetime")String datetime,
                          @RequestParam("describe")String describe,
                          @RequestParam("typeshow")Long typeshow, Model model,@PathVariable("id")Long id){

        Circus circus = circusShowService.getCircusShowById(id);
        circus.setName(name);
        circus.setCountAvailableTicket(countticket);
        circus.setPriceShow(Float.valueOf(price.replace(',','.')));
        circus.setUrlPathLogoPhoto(url);
        circus.setDateShow(LocalDateTime.parse(datetime,DateTimeFormatter.ISO_DATE_TIME));
        circus.setDescribe(describe);
        circus.setTypeShow(typeshow);

        circusShowService.updateCircusShow(circus);

        return "redirect:/admin/allshow";
    }
}
