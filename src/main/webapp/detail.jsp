<%@ page import="beans.Photo" %>
<%@ page import="dao.BaseDao" %>
<%@ page import="beans.User" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.Comment" %><%--
  Created by IntelliJ IDEA.
  User: Jv____
  Date: 2021/1/13
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    User user = (User) session.getAttribute("User");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }
    Photo photo = (Photo) request.getAttribute("LargePhoto");
    List<Comment> comments = (List<Comment>) request.getAttribute("Comments");
%>
<body style="background-color: darksalmon">
<div style="margin: 0 auto;width: 600px;">
    <h3 align="center"><a href="javascript:history.go(-1);" style="float: left">返回</a><%=photo.getName()%><a
            href="AddPhotoCollectionServlet?photoId=<%=photo.getId()%>&flag=01"
            style="float: right">收藏</a></h3>
    <img src="<%=photo.getUrl()%>" style="width: 100%;"><br><br>
    <h3>评论区</h3>
    <hr color="#ccc">
    <br>
    <%
        for (Comment comment : comments) {
    %>
    <li><span style="color: blueviolet"><%=comment.getUserName()%></span><%=" 说 :  " + comment.getContent()%>
    </li>
    <%}%>
    <br><br>
    <form action="AddCommentsServlet" method="post">
        <input type="hidden" name="photoId" value="<%=photo.getId()%>">
        <textarea name="content" cols="80" rows="3"></textarea><br><br>
        <input type="submit" value="我要发表" style="float: right">
    </form>
    <br><br>
</div>


</body>
</html>
