package com.example.controller;



import com.example.converter.UserConverter;
import com.example.dto.UserDto;
import com.example.entity.UserEntity;
import com.example.entityService.UserEntityService;
import com.example.exceptionHandler.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")

public class UserController {
    @Autowired
    private UserEntityService userEntityService;

    @GetMapping("")
    public List<UserDto> findAllUser()
    {
        List<UserEntity> userEntityList = userEntityService.findAllUser();

        return UserConverter.INSTANCE.userEntityListConvertToUserDto(userEntityList);
    }

    @GetMapping("/{userName}")
    public UserDto findUserByUserName(@PathVariable String userName)
    {
        UserEntity userEntity = userEntityService.findUserByUserName(userName);

        return UserConverter.INSTANCE.userEntityConvertToUserDto(userEntity);
    }

    @GetMapping("/{userPhone}")
    public UserDto findUserByUserPhone(@PathVariable String userPhone)
    {
        UserEntity userEntity = userEntityService.findUserByUserName(userPhone);

        return UserConverter.INSTANCE.userEntityConvertToUserDto(userEntity);
    }

    @PostMapping()
    public UserDto SaveUser(@RequestBody UserDto userDto)
    {
        UserEntity userEntity =UserConverter.INSTANCE.userDtoConvertToUserEntity(userDto);
        UserEntity savedEntity = userEntityService.save(userEntity);
        return UserConverter.INSTANCE.userEntityConvertToUserDto(savedEntity);
    }
    @DeleteMapping()
    public void deleteUserByUserId(@PathVariable long userId)
    {
        UserEntity userEntity=userEntityService.findUserByUserId(userId);
        userEntityService.deleteUser(userEntity);
    }
    @DeleteMapping("/{userName}/{userPhone}")
    public void deleteUserByUserNameAndUserPhone(@PathVariable String userName,@PathVariable String userPhone)
    {
        UserEntity userEntity=userEntityService.findUserByPhoneAndUserName(userPhone,userName);
        if(userEntity==null)
        {
            throw new UserNotFoundException("Urun not found. Kullanıcı Telefonu: " + userPhone +" ile Kullanıcı Adı: "+userName +" bilgileri uyuşmamaktadır.");
        }
        userEntityService.deleteUser(userEntity);
    }
    @PutMapping()
    public UserDto update(@RequestBody UserDto userDto)
    {
        UserEntity userEntity =UserConverter.INSTANCE.userDtoConvertToUserEntity(userDto);
        UserEntity savedEntity = userEntityService.save(userEntity);
        UserDto resultDto=UserConverter.INSTANCE.userEntityConvertToUserDto(savedEntity);
        return resultDto;
    }
}
