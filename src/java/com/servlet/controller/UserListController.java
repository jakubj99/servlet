package com.servlet.controller;

import com.servlet.service.DependencyManager;
import com.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/list")
public class UserListController extends HttpServlet {

    private UserService userService;

    public UserListController(){
        userService = DependencyManager.getInstance().getBean(UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("userList", userService.getUserList());

        req.getRequestDispatcher("/user/user_list.jsp").forward(req, resp);
    }
}
