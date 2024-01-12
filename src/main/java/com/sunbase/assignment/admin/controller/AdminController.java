package com.sunbase.assignment.admin.controller;

import com.sunbase.assignment.admin.model.Admin;
import com.sunbase.assignment.admin.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/")
    public String home(){
        return "login";
    }

    @PostMapping("/admin")
    public Admin saveAdmin(@RequestBody Admin admin){
        Admin admin1 =  adminService.saveAdmin(admin);
        return admin1;
    }

    //@GetMapping("/admin/{id}")
    private Admin getAdminById(/*@PathVariable*/  Long id){
        return adminService.getAdminById(id);
    }

    @PostMapping("/login")
    public String login(@ModelAttribute(name = "Admin")Admin admin, Model model){
        Long id = admin.getId();
        String pass = admin.getPassWord();
        System.out.println(id);
        Admin existingAdmin = this.getAdminById(id);
        if(existingAdmin!=null && existingAdmin.getPassWord().equals(pass)){
           // return "login";
            System.out.println("hi");
        }
        return "show_users";
    }
}
