//package com.example.ecommerce.service;
//
//import com.example.ecommerce.entity.User;
//import com.example.ecommerce.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@Service
//public class UserService implements UserDetailsService {
//
//    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
//
//    private final UserRepository userRepository;
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserService(@Lazy UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public User register(User user) {
//        Optional<User> existingUser = findByEmail(user.getEmail());
//        if (existingUser.isPresent()) {
//            logger.warn("Attempt to register existing user: {}", user.getEmail());
//            return null; // or throw an exception
//        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        User savedUser = userRepository.save(user);
//        logger.info("User registered successfully: {}", savedUser.getEmail());
//        return savedUser; // Return saved user data
//    }
//
//    public Optional<User> findByEmail(String email) {
//        return Optional.ofNullable(userRepository.findByEmail(email));
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(username);
//        if (user == null) {
//            logger.error("User not found: {}", username);
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
//                new ArrayList<>()
//        );
//    }
//}
