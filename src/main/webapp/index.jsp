<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
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
            font-size: 12px;
            float: right;
            margin-right: 50px;
        }
    </style>
</head>
<body>

<h1 align="center"><%= "Hello World!"%>
</h1>
<br/>
<div align="center" id="main">
    <a href="login.jsp">去登陆</a>
</div>
<%
    response.sendRedirect("login.jsp");
%>


</body>
</html>