

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ĐĂNG NHẬP</h1>
        <jsp:include page="menu.jsp"/>
        <br/>
        <form action="dangnhap.htm" method="post">
            Username: <br/>
            <input name="username"  value="${cookie.uid.value}"/><br/>
            Password: <br/>
            <input name="password" value="${cookie.pwd.value}" type="password"/><br/>
            <input name="remember" type="checkbox" />Remember me?<br/>
            <hr/>
            <button>Đăng nhập</button>
        </form>

    </body>
</html>
