package com.servlet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tabliczka")
public class TabliczkaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("tabliczka/tabliczka_form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("rozmiar_x", req.getParameter("x"));
        req.setAttribute("rozmiar_y", req.getParameter("y"));

        req.getRequestDispatcher("tabliczka/tabliczka_view.jsp").forward(req, resp);
    }
}
