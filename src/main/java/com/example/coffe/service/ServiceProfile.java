package com.example.coffe.service;

import com.example.coffe.model.entity.Admin;
import com.example.coffe.model.entity.User;

public interface ServiceProfile {

    void updateProfileUser(User user);
    void updateProfileAdmin(Admin admin);
}
