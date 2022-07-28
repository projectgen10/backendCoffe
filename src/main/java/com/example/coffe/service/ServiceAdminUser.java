package com.example.coffe.service;

import com.example.coffe.model.entity.User;
import com.example.coffe.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ServiceAdminUser implements ServiceProfile{

    @Autowired
    LoginUserRepository loginUserRepository;

    @Override
    public void updateProfileUser(User user) {
        User user1 = loginUserRepository.findById(user.getIdUser()).get();
        user1.setPass(user.getPass());
        user1.setNama(user.getNama());
        user1.setAlamat(user.getAlamat());
        user1.setNoTelp(user.getNoTelp());
        loginUserRepository.save(user1);
    }
}
