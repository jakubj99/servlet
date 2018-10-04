package com.servlet.controller;

import com.servlet.model.AppUser;
import com.servlet.service.DependencyManager;
import com.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/user/modify")
public class UserModifyController extends HttpServlet {

    private UserService userService;

    public UserModifyController() {
        userService = DependencyManager.getInstance().getBean(UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("id"));


        Optional<AppUser> user = userService.getUserWithId(userId);
        if (user.isPresent()) {
            req.setAttribute("user_to_modify", user.get());
            req.getRequestDispatcher("/user/user_form.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/user/list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password_confirm = req.getParameter("password-confirm");

        if (username.isEmpty() || password.isEmpty() || !password.equals(password_confirm)) {
            req.setAttribute("error_message", "Incorrect username or password!");

            req.getRequestDispatcher("/user/user_form.jsp").forward(req, resp);
            return;
        }

        int identifier = Integer.parseInt(id);
        Optional<AppUser> user = userService.getUserWithId(identifier);
        if (user.isPresent()){
            AppUser userToModify = user.get();

            userToModify.setLogin(username);
            userToModify.setPassword(password);
        }

        resp.sendRedirect("/user/list");
    }
}