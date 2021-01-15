<%@ page import="beans.Photo" %>
<%@ page import="beans.User" %><%--
  Created by IntelliJ IDEA.
  User: Jv____
  Date: 2021/1/12
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑</title>
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
            font-size: 16px;
            float: right;
            margin-right: 50px;
        }


        body {
            background: url("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=36553012,2067849952&fm=26&gp=0.jpg")
        }
    </style>
</head>
<body>
<%
    User user = (User) session.getAttribute("User");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }

    Long id = 0L;
    String name = null;
    String url = null;
    try {
        id = Long.valueOf(request.getParameter("id"));
        name = request.getParameter("name");
        url = request.getParameter("url");
    } catch (Exception ignored) {
    }
    name = name == null ? "" : name;
    url = url == null ? "" : url;

%>
<div id="main">

    <div align="center">
        <h1>编辑图片</h1>
    </div>

    <form action="EditPhotoServlet" align="center" method="post">
        <input type="hidden" name="PhotoId" value="<%=id%>"/><br>
        <span>图片标题：</span><input type="text" name="PhotoName" style=" width:240px;" value="<%=name%>"/><br><br>
        <span>URL：</span><input type="text" id="imgUrl" name="PhotoUrl" style=" width:240px;" value="<%=url%>"/><br><br>
        <input type="submit" value="提交"><a href="javascript:history.go(-1);">返回</a>
    </form>

</div>

</body>
</html>
