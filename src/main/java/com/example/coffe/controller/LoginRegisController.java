package com.example.coffe.controller;

import com.example.coffe.model.dto.*;
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

    @PostMapping("/user")
    public DefaultResponse login(@RequestBody LoginUserDto loginUserDto){
        DefaultResponse df = new DefaultResponse();
        Optional<User> optionalUser = loginUserRepository.findByNoTelpAndPass(loginUserDto.getNoTelp(), loginUserDto.getPass());

        if(optionalUser.isPresent()){
            df.setStatus(Boolean.TRUE);
            df.setMessage("Login Berhasil");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Silahkan Register Terlebih Dahulu");
        }
        return df;

    }

    @PostMapping("/admin")
    public DefaultResponse login(@RequestBody LoginAdminDto loginAdminDto){
        DefaultResponse df = new DefaultResponse();
        Optional<Admin> optionalAdmin = loginAdminRepository.findByNoTelpAndPass(loginAdminDto.getNoTelp(), loginAdminDto.getPass());

        if(optionalAdmin.isPresent()){
            df.setStatus(Boolean.TRUE);
            df.setMessage("Login Berhasil");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Silahkan Register Terlebih Dahulu");
        }
        return df;

    }
    @PostMapping("/reguser")
    public RegisResponse<UserDto> regisUser(@RequestBody UserDto userDto){
        User user = convertDtoEnUser(userDto);
        RegisResponse<UserDto> responses = new RegisResponse<>();
        Optional<User> optional = loginUserRepository.findByNoTelpAndPass(userDto.getNoTelp(), userDto.getPass());
        if(optional.isPresent()){
            responses.setMessages("Error, Data Sudah Tersedia. Silahkan login");
        } else {
            loginUserRepository.save(user);
            responses.setMessages("Berhasil Register");
            responses.setData(userDto);
        }
        return responses;
    }

    @PostMapping("/regadmin")
    public RegisResponse<AdminDto> regisAdmin(@RequestBody AdminDto adminDto){
        Admin admin = convertDtoEnAdmin(adminDto);
        RegisResponse<AdminDto> responses = new RegisResponse<>();
        Optional<Admin> optional = loginAdminRepository.findByNoTelpAndPass(adminDto.getNoTelp(), adminDto.getPass());
        if(optional.isPresent()){
            responses.setMessages("Error, Data Sudah Tersedia. Silahkan login");
        } else {
            loginAdminRepository.save(admin);
            responses.setMessages("Berhasil Register");
            responses.setData(adminDto);
        }
        return responses;
    }

    public User convertDtoEnUser(UserDto dto){
        User user = new User();
        user.setIdUser(dto.getIdUser());
        user.setAlamat(dto.getAlamat());
        user.setNama(dto.getNama());
        user.setNoTelp(dto.getNoTelp());
        user.setPass(dto.getPass());
        return user;
    }

    public Admin convertDtoEnAdmin(AdminDto dto){
        Admin admin = new Admin();
        admin.setIdAdmin(dto.getIdAdmin());
        admin.setAlamat(dto.getAlamat());
        admin.setNama(dto.getNama());
        admin.setNoTelp(dto.getNoTelp());
        admin.setPass(dto.getPass());
        return admin;
    }


}
