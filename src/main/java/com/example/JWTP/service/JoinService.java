package com.example.JWTP.service;

import com.example.JWTP.DTO.JoinDTO;
import com.example.JWTP.entity.UserEntity;
import com.example.JWTP.repositrory.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void joinProcess(JoinDTO joinDTO){ // 원래는 리턴타입 boolean으로 회원가입 성공 유무를 반환 지금은 임시

        String username = joinDTO.getUsername();
        String password = joinDTO.getPassword();

        Boolean isExist = userRepository.existsByUsername(username);

        if (isExist) { return; }

        UserEntity data = new UserEntity();

        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));  // 암호화해서 pwd 저장
        data.setRole("ROLE_ADMIN"); // 임시로 강제 지정

        userRepository.save(data);
    }
}
