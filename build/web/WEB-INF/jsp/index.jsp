<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:message code="menu.tc"/></title>
        <link rel="icon" href="image/logo.png" />
        
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="js/jquery.min.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet"/>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <h1><s:message code="menu.tc"/></h1>
        <jsp:include page="menu.jsp" />
        <br/><br/>
        <h1 class="alert alert-success">Danh sach nhan vien</h1>
        <%-- --%>
        <table border="1" class="table table-bordered table-hover table-striped table-condensed">
            <div class="form-group">
                <tr>
                <th>Mã NV</th>
                <th>Họ và tên</th>
                <th>Giới tính</th>
                <th>Phòng</th>
            </tr>
            <c:forEach var="s" items="${staffs}">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.gender?'Nam':'Nữ'}</td>
                <td>${s.departs.name}</td>
            </tr>
            </c:forEach>
        </div>
        </table>
        
        <%-- 
        <table border="1">
        <tr>
            <th>M</th>
            <th>H</th>
            <th>G</th>
            <th>P</th>
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
        --%>
    </body>
</html>
