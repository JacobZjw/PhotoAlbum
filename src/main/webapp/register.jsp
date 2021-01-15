<%--
  Created by IntelliJ IDEA.
  User: Jv____
  Date: 2021/1/11
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <style>
        form span {
            display: inline-block;
            width: 80px;
            text-align: right
        }

        #main {
            margin: 100px auto;
            border: 1px solid #ccc;
            width: 350px;
            padding: 0 30px 30px 30px
        }

        form a {
            font-size: 14px;
            float: right;
            margin-right: 50px;
        }

        body {
            background: url("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=36553012,2067849952&fm=26&gp=0.jpg")
        }
    </style>
</head>
<body>
<div id="main">
    <form action="RegisterServlet" method="post">
        <div class="auth-main" align="center">
            <h2>注册新用户</h2>
            <hr color="#ccc">
            <br>
            <div class="auth-info">
                <span>用户名</span><input type="text" name="UserName"><br><br>
                <span>邮箱</span><input type="text" name="Email"><br><br>
                <span>密码</span><input type="password" name="Password"><br><br>
            </div>

            <div class="auth-btn">
                <button id="register" type="submit" class="register-btn">
                    注册
                </button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
