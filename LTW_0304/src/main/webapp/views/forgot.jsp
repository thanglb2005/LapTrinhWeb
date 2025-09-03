<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
</head>
<body>
    <h2>Quên mật khẩu</h2>
    <form action="${pageContext.request.contextPath}/forgot" method="post">
        <label>Email:</label>
        <input type="email" name="email" required /><br/><br/>

        <label>Mật khẩu mới:</label>
        <input type="password" name="newPassword" required /><br/><br/>

        <button type="submit">Đổi mật khẩu</button>
    </form>

    <!-- Hiển thị thông báo -->
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>

    <c:if test="${not empty message}">
        <p style="color:green">${message}</p>
    </c:if>
</body>
</html>
