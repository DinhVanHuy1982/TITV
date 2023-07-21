<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width-device-width ,intial-scale=1,shrinl-to-fit=no">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
</head>
<body>
<%
	String baoloi= request.getAttribute("baoloi")+"";
	String tenDangNhap= request.getAttribute("tenDangNhap")+"";
	String matKhau= request.getAttribute("matKhau")+"";
	tenDangNhap = (tenDangNhap.equals("null"))?"":tenDangNhap;
	baoloi = (baoloi.equals("null"))?"":baoloi;
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
	<div class="container">
		<form action="<%= path %>/do-action" method="post">
			<input type="hidden" name="hanhDong" value="login" /> 
			<div class="mb-3">
				<label for="tenDangNhap" class="form-label">Tên đăng nhập</label> 
				<input type="text" value="<%=tenDangNhap %>" class="form-control" name="tenDangNhap" id="tenDangNhap" required="required">
			</div>
			<div class="mb-3">
				<label for="matKhau" class="form-label">Mật khẩu</label>
				<input type="password" class="form-control" name="matKhau" id="matKhau" required="required">
			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Check me out</label>
			</div>
			<span><%= baoloi %></span><br>
			<a class="btn btn-outline-success" href="<%=path %>/khachhang/register.jsp" style="white-space: nowrap">Đăng kí</a>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>