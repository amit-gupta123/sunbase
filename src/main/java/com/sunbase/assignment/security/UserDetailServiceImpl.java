//package com.sunbase.assignment.security;
//
//import com.sunbase.assignment.admin.model.Admin;
//import com.sunbase.assignment.admin.repository.AdminRepository;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Collections;
//import java.util.Optional;
//
//public class UserDetailServiceImpl implements UserDetailService{
//    // dependencyInjection
//    private final AdminRepository adminRepository;
//    public UserDetailServiceImpl(AdminRepository adminRepository){
//        this.adminRepository = adminRepository;
//    }
//
//    @Override
//    public User loadUserByUserName(String email) throws UsernameNotFoundException {
//        Optional<Admin> admin = adminRepository.findByEmail(email);
//        if(admin.isEmpty()){
//            throw new UsernameNotFoundException("not found user with email"+email);
//        }
//        Admin admin1 = admin.get();
//        return new org.springframework.security.core.userdetails.User(
//                email,
//                admin1.getPassWord(),
//                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
//
//    }
//}
