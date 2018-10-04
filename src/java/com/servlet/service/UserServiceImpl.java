package com.servlet.service;

import com.servlet.model.AppUser;

import javax.enterprise.inject.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Model
public class UserServiceImpl implements UserService {
    private List<AppUser> userList = new ArrayList<>();

    public void addUser(AppUser newUser){
        userList.add(newUser);
    }

    public List<AppUser> getUserList() {
        return userList;
    }

    @Override
    public void removeUserWithId(final int id) {
        userList.removeIf(user -> user.getId() == id);
    }

    @Override
    public Optional<AppUser> getUserWithId(int id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst();
    }
}
