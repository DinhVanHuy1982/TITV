<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.KhachHang"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" >
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<%
		Object obj = session.getAttribute("khachHang");
		KhachHang khachHang = null;
		if (obj!=null)
			khachHang = (KhachHang)obj;		
			if(khachHang==null){		
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>
	<%
			}else {
				
	%>
	<div class="container">
	<%
		String baoLoi = request.getAttribute("baoLoi")+"";
		baoLoi = (baoLoi.equals("null"))?"":baoLoi;
		
		String duongDanAnh= khachHang.getDuongDanAnh();
		
	%>
	<div class="container">
		<div class="text-center">
			<h1>THÔNG TIN TÀI KHOẢN</h1>
		</div>
		
		<div class="red" id="baoLoi">
			<%=baoLoi %>
		</div>
		<%
		 String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
		 %>
		<form class="form" action="<%=url1 %>/changeImage" method="post" enctype="multipart/form-data">
			
			<div class="row">
				<div class="col-sm-6">
					
					<h3>Thông tin khách hàng</h3>
					<img src="<%=url1 %>/avatar/<%=duongDanAnh%>" alt="Ảnh Avatar"/>
					<div class="mb-3">
						<label for="duongDanAnh" class="form-label">Đường dẫn ảnh</label> <input
							type="file" class="form-control" id="duongDanAnh" name="duongDanAnh">
					</div>
					
					<input class="btn btn-primary form-control" type="submit"
						value="Lưu thông tin" name="submit" id="submit" />
				</div>
			</div>
		</form>
	</div>
	</div>
	<%} %>
	<jsp:include page="../footer.jsp" />
</body>
</html>