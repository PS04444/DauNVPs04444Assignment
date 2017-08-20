
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
        <title><s:message code="menu.qlnv"/></title>
        <link rel="icon" href="image/logo.png" />
        <base href="${pageContext.servletContext.contextPath}/">
        <script src="js/jquery.min.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet"/>
        <script src="js/bootstrap.min.js"></script>
        <style>
            .trai{
                width: 350px;
                height: 300px;
                float: left;
            }
            .phai{
                width: 200px;
                height: 300px;
                float: left;
            }
        </style>
    </head>
    <body>
        <h1><s:message code="menu.qlnv"/></h1>
        <jsp:include page="menu.jsp"/>
        <br/><br/>
        Thông tin nhân viên:
        <select>
            <option>S001</option>
            <option>S002</option>
            <option>S003</option>
            <option>S004</option>
            <option>S005</option>
            <option>S006</option>
            <option>S007</option>
            <option>S008</option>
        </select>
        
        <form:form action="xuli.htm" modelAttribute="nhanvien" enctype="multipart/form-data">
            <div class="container">
                <div class="trai">
                <div class="form-group col-sm-12">
                    <label class="col-sm-10 control-label">ID</label>
                    <form:input path="id" />
                </div>
                
                <div class="form-group">
                    <label class="col-sm-3 control-label">Name</label>
                    <form:input path="name" />
                </div>
                
                <div class="form-group">
                    <label class="col-sm-3 control-label">Gender</label>
                    <form:select path="gender">
			<form:option value="true">Nam</form:option>
			<form:option value="false">Nữ</form:option>
                    </form:select>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">Birthday</label>
                    <form:input path="birthday" type="date" />
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">Photo</label>
                    <form:input path="photo" type="file" name="photo"/>
                </div>
                </div>
                <%--<img src="image/${photo}"/> --%>
                <div class="phai">
                <div class="form-group">
                    <label class="col-sm-3 control-label">Email</label>
                    <form:input path="email" type="email"/>
                </div>
                
                <div class="form-group">
                    <label class="col-sm-3 control-label">Phone</label>
                    <form:input path="phone" />
                </div>
                
                <div class="form-group">
                    <label class="col-sm-3 control-label">Salary</label>
                    <form:input path="salary" />
                </div>
                
                <div class="form-group">
                    <label class="col-sm-3 control-label">Notes</label>
                    <form:textarea path="notes" />
                </div>
                
                <div class="form-group">
                    <label class="col-sm-3 control-label">DepartId</label>
                    <form:input path="departid" />
                </div>
                </div>
                </br>
                <div>
                    <button class="btn btn-default" name="btnInsertNV">Thêm</button>
                    <button class="btn btn-default" name="btnUpdateNV">Cập nhật</button>
                </div>
            </div>
        </form:form>
        </br>
        </br>
        <table border="1" class="table table-bordered table-hover table-striped table-condensed">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Birthday</th>
                <th>Photo</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Salary</th>
                <th>Notes</th>
                <th>DepartId</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="nv" items="${listNhanVien}">
                <form action="deleteNV.htm">
                    <tr>
                        <td>${nv.id}</td>
                        <td>${nv.name}</td>
                        <td>${nv.gender?'Nam':'Nữ'}</td>
                        <td>${nv.birthday}</td>
                        <td><img src="image/${nv.photo}"/></td>
                        <td>${nv.email}</td>
                        <td>${nv.phone}</td>
                        <td>${nv.salary}</td>
                        <td>${nv.notes}</td>
                        <td>${nv.departid}</td>
                        <c:url var="del" value="editNV.htm">
                            <c:param name="txtId" value="${nv.id}"/>
                            <c:param name="txtName" value="${nv.name}"/>
                            <c:param name="txtGender" value="${nv.gender}"/>
                            <c:param name="txtBirthday" value="${nv.birthday}"/>
                            <c:param name="txtPhoto" value="${nv.photo}"/>
                            <c:param name="txtEmail" value="${nv.email}"/>
                            <c:param name="txtPhone" value="${nv.phone}"/>
                            <c:param name="txtSalary" value="${nv.salary}"/>
                            <c:param name="txtNotes" value="${nv.notes}"/>
                            <c:param name="txtDepartId" value="${nv.departid}"/>
                        </c:url>
                        <td><a href="${del}">Edit</a></td>
                        <td>
                            <input type="hidden" name="txtId" value="${nv.id}"/>
                            <input class="btn btn-default" type="submit" name="action" value="Delete"/>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
        
    </body>
</html>
