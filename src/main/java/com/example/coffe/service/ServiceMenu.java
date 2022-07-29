package com.example.coffe.service;

import com.example.coffe.model.entity.Menu;

public interface ServiceMenu {
    Menu getMenuByidMenu(String idMenu);
    void updateMenu(String idMenu, Menu menu);
    void deleteMenu(String idMenu);
}
