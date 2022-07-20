package com.example.coffe.service;

import com.example.coffe.model.entity.Menu;

public interface ServiceMenu {
    Menu getMenuByidMenu(Integer idMenu);
    void updateMenu(Integer idMenu, Menu menu);
    void deleteMenu(Integer idMenu);
}
