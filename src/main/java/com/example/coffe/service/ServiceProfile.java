package com.example.coffe.service;

import com.example.coffe.model.entity.Admin;
import com.example.coffe.model.entity.User;

public interface ServiceProfile {

    void updateProfileUser(Integer idUser, User user);

    void updateProfileAdmin(Integer idAmin, Admin admin);
}