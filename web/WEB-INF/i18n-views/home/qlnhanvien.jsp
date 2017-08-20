

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="${pageContext.servletContext.contextPath}/">
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
        <h1>QUẢN LÝ NHÂN VIÊN</h1>
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
        
        <form:form action="xuli.htm" modelAttribute="nhanvien" method="post" enctype="multipart/form-data">
            <div class="trai">
                <div>ID</div>
                <form:input path="id" />

                <div>Name</div>
                <form:input path="name" />

                <div>Gender</div>
                <form:select path="gender">
			<form:option value="true">Nam</form:option>
			<form:option value="false">Nữ</form:option>
		</form:select>

                <div>Birthday</div>
                <form:input path="birthday" type="date" />

                <div>Photo</div>
                <form:input path="photo" type="file" name="photo"/>
                
            </div>
            
            <div class="phai">
                <div>Email</div>
                <form:input path="email" type="email"/>

                <div>Phone</div>
                <form:input path="phone" />

                <div>Salary</div>
                <form:input path="salary" />

                <div>Notes</div>
                <form:input path="notes" />

                <div>DepartId</div>
                <form:input path="departid" />

                <br/><br/>
                <div>
                    <button name="btnInsertNV">Thêm</button>
                    <button name="btnUpdateNV">Cập nhật</button>
                </div>
            </div>
        </form:form>
        <br/>
        <table border="1">
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
                        <td>${nv.gender}</td>
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
                            <input type="submit" name="action" value="Delete"/>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
        
    </body>
</html>
