package com.example.entityService;


import com.example.dao.UserDao;
import com.example.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.List;

@Service
public class UserEntityService {
    @Autowired
   private UserDao userDao;

    public List<UserEntity> findAllUser()
    {
        return userDao.findAll();
    }

    public UserEntity findUserByUserName(String userName)
    {
        return userDao.findByUserName(userName);
    }
    public UserEntity findUserByPhone(String phone)
    {
        return userDao.findByUserPhone(phone);
    }
    public UserEntity findUserByPhoneAndUserName(String phone,String userName)
    {
        return userDao.findByUserPhoneAndUserName(phone,userName);
    }
    public UserEntity save(UserEntity userEntity)
    {
        return userDao.save(userEntity);
    }
    public void deleteUser(UserEntity  userEntity)
    {
         userDao.delete(userEntity);
    }
    public UserEntity findUserByUserId(Long userId){return userDao.findByUserId(userId);}

}
