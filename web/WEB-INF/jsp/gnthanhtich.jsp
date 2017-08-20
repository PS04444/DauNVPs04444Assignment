
<%
            if (session.getAttribute("USER") == null) {
                String path = request.getContextPath();
                String url = path + "/dangnhap.htm";
                response.sendRedirect(url);
            }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:message code="menu.gntt"/></title>
        <link rel="icon" href="image/logo.png" />
        <script src="js/jquery.min.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet"/>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1><s:message code="menu.gntt"/></h1>
        <jsp:include page="menu.jsp"/>
        <br/><br/><br/>
        ${message}
        <form:form action="gnthanhtich.htm" modelAttribute="record">
            <div>
                <label>Nhân viên</label>
                <form:select path="staffs.id" items="${staffs}" itemValue="id" itemLabel="name"/>
            </div>
            <div>
                <label>Loại</label>
                <form:radiobutton path="type" value="1" label="Thanh tich"/>
                <form:radiobutton path="type" value="0" label="Ky luat"/>
            </div>
            <div>
                <label>Lý do</label>
                <form:textarea path="reason" rows="3"/>
            </div>
            <div>
                <button>Insert</button>
            </div>
        </form:form>
    </body>
</html>
