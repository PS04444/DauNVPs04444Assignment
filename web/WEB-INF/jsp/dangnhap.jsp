

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
        <link rel="icon" href="image/logo.png" />
        <script src="js/jquery.min.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet"/>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>ĐĂNG NHẬP</h1>
        <jsp:include page="menu.jsp"/>
        <br/>
        <form action="dangnhap.htm" method="post">
            Username: <br/>
            <input class="form-control" name="username" value="${cookie.uid.value}"/><br/>
            Password: <br/>
            <input class="form-control" name="password" value="${cookie.pwd.value}" type="password"/><br/>
            <div>
                <label>
                    <input name="remember" type="checkbox"/>Remember me?
                </label>
            </div>
            <hr/>
            <button class="btn btn-default">Đăng nhập</button>
        </form>

    </body>
</html>