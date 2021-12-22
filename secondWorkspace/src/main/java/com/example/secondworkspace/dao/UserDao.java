package com.example.dao;

import com.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity,Long> {
    UserEntity findByUserName(String userName);
    UserEntity findByUserPhone(String prhoneNumber);
    UserEntity findByUserPhoneAndUserName(String phoneNumber, String userName);

  UserEntity findByUserId(Long userId);
}
