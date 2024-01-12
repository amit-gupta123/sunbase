package com.sunbase.assignment.customer.controller;

import com.sunbase.assignment.customer.model.Customer;
import com.sunbase.assignment.customer.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class CustomerController {

   /**
    * dependency injection.
    * */
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * this request interceptor persist an entity and redirect to same page
     * */

    @PostMapping("/api/v1/customer")
    public String createCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/api/v1/customers";
    }

    // api to read existing customer
    @GetMapping("/api/v1/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    // api to get list of all existing customers
    @GetMapping("/api/v1/customers")
    public String getAll(Model model){
        //model.addAttribute("listCustomers",customerService.getAllCustomer());
        // the getPages method return view, which in turn returned from here.
         return getPages(1,model,"firstName","asc");
        //return "show_users";
    }

    // api to update existing customers
    @PutMapping("/api/v1/customer/{id}")
    public void updateCustomer(@ModelAttribute("customer") Customer customer, @PathVariable Long id){
        customerService.updateCustomer(customer,id);
    }


    // api to delete existing customer
    @GetMapping("/api/v1/customer/delete/{id}")
    public String deleteCustomer(@PathVariable Long id){
            customerService.deleteCustomerById(id);
            return "redirect:/api/v1/customers";
    }

    // api for sorting and pagination
    @GetMapping("/page/{pageNo}")
    public String getPages(@PathVariable int pageNo, Model model,
                           @RequestParam String sortBasis,
                           @RequestParam String sortingOrder
        ){
        int pageSize = 5;
        Page<Customer> page = customerService.getPages(pageNo,pageSize,sortBasis,sortingOrder);
        List<Customer> customerList = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());

        //these three attributes are used in template to support sorting.
        model.addAttribute("sortBasis",sortBasis);
        model.addAttribute("sortingOrder",sortingOrder);
        model.addAttribute("reverseSortingOrder",sortingOrder.equals("asc")?"desc":"asc");

        model.addAttribute("listCustomers",customerList);
        return "show_users";
    }

}



