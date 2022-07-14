package com.example.coffe.controller;

import com.example.coffe.model.dto.AdminDto;
import com.example.coffe.model.dto.DefaultResponse;
import com.example.coffe.model.dto.UserDto;
import com.example.coffe.model.entity.Admin;
import com.example.coffe.model.entity.User;
import com.example.coffe.repository.LoginAdminRepository;
import com.example.coffe.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginRegisController {

    @Autowired
    private LoginAdminRepository loginAdminRepository;

    @Autowired
    private LoginUserRepository loginUserRepository;

    @GetMapping ("/user")
    public DefaultResponse login(@RequestBody UserDto userDto){
        DefaultResponse df = new DefaultResponse();
        Optional<User> optionalUser = loginUserRepository.findByNoTelpAndPass(userDto.getNoTelp(), userDto.getPass());

        if(optionalUser.isPresent()){
            df.setStatus(Boolean.TRUE);
            df.setMessage("Login Berhasil");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Silahkan Register Terlebih Dahulu");
        }
        return df;

    }

    @GetMapping("/admin")
    public DefaultResponse login(@RequestBody AdminDto adminDto){
        DefaultResponse df = new DefaultResponse();
        Optional<Admin> optionalAdmin = loginAdminRepository.findByNoTelpAndPass(adminDto.getNoTelp(), adminDto.getPass());

        if(optionalAdmin.isPresent()){
            df.setStatus(Boolean.TRUE);
            df.setMessage("Login Berhasil");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Silahkan Register Terlebih Dahulu");
        }
        return df;

    }


}
