package com.circus.controller;


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

}
