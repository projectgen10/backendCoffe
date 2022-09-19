package com.example.coffe.controller;

import com.example.coffe.model.dto.*;
import com.example.coffe.model.entity.Roles;
import com.example.coffe.model.entity.User;
import com.example.coffe.repository.LoginUserRepository;
import com.example.coffe.repository.RolesRepository;
import com.example.coffe.service.ServiceAdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:8080")
@RestController
@RequestMapping("/user")
public class LoginRegisController {

    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private ServiceAdminUser serviceAdminUser;

    @PostMapping("/login")
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

    @PostMapping("/logout")
    public DefaultResponse logout(@RequestBody LoginUserDto loginUserDto){
        DefaultResponse df = new DefaultResponse();
        Optional<User> optionalUser = loginUserRepository.findByNoTelpAndPass(loginUserDto.getNoTelp(), loginUserDto.getPass());
        if(optionalUser.isPresent()){
            df.setStatus(Boolean.TRUE);
            df.setMessage("Logout Berhasil");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Error silahkan login terlebih dahulu");
        }
        return df;

    }

    // ini tambah multipart
    @PostMapping("/reguser")
    public ResponseEntity<Responses> regisUser(@RequestParam("file") MultipartFile file, User user, Roles roles){
        String message = "";
        try {
            serviceAdminUser.register(file, user, roles);
            message = "Registered successfully ";
            return ResponseEntity.status(HttpStatus.OK).body(new Responses(message));
        } catch (Exception e) {
            message = "Could not register !";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Responses(message));
        }
    }

    @DeleteMapping("/deluser")
    public RegisResponse<UserDto> delUser(@RequestBody UserDto userDto){
        User user = convertDtoEnUser(userDto);
        Roles roles = convertDtotoEnRole(userDto);
        RegisResponse<UserDto> responses = new RegisResponse<>();
        Optional<User> optional = loginUserRepository.findById(userDto.getIdUser());
        Optional<Roles> optional1 = rolesRepository.findById(userDto.getIdRole());
        if(optional.isPresent() && optional1.isPresent()){
            loginUserRepository.delete(user);
            rolesRepository.delete(roles);
            responses.setMessages("Data berhasil dihapus");
        } else {
            responses.setMessages("Informasi salah. Data tidak dapat dihapus");
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

    public Roles convertDtotoEnRole(UserDto dto){
        Roles roles = new Roles();
        roles.setRole(dto.getRole());
        roles.setIdRole(dto.getIdRole());
        return roles;
    }


}
