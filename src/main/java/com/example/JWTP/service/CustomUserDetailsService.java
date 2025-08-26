package com.example.JWTP.service;

import com.example.JWTP.DTO.CustomUserDetails;
import com.example.JWTP.entity.UserEntity;
import com.example.JWTP.repositrory.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //DB에서 조회
        UserEntity userData = userRepository.findByUsername(username);

        if (userData == null) throw new UsernameNotFoundException("User not found: " + username);
        return new CustomUserDetails(userData);
    }
}
