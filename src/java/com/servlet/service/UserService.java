package com.servlet.service;


import com.servlet.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public void addUser(AppUser newUser);
    public List<AppUser> getUserList();

    public void removeUserWithId(int id);

    public Optional<AppUser> getUserWithId(int id);

}
