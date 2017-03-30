<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: wxk
  Date: 2017/3/30
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <center><h2>用户登录程序</h2></center>
    <center>
        <%
            request.setCharacterEncoding("GBK");
        %>
        <%
            List<String> info=(List<String>)request.getAttribute("info");
            if(info!=null){
                Iterator<String> iter=info.iterator();
                while(iter.hasNext()){
        %>
        <h4><%=iter.next()%></h4>
        <%
                }
            }
        %>
    </center>
    <center>
        <form action="LoginServlet" method="post" onSubmit="return validate(this)">
            用户名:<input type="text" name="name"><br>
            密  码:<input type="text" name="password"><br>
            <input type="submit" value="登录">
            <input type="reset" value="重置">
        </form>
    </center>
</body>
</html>
