<%--
  Created by IntelliJ IDEA.
  User: wxk
  Date: 2017/4/6
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师中心</title>
</head>
<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="/js/Cookies.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#add_button").click(function () {
            var flag = Check();
            if (true == flag) {
                $.ajax({
                    url: "/SignUpServlet",
                    type: "POST",
                    data: $("#form").serialize(),
                    success: function (data) {

                    },
                    error: function (data) {

                    }
                })
            }
        })
    })

    function Check() {
      var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var studenttype = document.getElementById("studenttype");
        var teachertype = document.getElementById("teachertype");

        if (null == username || "" == username) {
            alert("请输入用户名");
            return false;
        }

        if (null == password || "" == password) {
            alert("请输入密码");
            return false;
        }

        if ((!studenttype.checked) && (!teachertype.checked)) {
            alert("请选择用户类型");
            return false;
        }
        return true;
    }

    function Reset() {
        document.getElementById("username").value = null;
        document.getElementById("password").value = null;
        document.getElementById("studenttype").checked = false;
        document.getElementById("teachertype").checked = false;
    }
</script>
<body>
    <div style="text-align: center">
        <h2>学生信息管理</h2>
        <form id="form" action="" method="post" onsubmit="">
            用户名:<input type="text" id="username" name="username"/><br>
            密  码:<input type="text" id="password" name="password"/><br>
            学生: <input type="radio" id="studenttype" name="usertype" value="student"/><br>
            教师: <input type="radio" id="teachertype" name="usertype" value="teacher"/><br>
            <input class="btn" value="添加" id="add_button" type="button"/>
            <%--<input type="submit" value="登录">--%>
            <input class="btn" value="重置" id="reset_button" type="button" onclick="Reset()"/>
        </form>
    </div>
</body>
</html>
