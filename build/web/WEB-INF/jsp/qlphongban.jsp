
<%
            if (session.getAttribute("USER") == null) {
                String path = request.getContextPath();
                String url = path + "/dangnhap.htm";
                response.sendRedirect(url);
            }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:message code="menu.qlpb"/></title>
        <link rel="icon" href="image/logo.png" />
        <script src="js/jquery.min.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet"/>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1><s:message code="menu.qlpb"/></h1>
        <jsp:include page="menu.jsp"/><br/><br/>

        <form:form action="pb.htm" modelAttribute="phongban">
            <div>Mã phòng ban</div>
            <form:input path="mapb"/>

            <div>Tên phòng ban</div>
            <form:input path="tenpb"/>
            <br/><br/>
            
            <div>
                <button name="btnInsertPB">Thêm</button>
                <button name="btnUpdatePB">Cập nhật</button>
            </div>

        </form:form>
        <br/>
        <table border="1" >
            <tr>
                <td>Mã phòng ban</td>
                <td>Tên phòng ban</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
            <c:forEach var="pb" items="${listPhongBan}">
                <form action="deletePB.htm">
                    <tr>
                        <td>${pb.mapb}</td>
                        <td>${pb.tenpb}</td>
                        <c:url var="edit" value="editPB.htm">
                            <c:param name="txtMapb" value="${pb.mapb}"/>
                            <c:param name="txtTenpb" value="${pb.tenpb}"/>
                        </c:url>
                        <td><a href="${edit}">Edit</a></td>
                        <td>
                            <input type="hidden" name="txtMapb" value="${pb.mapb}"/>
                            <input type="submit" name="action" value="Delete"/> 
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>

    </body>
</html>
