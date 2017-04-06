package com.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wxk on 2017/4/6.
 */
@WebServlet(name = "LogOutServlet", urlPatterns = "/LogOutServlet")
public class LogOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //test
        System.out.println("servlet log out.");
        session.removeAttribute("username");

        //test
        System.out.println("log out removed session.");
        PrintWriter pw = response.getWriter();
        pw.printf("{\"status\":0}");
        response.setContentType("text/json");
    }
}
