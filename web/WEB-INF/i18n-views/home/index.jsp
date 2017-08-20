<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <h1>TRANG CHỦ</h1>
        <a href="index.htm">Trang chủ</a>|
        <a href="qltaikhoan.htm">Quản lý tài khoản</a>|
        <a href="qlnhanvien.htm">Quản lý nhân viên</a>|
        <a href="qlphongban.htm">Quản lý phòng ban</a>|
        <a href="gnthanhtich.htm">Ghi nhận thành tích</a>|
        <a href="ththanhtich.htm">Tổng hợp thành tích</a>|
        <a href="kyluat.htm">Kỷ luật</a>|
        <a href="dangnhap.htm">
            <%
                if (session.getAttribute("USER") != null) {
                    out.print("Đăng xuất");
                } else {
                    out.print("Đăng nhập");
                }
            %>
        </a>
        ${USER}
    </body>
</html>
