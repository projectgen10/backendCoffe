package com.example.coffe.controller;

import com.example.coffe.model.dto.*;
import com.example.coffe.model.entity.Roles;
import com.example.coffe.model.entity.User;
import com.example.coffe.repository.LoginUserRepository;
import com.example.coffe.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginRegisController {

    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private RolesRepository rolesRepository;

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

    @PostMapping("/reguser")
    public RegisResponse<UserDto> regisUser(@RequestBody UserDto userDto){
        User user = convertDtoEnUser(userDto);
        RegisResponse<UserDto> responses = new RegisResponse<>();
        Roles roles = new Roles();
        Optional<User> optional = loginUserRepository.findByNoTelpAndPass(userDto.getNoTelp(), userDto.getPass());
        if(optional.isPresent()){
            responses.setMessages("Error, Data Sudah Tersedia. Silahkan login");
        } else {
            roles.setRole(userDto.getRole());
            rolesRepository.save(roles);
            loginUserRepository.save(user);
            responses.setMessages("Berhasil Register");
            responses.setData(userDto);
        }
        return responses;
    }

    @DeleteMapping("/deluser")
    public RegisResponse<UserDto> delUser(@RequestBody UserDto userDto){
        User user = convertDtoEnUser(userDto);
        RegisResponse<UserDto> responses = new RegisResponse<>();
        Optional<User> optional = loginUserRepository.findById(userDto.getIdUser());
        if(optional.isPresent()){
            loginUserRepository.delete(user);
            //gimana caranya bisa ikut delete roles disini? :D
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


}
