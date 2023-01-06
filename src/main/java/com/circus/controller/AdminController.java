package com.circus.controller;


import com.circus.service.api.CircusShowServiceApi;
import com.circus.service.api.CustomerServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("customerList",customerService.findAllCustomer());
        return "admin/allcustomer";
    }

}
