<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width-device-width ,intial-scale=1,shrinl-to-fit=no">
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
		String baoLoi= request.getAttribute("baoLoi")+"";
		baoLoi = (baoLoi.equals("null"))?"":baoLoi;	
	
		String tenDangNhap= request.getAttribute("tenDangNhap")+"";
		tenDangNhap = (tenDangNhap.equals("null"))?"":tenDangNhap;	
		
		String hoVaTen= request.getAttribute("hoVaTen")+"";
		hoVaTen = (hoVaTen.equals("null"))?"":hoVaTen;	
		
		String gioiTinh= request.getAttribute("gioiTinh")+"";
		gioiTinh = (gioiTinh.equals("null"))?"":gioiTinh;	
		
		String ngaySinh= request.getAttribute("ngaySinh")+"";
		ngaySinh = (ngaySinh.equals("null"))?"":ngaySinh;	
		
		String diaChiKhachHang= request.getAttribute("diaChiKhachHang")+"";
		diaChiKhachHang = (diaChiKhachHang.equals("null"))?"":diaChiKhachHang;	
		
		String diaChiMuaHang= request.getAttribute("diaChiMuaHang")+"";
		diaChiMuaHang = (diaChiMuaHang.equals("null"))?"":diaChiMuaHang;	
		
		String dienThoai= request.getAttribute("dienThoai")+"";
		dienThoai = (dienThoai.equals("null"))?"":dienThoai;	
		
		String email= request.getAttribute("email")+"";
		email = (email.equals("null"))?"":email;	
		
		String dieuKhoan= request.getAttribute("dieuKhoan")+"";
		dieuKhoan = (dieuKhoan.equals("null"))?"":dieuKhoan;	
		
		String dongYEmail= request.getAttribute("dongYEmail")+"";
		dongYEmail = (dongYEmail.equals("null"))?"":dongYEmail;	
		
		String duongDanAnh= request.getAttribute("duongDanAnh")+"";
		duongDanAnh = (duongDanAnh.equals("null"))?"":duongDanAnh;	
		
		
		String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	%>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
		<form class="form" action="<%=path %>/do-RegisterController" method="post" >
			<input type="hidden" value="register" name="hanhDong">
			<div class="row">
				<div class="text-center">
						<h3>Thông tin khách hàng</h3>
				</div>
				<div class="col-md-6">
					
					<h3>Tài khoản</h3>
					<div class="mb-3">
						<label for="tenTaiKhoan" class="form-label">Tên tài khoản</label> *
						<input type="text" value="<%=tenDangNhap %>" name="tenTaiKhoan" class="form-control" id="tenTaiKhoan" required="required">
					</div>
					<div class="mb-3">
						<label for="matKhau" class="form-label">Mật khẩu</label> *
						<input type="password"  name="matKhau" class="form-control" id="matKhau"  required="required">
					</div>
					<div class="mb-3">
						<label for="matKhau2" class="form-label">Nhập lại mật khẩu</label> *
						<input type="password" name="matKhau2" class="form-control" id="matKhau2"  required="required">
					</div>
					<hr>
					<div class="mb-3">
						<label for="hoVaTen" class="form-label">Họ và tên</label> 
						<input type="text" value="<%=hoVaTen %>" name="hoVaTen" class="form-control" id="hoVaTen" aria-describedby="emailHelp" required="required">
					</div>
					<div class="mb-3">
						<label for="gioiTinh" class="form-label">Giới tính</label> 
						<select class="form-control" id="gioiTinh" name="gioiTinh" required="required">
							<option value="Nam" <%= gioiTinh.equals("Nam")?"selected='selected'":' ' %>>Nam</option>
							<option value="Nữ"<%= gioiTinh.equals("Nữ")?"selected='selected'":' ' %>>Nữ</option>
							<option value="Khác"<%= gioiTinh.equals("Khác")?"selected='selected'":' '%>>Khác</option>
						</select>
						
					</div>
					<div class="mb-3">
						<label for="ngaySinh" class="form-label">Ngày sinh</label> 
						<input type="date" value="<%= ngaySinh%>" name="ngaySinh" class="form-control" id="ngaySinh">
					</div>
				</div>
				<div class="col-md-6">
					<h3>Địa chỉ</h3>
					<div class="mb-3">
						<label for="diaChiKhachHang" class="form-label">Địa chỉ khách hàng</label> 
						<input type="text" value="<%= diaChiKhachHang%>" name="diaChiKhachHang" class="form-control" id="diaChiKhachHang" required="required">
					</div>
					<div class="mb-3">
						<label for="diaChiMuaHang" class="form-label">Địa chỉ mua hàng</label> 
						<input type="text" value="<%= diaChiMuaHang%>" name="diaChiMuaHang" class="form-control" id="diaChiMuaHang">
					</div>
					<div class="mb-3">
						<label for="dienThoai" class="form-label">Điện thoại</label> 
						<input type="tel" value="<%= dienThoai%>" name="dienThoai" class="form-control" id="dienThoai">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> 
						<input type="email" value="<%=email %>" name="email" class="form-control" id="email" required="required">
					</div>
					<div class="mb-3">
						<label for="anh" class="form-label">Ảnh</label> 
						<input type="file" value="" name="anh" class="form-control" id="anh">
						<img src="<%= path %>/avartar/<%= duongDanAnh %>" width="100px" height="100px" alt="Ảnh avatar">
					</div>
				</div>
				<div class="mb-3">
					<input type="checkbox" <%= dieuKhoan.equals("on")?"checked='checked'":"" %> name="dongYDieuKhoan" class="form-check-input" id="dongYDieuKhoan" required="required" >
					<label for="dongYDieuKhoan"  class="form-label">Đồng ý với điều khoản của chúng tôi</label> 
					
				</div>
				<div class="mb-3">
					<input type="checkbox" <%= dongYEmail.equals("on")?"checked='checked'":"" %> name="dongYNBTEM" class="form-check-input" id="dongYNBTEM">
					<label for="dongYNBTEM"  class="form-label">Đồng ý nhận bản tin email</label> 
				</div>
				
				<div><%= baoLoi %></div>
				<button type="submit" class="btn btn-primary">Đăng kí</button>
			</div>
		</form>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>