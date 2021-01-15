<%@ page import="beans.Photo" %>
<%@ page import="beans.User" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.BaseDao" %><%--
  Created by IntelliJ IDEA.
  User: Jv____
  Date: 2021/1/13
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片墙</title>
</head>
<style>
    img {
        height: 150px
    }

    img {
        transition: all 100ms ease;
    }

    img:hover {
        transform: scale(2, 2);
        transition: all 200ms ease;
        border-radius: 10px 10px;
        box-shadow: 40px 40px 40px #aaa;
    }

    body {
        background: url("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=36553012,2067849952&fm=26&gp=0.jpg")
    }
</style>
<body>
<%
    List<Photo> list = (List<Photo>) request.getAttribute("PhotoWallList");
    Long userId;
    User user = (User) session.getAttribute("User");
    if (user == null) {
        response.sendRedirect("login.jsp");
        userId = Long.valueOf(request.getParameter("userId"));
    } else {
        userId = user.getId();
    }
%>
<div align="center">
    <h1>图片墙</h1>
    <a href="editPhoto.jsp?id=<%=0L%>&master=<%=userId%>">上传</a>
    <a href="ShowPhotoServlet?userId=<%=userId%>">编辑相册</a>
    <a href="LoginServlet">注销登录</a>
    <a>当前用户：<%=user.getName()%>
    </a>
    <hr/>
</div>
<%
    for (Photo photo : list) {
%>
<a href="AddPhotoCollectionServlet?photoId=<%=photo.getId()%>&flag=00"><img
        src="<%=photo.getUrl()%>"></a>
<%
    }
%>


</body>
</html>
