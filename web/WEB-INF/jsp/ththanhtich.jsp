

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:message code="menu.thtt"/></title>
        <link rel="icon" href="image/logo.png" />
        <script src="js/jquery.min.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet"/>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1><s:message code="menu.thtt"/></h1>
        <jsp:include page="menu.jsp"/>
        <br/><br/><br/>
        <table class="table table-hover" border="1">
            <tr>
                <th>Mã NV</th>
                <th>Tổng thành tích</th>
                <th>Tổng kỷ luật</th>
                <th>Tổng kết</th>
            </tr>
            <c:forEach var="a" items="${arrays}">
                <tr>
                    <td>${a[0]}</td>
                    <td>${a[1] }</td>
                    <td>${a[2]}</td>
                    <td>${a[1] - a[2]}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
