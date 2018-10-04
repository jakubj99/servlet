package com.servlet.controller;

import com.servlet.service.DependencyManager;
import com.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/remove")
public class UserRemoveController extends HttpServlet {

    private UserService userService;

    public UserRemoveController(){
        userService = DependencyManager.getInstance().getBean(UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null){
            int id = Integer.parseInt(req.getParameter("id"));
            userService.removeUserWithId(id);
        }
        resp.sendRedirect("/user/list");
    }
}
