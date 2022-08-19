package com.example.coffe.service;

import com.example.coffe.model.entity.Roles;
import com.example.coffe.model.entity.User;
import com.example.coffe.repository.LoginUserRepository;
import com.example.coffe.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@Transactional
public class ServiceAdminUser{

    @Autowired
    LoginUserRepository loginUserRepository;

    @Autowired
    RolesRepository rolesRepository;

    public User updateProfile(MultipartFile file,User user, Roles roles) throws IOException {
        User user1 = loginUserRepository.findById(user.getIdUser()).get();
        Roles roles1 = rolesRepository.findById(roles.getIdRole()).get();
        roles1.setRole(roles.getRole());
        user1.setPass(user.getPass());
        user1.setNama(user.getNama());
        user1.setAlamat(user.getAlamat());
        user1.setNoTelp(user.getNoTelp());
        user1.setData(file.getBytes());
        user1.setNamaFile(file.getOriginalFilename());
        user1.setType(file.getContentType());
        rolesRepository.save(roles);
        return loginUserRepository.save(user1);
    }

    public User register(MultipartFile file, User user, Roles roles) throws IOException{
        String namaFile = StringUtils.cleanPath(file.getOriginalFilename());
        User user1 = new User(namaFile, file.getContentType(), file.getBytes());
        Roles roles1 = new Roles();
        roles1.setRole(roles.getRole());
        user1.setPass(user.getPass());
        user1.setNama(user.getNama());
        user1.setAlamat(user.getAlamat());
        user1.setNoTelp(user.getNoTelp());
        rolesRepository.save(roles);
        return loginUserRepository.save(user1);
    }

}
