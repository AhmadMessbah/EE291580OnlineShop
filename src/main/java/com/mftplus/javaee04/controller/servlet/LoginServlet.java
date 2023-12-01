package com.mftplus.javaee04.controller.servlet;

import com.mftplus.javaee04.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username;
//        String password;
//        Cookie[] cookies = req.getCookies();
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("username")) {
//                username = cookie.getValue();
//            }
//            if (cookie.getName().equals("password")) {
//                password = cookie.getValue();
//            }
//        }
//        if (login(username, password)) {
//            req.getRequestDispatcher("/jsp/panel.jsp").forward(req, resp);
//        } else {
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        if (remember != null && remember.equals("on")) {
            Cookie uCookie = new Cookie("username", username);
            Cookie pCookie = new Cookie("password", password);
            resp.addCookie(uCookie);
            resp.addCookie(pCookie);
        }

        try {
            if (UserService.getService().findByUsernameAndPassword(username, password) != null) {
                req.getSession().setAttribute("username", username);
                req.getSession().removeAttribute("error");
                resp.sendRedirect("/panel.do");
            }
        } catch (Exception e) {
            req.getSession().setAttribute("error", e.getMessage());
            resp.sendRedirect("/login.do");
        }
    }
}
