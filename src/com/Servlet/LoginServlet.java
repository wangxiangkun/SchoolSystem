package com.Servlet;

import com.Dao.UserDAOProxy;
import com.User.User;
import jdk.nashorn.internal.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wxk on 2017/3/30.
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
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
        UserDAOProxy userDAOProxy = new UserDAOProxy();
        int status = -1;

        try {
            if (userDAOProxy.findLogin(user)) {
                status = 0;
            } else {
                status = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        PrintWriter pw = response.getWriter();
        pw.printf("{\"status\":%d}", status);
        response.setContentType("text/json");
    }
}
