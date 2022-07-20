package com.example.coffe.controller;


import com.example.coffe.model.dto.AdminDto;
import com.example.coffe.model.dto.DefaultResponse;
import com.example.coffe.model.dto.RegisResponse;
import com.example.coffe.model.dto.UserDto;
import com.example.coffe.model.entity.Admin;
import com.example.coffe.model.entity.Pembayaran;
import com.example.coffe.model.entity.User;
import com.example.coffe.repository.LoginAdminRepository;
import com.example.coffe.repository.LoginUserRepository;
import com.example.coffe.service.ServiceAdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private LoginAdminRepository loginAdminRepository;

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

    @GetMapping("/viewAdmin")
    public List<AdminDto> getListAdmin(){
        List<AdminDto> list = new ArrayList<>();
        for (Admin admin : loginAdminRepository.findAll()){
            list.add(convertEntityToDtoAd(admin));
        }
        return list;
    }

    @PostMapping("/profileUser")
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

    @PostMapping("/profileAdmin")
    public RegisResponse<AdminDto> profileAdmin(@RequestBody AdminDto adminDto){
        RegisResponse<AdminDto> responses = new RegisResponse<>();
        Optional<Admin> optional = loginAdminRepository.findById(adminDto.getIdAdmin());
        if(optional.isPresent()){
            responses.setMessages("Data Ditemukan");
            responses.setData(convertEntityToDtoAd(optional.get()));
        } else {
            responses.setMessages("Data Tidak Ditemukan");
        }

        return responses;
    }


    @PutMapping("/updatead/{id_user}")
    public RegisResponse<User> updateLog(@PathVariable ("id_user") Integer idUser,@RequestBody User user){
        RegisResponse<User> responses = new RegisResponse<>();
        Optional<User> optional = loginUserRepository.findById(idUser);
        if(optional.isPresent()){
            serviceAdminUser.updateProfileUser(idUser,user);
            responses.setMessages("Data berhasil di update");
        } else {
            responses.setMessages("Error. Data tidak ditemukan");
        }
        return responses;
    }


//    @PutMapping({"/{id_user}"})
//    public ResponseEntity<User> updateLog(@PathVariable("id_user") Integer idUser, @RequestBody User user){
//        RegisResponse<User> responses = new RegisResponse<>();
//        Optional<User> optional = loginUserRepository.findById(idUser);
//        if(optional.isPresent()){
//            serviceAdminUser.updateProfileUser(idUser, user);
//            responses.setMessages("Data berhasil di update");
//        } else {
//            responses.setMessages("Error. Data tidak dapat di update");
//        }
//        return new ResponseEntity<>(serviceAdminUser.getPemById(idUser), HttpStatus.OK);
//    }

    public UserDto convertEntityToDtoUs(User entity){
        UserDto dto = new UserDto();
        dto.setIdUser(entity.getIdUser());
        dto.setAlamat(entity.getAlamat());
        dto.setNama(entity.getNama());
        dto.setNoTelp(entity.getNoTelp());
        dto.setPass(entity.getPass());

        return dto;
    }

    public AdminDto convertEntityToDtoAd(Admin entity){
        AdminDto dto = new AdminDto();
        dto.setIdAdmin(entity.getIdAdmin());
        dto.setAlamat(entity.getAlamat());
        dto.setNama(entity.getNama());
        dto.setNoTelp(entity.getNoTelp());
        dto.setPass(entity.getPass());

        return dto;
    }
}