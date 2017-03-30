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
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        List<String> info=new ArrayList<String>();

        //检查用户名输入格式
        if(name==null||"".equals(name)){
            info.add("用户名不能为空");
            System.out.println("用户名不能为空");
        }

        //检查密码输入格式
        if(password==null||"".equals(password)){
            info.add("密码不能为空");
            System.out.println("密码不能为空");
        }
        if(info.size()==0){
            User user=new User();
            user.setUsername(name);
            user.setPassword(password);
            UserDAOProxy userDAOProxy=new UserDAOProxy();
            try {

                if(userDAOProxy.findLogin(user)){
                    info.add("用户登录成功，欢迎"+user.getUsername()+"光临！");
                }else {
                    info.add("用户登录失败，错误的用户名和密码");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("info", info);//保存错误信息
        //请求转发
        request.getRequestDispatcher("Login.jsp").forward(request,response);
    }
}
