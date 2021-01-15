<%--
  Created by IntelliJ IDEA.
  User: Jv____
  Date: 2021/1/12
  Time: 2:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="beans.Photo" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>相册</title>
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
</head>
<body>
<%
    List<Photo> list = (List<Photo>) request.getAttribute("PhotoList");
    List<Photo> favList = (List<Photo>) request.getAttribute("FavList");
    int count = 0;
    User user = (User) session.getAttribute("User");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>
<div align="center">
    <h1>图片列表</h1>
    <a href="PhotoWallServlet">返回</a>
    <a href="LoginServlet">注销登录</a>
    <a>当前用户：<%=user.getName()%>
    </a>
    <hr color="#ccc">
    <h1>你上传的图片</h1>

</div>
<table border="1px" width="60%" align="center">
    <tr>
        <th>编号</th>
        <th>相片</th>
        <th>标题</th>
        <th>操作<a href="editPhoto.jsp">上传</a></th>
    </tr>

    <%
        for (Photo photo : list) {
            ++count;
    %>
    <tr>
        <td width="100px"><%=count%>
        </td>
<%--        <td><img src="<%=photo.getUrl()%>"></td>--%>
        <td><a href="AddPhotoCollectionServlet?photoId=<%=photo.getId()%>&flag=00"><img
                src="<%=photo.getUrl()%>"></a></td>
        <td><%=photo.getName()%>
        </td>
        <td width="200px">
            <a href="editPhoto.jsp?id=<%=photo.getId()%>&name=<%=photo.getName()%>&url=<%=photo.getUrl()%>">修改</a>
            <a href="EditPhotoServlet?PhotoId=<%=photo.getId()%>"
               onclick="return confirm('你确定要删除吗?');">删除</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
<br><br>
<hr color="#ccc">
<div align="center">
    <h1>你收藏的图片</h1>
</div>
<table border="1px" width="60%" align="center">
    <tr>
        <th>编号</th>
        <th>相片</th>
        <th>标题</th>
        <th>操作</th>
    </tr>

    <%
        count = 0;
        for (Photo photo : favList) {
            ++count;
    %>
    <tr>
        <td width="100px"><%=count%>
        </td>
        <td><img src="<%=photo.getUrl()%>"></td>
        <td><%=photo.getName()%>
        </td>
        <td width="200px">
            <a href="AddPhotoCollectionServlet?photoId=<%=photo.getId()%>&userId=<%=user.getId()%>&flag=11"
               onclick="return confirm('你确定要取消收藏吗?');">取消收藏</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
