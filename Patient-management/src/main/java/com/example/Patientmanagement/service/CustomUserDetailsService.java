//package com.example.Patientmanagement.service;
//
//import com.example.Patientmanagement.entity.Register;
//import com.example.Patientmanagement.repositories.RegisterRepository;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Optional;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final RegisterRepository registerRepository;
//
//    public CustomUserDetailsService(RegisterRepository registerRepository) {
//        this.registerRepository = registerRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
//        Register user = registerRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername(),
//                user.getPassword(),
//                mapRolesToAuthorities(Collections.singleton("ROLE_USER"))
//        );
//    }
//
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<String> roles) {
//        return roles.stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//    }
//}
