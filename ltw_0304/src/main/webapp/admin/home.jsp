<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Trang chủ</title></head>
<body>
<h2>Xin chào, <%= ((vn.iotstar.config.model.User)session.getAttribute("account")).getUserName() %></h2>
<p>Đăng nhập thành công.</p>

<a href="<%=request.getContextPath()%>/logout">Đăng xuất</a>

</body>
</html>
