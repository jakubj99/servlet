package com.servlet.controller;


import com.servlet.model.AppUser;
import com.servlet.service.DependencyManager;
import com.servlet.service.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/add")
public class UserAddController extends HttpServlet {

    private UserService userService;
    private int licznik_id = 0;

    public UserAddController(){
    userService = DependencyManager.getInstance().getBean(UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/user/user_form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password_confirm = req.getParameter("password-confirm");

        if (username.isEmpty() || password.isEmpty() || !password.equals(password_confirm)) {
            req.setAttribute("error_message", "Incorrect username or password!");

            req.getRequestDispatcher("/user/user_form.jsp").forward(req, resp);
            return;
        }

        AppUser newUser = new AppUser(licznik_id++, username, password);
        userService.addUser(newUser);

        resp.sendRedirect("/user/list");


    }
}
