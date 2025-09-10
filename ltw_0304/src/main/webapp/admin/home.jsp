<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Admin Dashboard</title>
  <meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
  <h1 class="mb-4">Admin Dashboard</h1>

  <div class="row g-4">
    <div class="col-md-4">
      <div class="card text-bg-primary shadow-sm">
        <div class="card-body">
          <h5 class="card-title">Quản lý danh mục</h5>
          <p class="card-text">Xem, thêm, sửa, xóa danh mục sản phẩm.</p>
          <a href="${pageContext.request.contextPath}/admin/list-category.jsp" class="btn btn-light">Đi tới</a>
        </div>
      </div>
    </div>

    <div class="col-md-4">
      <div class="card text-bg-success shadow-sm">
        <div class="card-body">
          <h5 class="card-title">Thông tin của người dùng</h5>
          <p class="card-text">Kiểm soát thông tin người dùng trong hệ thống.</p>
			<a href="${pageContext.request.contextPath}/profile" class="btn btn-light">Đi tới</a>
        </div>
      </div>
    </div>

    <div class="col-md-4">
      <div class="card text-bg-warning shadow-sm">
        <div class="card-body">
          <h5 class="card-title">Báo cáo</h5>
          <p class="card-text">Xem báo cáo thống kê hoạt động.</p>
          <a href="#" class="btn btn-light">Đi tới</a>
        </div>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
