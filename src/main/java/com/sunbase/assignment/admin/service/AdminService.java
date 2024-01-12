package com.sunbase.assignment.admin.service;

import com.sunbase.assignment.admin.model.Admin;

public interface AdminService  {
    Admin saveAdmin(Admin admin);
    Admin getAdminById(Long id);
}
