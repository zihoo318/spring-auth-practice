package com.example.JWTP.repositrory;

import com.example.JWTP.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {


}
