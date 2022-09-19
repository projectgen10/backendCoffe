package com.example.coffe.controller;


import com.example.coffe.model.dto.RegisResponse;
import com.example.coffe.model.dto.Responses;
import com.example.coffe.model.dto.UserDto;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:5173")
@RestController
public class ProfileController {

    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    ServiceAdminUser serviceAdminUser;

    @GetMapping("/viewUser")
    public List<UserDto> getListUser() {
        List<UserDto> list = new ArrayList<>();
        for (User user : loginUserRepository.findAll()) {
            for (Roles roles : rolesRepository.findAll())
                list.add(convertEntityToDtoUsr(user, roles));
        }
        return list;
    }

    @PostMapping("/profileUser")
    public RegisResponse<UserDto> profileUser(@RequestBody UserDto userDto) {
        RegisResponse<UserDto> responses = new RegisResponse<>();
        Optional<User> optional = loginUserRepository.findById(userDto.getIdUser());
        Optional<Roles> optional1 = rolesRepository.findById(userDto.getIdRole());
        if (optional.isPresent()) {
            responses.setMessages("Data Ditemukan");
            responses.setData(convertEntityToDtoUsr(optional.get(), optional1.get()));
        } else {
            responses.setMessages("Data Tidak Ditemukan");
        }

        return responses;
    }

    @PutMapping("/updateus")
    public RegisResponse<User> updateLog(@RequestParam("file")MultipartFile file, User user, Roles roles) throws IOException  {
        RegisResponse<User> responses = new RegisResponse<>();
        Optional<User> optional = loginUserRepository.findById(user.getIdUser());
        Optional<Roles> optional1 = rolesRepository.findById(roles.getIdRole());
        if (optional.isPresent() && optional1.isPresent()) {
            serviceAdminUser.updateProfile(file, user, roles);
            responses.setMessages("Data berhasil di update");
        } else {
            responses.setMessages("Error. Data tidak dapat di update");
        }
        return responses;
    }

    public UserDto convertEntityToDtoUs(User entity) {
        UserDto dto = new UserDto();
        dto.setIdUser(entity.getIdUser());
        dto.setAlamat(entity.getAlamat());
        dto.setNama(entity.getNama());
        dto.setNoTelp(entity.getNoTelp());
        dto.setPass(entity.getPass());

        return dto;
    }

    public UserDto convertEntityToDtoUsr(User entity, Roles en) {
        UserDto dtos = new UserDto();
        dtos.setIdUser(entity.getIdUser());
        dtos.setAlamat(entity.getAlamat());
        dtos.setNama(entity.getNama());
        dtos.setNoTelp(entity.getNoTelp());
        dtos.setPass(entity.getPass());
        dtos.setIdRole(en.getIdRole());
        dtos.setRole(en.getRole());

        return dtos;
    }
}
