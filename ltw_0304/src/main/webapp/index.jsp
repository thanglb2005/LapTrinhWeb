<%@ page contentType="text/html;charset=UTF-8" %

<!DOCTYPE html>
<html>
<head>
  <title>Home</title>
</head>
<body>
  <div class="p-5 mb-4 bg-light rounded-3">
    <div class="container-fluid py-5">
      <h1 class="display-5 fw-bold">Welcome to MySite</h1>
      <p class="col-md-8 fs-4">
        Đây là trang web demo tích hợp <strong>SiteMesh 3</strong> với template <strong>Bootstrap 5</strong>.
      </p>
      <a href="${pageContext.request.contextPath}/views/login.jsp" class="btn btn-primary btn-lg">
        Bắt đầu ngay
      </a>
    </div>
  </div>

  <div class="row">
    <div class="col-md-4">
      <div class="card shadow-sm">
        <div class="card-body">
          <h5 class="card-title">Login</h5>
          <p class="card-text">Đăng nhập để sử dụng các chức năng dành cho người dùng.</p>
          <a href="${pageContext.request.contextPath}/views/login.jsp" class="btn btn-outline-primary">Go</a>
        </div>
      </div>
    </div>

    <div class="col-md-4">
      <div class="card shadow-sm">
        <div class="card-body">
          <h5 class="card-title">Register</h5>
          <p class="card-text">Tạo tài khoản mới để tham gia hệ thống.</p>
          <a href="${pageContext.request.contextPath}/views/register.jsp" class="btn btn-outline-success">Go</a>
        </div>
      </div>
    </div>

    <div class="col-md-4">
      <div class="card shadow-sm">
        <div class="card-body">
          <h5 class="card-title">Profile</h5>
          <p class="card-text">Cập nhật thông tin cá nhân của bạn.</p>
          <a href="${pageContext.request.contextPath}/profile" class="btn btn-outline-warning">Go</a>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
