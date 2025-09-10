<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Thông tin cá nhân</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
    <h2>Cập nhật thông tin cá nhân</h2>

    <!-- ✅ Thông báo cập nhật thành công -->
    <c:if test="${param.success == '1'}">
        <div class="alert alert-success">Cập nhật thành công!</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/profile/update" method="post" enctype="multipart/form-data" class="mt-3">

        <div class="mb-3">
            <label class="form-label">Họ tên</label>
            <input type="text" class="form-control" name="fullName" value="${account.fullName}">
        </div>

        <div class="mb-3">
            <label class="form-label">Số điện thoại</label>
            <input type="text" class="form-control" name="phone" value="${account.phone}">
        </div>

        <div class="mb-3">
            <label class="form-label">Ảnh đại diện</label>
            <input type="file" class="form-control" name="avatar">
        </div>

        <c:if test="${not empty account.avatar}">
            <div class="mb-3">
                <img src="${pageContext.request.contextPath}/uploads/${account.avatar}" 
                     width="120" class="img-thumbnail">
            </div>
        </c:if>

        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>
</body>
</html>
