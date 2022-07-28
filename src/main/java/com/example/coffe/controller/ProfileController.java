package com.example.coffe.controller;


import com.example.coffe.model.dto.RegisResponse;
import com.example.coffe.model.dto.UserDto;
import com.example.coffe.model.entity.User;
import com.example.coffe.repository.LoginUserRepository;
import com.example.coffe.service.ServiceAdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProfileController {

    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    ServiceAdminUser serviceAdminUser;

    @GetMapping("/viewUser")
    public List<UserDto> getListUser(){
        List<UserDto> list = new ArrayList<>();
        for (User user : loginUserRepository.findAll()){
            list.add(convertEntityToDtoUs(user));
        }
        return list;
    }

    @PostMapping ("/profileUser")
    public RegisResponse<UserDto> profileUser(@RequestBody UserDto userDto){
        RegisResponse<UserDto> responses = new RegisResponse<>();
        Optional<User> optional = loginUserRepository.findById(userDto.getIdUser());
        if(optional.isPresent()){
            responses.setMessages("Data Ditemukan");
            responses.setData(convertEntityToDtoUs(optional.get()));
        } else {
            responses.setMessages("Data Tidak Ditemukan");
        }

        return responses;
    }

    @PutMapping("/updateus")
    public RegisResponse<User> updateLog(@RequestBody User user){
        RegisResponse<User> responses = new RegisResponse<>();
        Optional<User> optional = loginUserRepository.findById(user.getIdUser());
        if(optional.isPresent()){
            serviceAdminUser.updateProfileUser(user);
            responses.setMessages("Data berhasil di update");
        } else {
            responses.setMessages("Error. Data tidak dapat di update");
        }
        return responses;
    }

    public UserDto convertEntityToDtoUs(User entity){
        UserDto dto = new UserDto();
        dto.setIdUser(entity.getIdUser());
        dto.setAlamat(entity.getAlamat());
        dto.setNama(entity.getNama());
        dto.setNoTelp(entity.getNoTelp());
        dto.setPass(entity.getPass());

        return dto;
    }
}
