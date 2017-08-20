
<%
            if (session.getAttribute("USER") == null) {
                String path = request.getContextPath();
                String url = path + "/dangnhap.htm";
                response.sendRedirect(url);
            }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:message code="menu.qltk"/></title>
        <link rel="icon" href="image/logo.png" />
        <script src="js/jquery.min.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet"/>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1><s:message code="menu.qltk"/></h1>
        <jsp:include page="menu.jsp"/>
        <br/><br/>

        Thay đổi thông tin tài khoản<br/>
        <form:form action="vl.htm" modelAttribute="user">
            <div>Username:</div>
            <form:input path="username" />
            <div>Password</div>
            <form:input path="password"/>
            <div>Fullname:</div>
            <form:input path="fullname"/>
            <br/><br/>
            <div>
                <button class="btn btn-default" name="btnInsert">Thêm</button>
                <button class="btn btn-default" name="btnUpdate">Cập nhật</button>
            </div>
        </form:form>
        <hr/>
        <table border="1">
            <tr>
                <th>Username</th>
                <th>Password</th>
                <th>Fullname</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="users" items="${listUsers}">
                <form action="delete.htm" >
                    <tr>
                        <td>${users.username}</td>
                        <td>${users.password}</td>
                        <td>${users.fullname}</td>
                        <c:url var="del" value="edit.htm">
                            <c:param name="txtUser" value="${users.username}"/>
                            <c:param name="txtPass" value="${users.password}"/>
                            <c:param name="txtFull" value="${users.fullname}"/>
                        </c:url>
                        <td><a href="${del}">Edit</a></td>
                        <td>
                            <input type="hidden" name="txtUser" value="${users.username}"/>
                            <input class="btn btn-default" type="submit" name="action" value="Delete"/>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </body>
</html>
