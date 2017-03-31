package com.Servlet;

import com.Dao.UserDAOProxy;
import com.User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
//        List<String> info = new ArrayList<String>();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setUsertype(usertype);
        UserDAOProxy userDAOProxy = new UserDAOProxy();

        try {
            if (userDAOProxy.findLogin(user)) {
                //info.add("用户登录成功，欢迎"+user.getUsername()+"光临！");
                //request.getRequestDispatcher("StudentIndex.jsp").forward(request, response);
                response.sendRedirect("/StudentIndex.jsp");
            } else {
                //保存反馈信息
//                request.setAttribute("info", info);
//                info.add("用户登录失败，错误的用户名或密码");
                //请求转发
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
