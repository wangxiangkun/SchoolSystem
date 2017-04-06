<%--
  Created by IntelliJ IDEA.
  User: wxk
  Date: 2017/3/31
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>学生中心</title>
</head>
<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#logout_button").click(function () {
            alert("1");
            $.ajax({
                url: "/LogOutServlet",
                type: "POST",
                data: "0",
                success: function (data) {
                    alert("2");
                    var msg = data.status;
                    if (0 == msg) {
                        window.location.href = "SignIn.jsp";
                    } else {
                        alert("登出异常!");
                    }
                },
                error: function (data) {
                    alert("登出异常!");
                }
            })
        })
    })
</script>

<body>
    <div style="text-align:left">
        Welcome, student user.<br>
        <form id="logout" action="" method="post" onsubmit="">
            <input class="btn" value="退出" id="logout_button" type="button"/>
        </form>
    </div>
</body>
</html>
