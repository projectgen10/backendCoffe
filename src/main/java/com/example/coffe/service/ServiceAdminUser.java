package com.example.coffe.service;

import com.example.coffe.model.entity.Admin;
import com.example.coffe.model.entity.User;
import com.example.coffe.repository.LoginAdminRepository;
import com.example.coffe.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAdminUser implements ServiceProfile{

    @Autowired
    LoginUserRepository loginUserRepository;

    @Autowired
    LoginAdminRepository loginAdminRepository;

    @Override
    public void updateProfileUser(User user) {
        User user1 = loginUserRepository.findById(user.getIdUser()).get();
        user1.setPass(user.getPass());
        user1.setNama(user.getNama());
        user1.setAlamat(user.getAlamat());
        user1.setNoTelp(user.getNoTelp());
        loginUserRepository.save(user1);
    }

    @Override
    public void updateProfileAdmin(Admin admin) {
        Admin admin1 = loginAdminRepository.findById(admin.getIdAdmin()).get();
        admin1.setPass(admin.getPass());
        admin1.setNoTelp(admin.getNoTelp());
        admin1.setNama(admin.getNama());
        admin1.setAlamat(admin.getAlamat());
        loginAdminRepository.save(admin1);
    }
}
