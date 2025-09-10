<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<header>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand fw-bold" href="${pageContext.request.contextPath}/admin/home.jsp">Admin Panel</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarAdmin">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarAdmin">
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
          <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/list-category.jsp">Categories</a></li>
          <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/add-category.jsp">Add Category</a></li>
          <li class="nav-item"><a class="nav-link text-danger" href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </ul>
      </div>
    </div>
  </nav>
</header>
