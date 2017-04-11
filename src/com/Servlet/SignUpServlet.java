package com.Servlet;

import com.Dao.UserDAOProxy;
import com.User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wxk on 2017/4/11.
 */
@WebServlet(name = "SignUpServlet", urlPatterns = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String usertype = request.getParameter("usertype");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setUsertype(usertype);
        if ("student" == user.getUsertype()) {
            user.setUserpri(2);
        } else {
            user.setUserpri(3);
        }

        UserDAOProxy userDAOProxy = new UserDAOProxy();
        try {
            userDAOProxy.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
