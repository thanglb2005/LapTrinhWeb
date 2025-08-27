<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Đăng ký</title></head>
<body>
<h2>Đăng ký tài khoản</h2>
<% String alert = (String) request.getAttribute("alert");
   if (alert != null) { %>
    <p style="color:red"><%= alert %></p>
<% } %>
<form action="register" method="post">
    Username: <input type="text" name="username"><br><br>
    Password: <input type="password" name="password"><br><br>
    Email: <input type="text" name="email"><br><br>
    Fullname: <input type="text" name="fullname"><br><br>
    Phone: <input type="text" name="phone"><br><br>
    <button type="submit">Đăng ký</button>
</form>
</body>
</html>

