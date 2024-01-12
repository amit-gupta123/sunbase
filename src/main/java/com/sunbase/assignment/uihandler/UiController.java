package com.sunbase.assignment.uihandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UiController {

    @GetMapping("/login")
    public String getLoginPage(){
       return "login";
    }

    @GetMapping("/show-users")
    public String showUsers(){
        return "show_users";
    }

    @GetMapping("/add-user")
    public String addCustomer(){
        return "add_user";
    }


}
