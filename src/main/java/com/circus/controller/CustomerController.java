package com.circus.controller;

import com.circus.domain.Customer;
import com.circus.service.api.CustomerServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerServiceApi customerServiceApi;

    @GetMapping("/signup")
    public String customerSignUp(Model model){
        return "auth/registration";
    }

    @PostMapping("/signup")
    public String customerSignUp(@RequestParam(name = "name")String name,
                                 @RequestParam(name = "soname")String soname,
                                 @RequestParam(name = "username")String username,
                                 @RequestParam(name = "password")String password,
                                 @RequestParam(name = "email")String email,
                                 Model model){
        Customer customer = Customer.builder()
                .name(name)
                .soname(soname)
                .username(username)
                .password(password)
                .email(email)
                .build();

        boolean result_sign_up_customer = customerServiceApi.saveCustomer(customer);

        if(result_sign_up_customer){
            System.out.println(customer);
            return "auth/login";
        }else{
            model.addAttribute("message","Пользователь с таким username уже существует!");
            return "auth/registration";
        }

    }

}
