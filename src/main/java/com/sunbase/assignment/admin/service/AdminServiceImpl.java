package com.sunbase.assignment.admin.service;

import com.sunbase.assignment.admin.model.Admin;
import com.sunbase.assignment.admin.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final  AdminRepository adminRepository ;
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        Admin admin1 =  adminRepository.save(admin);
        return admin1;
    }

    @Override
    public Admin getAdminById(Long id) {
         adminRepository.findById(id);
         return new Admin("123","Admin");
    }
}
