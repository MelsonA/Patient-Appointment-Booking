//package com.example.Patientmanagement.service;
//
//import com.example.Patientmanagement.entity.Register;
//import com.example.Patientmanagement.repositories.RegisterRepository;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomAuthenticationManager implements AuthenticationManager {
//
//    private final RegisterRepository registerRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public CustomAuthenticationManager(RegisterRepository registerRepository, PasswordEncoder passwordEncoder) {
//        this.registerRepository = registerRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String usernameOrEmail = authentication.getName();
//        String password = authentication.getCredentials().toString();
//        if (isValidation(usernameOrEmail, password)) {
//            return new UsernamePasswordAuthenticationToken(usernameOrEmail, password);
//        } else {
//            throw new AuthenticationException("Invalid Credentials") {
//            };
//        }
//    }
//
//    public boolean isValidation(String usernameOrEmail, String password) {
//        Register register = registerRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
//
//        boolean usernameEqual = register.getUsername().equals(usernameOrEmail);
//        boolean passwordEqual = passwordEncoder.matches(password, register.getPassword());
//        return usernameEqual && passwordEqual;
//    }
//}
