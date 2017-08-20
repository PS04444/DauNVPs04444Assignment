

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<a href="index.htm"><s:message code="menu.tc"/></a>|
<a href="qltaikhoan.htm"><s:message code="menu.qltk"/></a>|
<a href="qlnhanvien.htm"><s:message code="menu.qlnv"/></a>|
<a href="qlphongban.htm"><s:message code="menu.qlpb"/></a>|
<a href="gnthanhtich.htm"><s:message code="menu.gntt"/></a>|
<a href="ththanhtich.htm"><s:message code="menu.thtt"/></a>|
<a href="kyluat.htm"><s:message code="menu.kl"/></a>|
<a href="dangnhap.htm">
    <%
        if (session.getAttribute("USER") != null) {
            out.print("Đăng xuất");
        } else {
            out.print("Đăng nhập");
        }
    %>
</a>|
${USER}
<a href="index.htm?language=en" data-lang="en">English</a> |
<a href="index.htm?language=vi" data-lang="vi">Tiếng Việt</a>
<script>
$(function(){
	$("a[data-lang]").click(function(){
		var lang = $(this).attr("data-lang");
		$.get("index.htm?language="+ lang, function(){
			location.reload();
		});
		return false;
	});
});
</script>
