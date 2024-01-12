package com.sunbase.assignment.customer.controller;

import com.sunbase.assignment.customer.model.Customer;
import com.sunbase.assignment.customer.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CustomerUiController {
    private final CustomerService customerService;

    public CustomerUiController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/add")
    public String addCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "add_user";
    }

    @GetMapping("/api/v1/customer/updateform/{id}")
    public String showFormForUpdate(@PathVariable Long id,  Model model){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer",customer);
        return "update_customer";
    }
}
