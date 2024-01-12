//package com.sunbase.assignment.security;
//
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class JWTFilter extends OncePerRequestFilter {
//    private final JWTUtil jwtUtil;
//    private final UserDetailService userDetailService;
//
//    public JWTFilter(JWTUtil jwtUtil, UserDetailService userDetailService) {
//        this.jwtUtil = jwtUtil;
//        this.userDetailService = userDetailService;
//    }
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//
//
//        String authHeader = request.getHeader("Authorization");
//        if(authHeader!=null && !authHeader.isBlank()&& authHeader.startsWith("Bearer ")){
//            String jwt = authHeader.substring(7);
//            if(jwt == null || jwt.isBlank()){
//                response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Invalid Jwt token in bearer header");
//            }else{
//                try{
//                    String email = jwtUtil.validateTokenAndRetrieveSubject(jwt);
//                    UserDetails userDetails = userDetailService.loadUserByUserName(email);
//                    UsernamePasswordAuthenticationToken authToken =
//                            new UsernamePasswordAuthenticationToken(email, userDetails.getPassword(), userDetails.getAuthorities());
//                    if(SecurityContextHolder.getContext().getAuthentication()==null){
//                        SecurityContextHolder.getContext().setAuthentication(authToken);
//                    }
//                }catch (JWTVerificationException exception){
//                    response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Invalid Jwt Token");
//                }
//                filterChain.doFilter(request,response);
//            }
//        }
//
//
//    }
//}
