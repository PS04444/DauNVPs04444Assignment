

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>QUẢN LÝ TÀI KHOẢN</h1>
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
                <button name="btnInsert">Thêm</button>
                <button name="btnUpdate">Cập nhật</button>
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
                            <input type="submit" name="action" value="Delete"/>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </body>
</html>
