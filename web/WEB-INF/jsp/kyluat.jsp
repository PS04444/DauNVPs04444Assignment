

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:message code="menu.kl"/></title>
        <link rel="icon" href="image/logo.png" />
        <script src="js/jquery.min.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet"/>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1><s:message code="menu.kl"/></h1>
        <jsp:include page="menu.jsp"/>
        <br/><br/>
        <%-- --%>
        <table border="1">
        <tr>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>Type</th>
        </tr>
        <c:forEach var="r" items="${records}">
        <tr>
            <td>${r.staffs.name}</td>
            <td>${r.staffs.birthday}</td>
            <td>${r.staffs.gender?'Nam':'Nữ'}</td>
            <td>${r.type}</td>
        </tr>
        </c:forEach>
        </table>
    </body>
</html>
