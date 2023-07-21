package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Util.Email;
import Util.MaXacThuc;
import database.KhachHangDAO;
import model.KhachHang;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/do-RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				try {
					String tenDangNhap = request.getParameter("tenTaiKhoan");
					String matKhau = request.getParameter("matKhau");
					String matKhau2 = request.getParameter("matKhau2");
					String hoVaTen = request.getParameter("hoVaTen");
					String gioiTinh = request.getParameter("gioiTinh");
					String ngaySinh = request.getParameter("ngaySinh");
					String diaChiKhachHang = request.getParameter("diaChiKhachHang");
					String diaChiMuaHang = request.getParameter("diaChiMuaHang");
					String dienThoai = request.getParameter("dienThoai");
					String email = request.getParameter("email");
					String dieuKhoan = request.getParameter("dongYDieuKhoan");
					String dongYEmail = request.getParameter("dongYNBTEM");
					//String duongDanAnh = request.getParameter("duongdananh");
					String duongDanAnh=null;
					
					request.setAttribute("tenDangNhap", tenDangNhap);
					request.setAttribute("hoVaTen", hoVaTen);
					request.setAttribute("gioiTinh", gioiTinh);
					request.setAttribute("ngaySinh", ngaySinh);
					request.setAttribute("diaChiKhachHang", diaChiKhachHang);
					request.setAttribute("diaChiMuaHang", diaChiMuaHang);
					request.setAttribute("dienThoai", dienThoai);
					request.setAttribute("email", email);
					request.setAttribute("dieuKhoan", dieuKhoan);
					request.setAttribute("dongYEmail", dongYEmail);
					//request.setAttribute("duongDanAnh", duongDanAnh);
					
					
					String baoLoi="";
					String url="";
					KhachHangDAO khachHangDAO = new KhachHangDAO();
					if(khachHangDAO.kiemTraTDN(tenDangNhap)) {
						baoLoi+="Tên đăng nhập đã tồn tại vui lòng chọn tên đăng nhập khác!</br>";
					}
					
					if(!matKhau.equals(matKhau2)) {
						baoLoi+="Mật khẩu không khớp!</br>";
					}
					
					if(baoLoi.length()>0) {
						request.setAttribute("baoLoi", baoLoi);
						url="/khachhang/register.jsp";
					}else {
						Random rd= new Random();
						String maKhachHang = System.currentTimeMillis()+rd.nextInt(1000)+"";
						System.out.println("toi day rôi");
						KhachHang khachHang = new KhachHang(maKhachHang, tenDangNhap, matKhau2, gioiTinh, hoVaTen, diaChiKhachHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYEmail!=null,"chua có");
						System.out.println(matKhau);
						if(khachHangDAO.insert(khachHang)>0) {
							khachHang = khachHangDAO.kiemTraTaiKhoan(tenDangNhap, matKhau);
							
							MaXacThuc maXacThuc = new MaXacThuc();
							String mxt = maXacThuc.getMaXacThuc();
							// lấy ra thời gian hiện tại
							Date today = new Date(new java.util.Date().getTime());
							//lấy thời gian để có thể cộng thêm
							Calendar c = Calendar.getInstance();
							c.setTime(today);
							c.add(Calendar.DATE, 1); // quy định thời gian cộng thêm
							
							//thời gian còn hiệu lực của mã
							Date thoiGianHieuLucXacThuc = new Date(c.getTimeInMillis());
							
							//trang thái xác thực = false
							boolean trangThaiXacThuc =false;
							khachHang.setMaXacThuc(mxt);
							khachHang.setThoiGianHieuLucMaXacThuc(thoiGianHieuLucXacThuc);
							khachHang.setTrangThaiXacThuc(trangThaiXacThuc);
							
							if(khachHangDAO.updateVerifyInformation(khachHang)>0) {
								// gửi email cho khách hàng
								Email sentEmail = new Email();
								sentEmail.sentEmail(khachHang.getEmail(),"Email xác nhận đăng kí tài khoản", noiDung(khachHang));
								url="/khachhang/success-register.jsp";
							}
							
						}else {
							baoLoi="Chưa thêm tài khoản thành cong";
							url="/khachhang/register.jsp";
						}
						
					}
					
					RequestDispatcher dp = getServletContext().getRequestDispatcher(url);
					dp.forward(request, response);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public String noiDung(KhachHang kh) {
		String url ="http://localhost:8080/Bai14_BookStore_p1/do-action?hanhDong=verify&maKhachHang="+kh.getMaKhachHang()+"&maXacThuc="+kh.getMaXacThuc();
		String nd= "<p>Xin ch&agrave;o <strong>"+kh.getHoVaTen()+"</strong>, m&atilde; x&aacute;c thực của bạn l&agrave;:&nbsp;<strong>"+kh.getMaXacThuc()+"</strong>.&nbsp;</p>\r\n"
				+ "<p>X&aacute;c thực t&agrave;i khoản của bạn bằng c&aacute;ch nhập m&atilde; x&aacute;c thực tr&ecirc;n hoặc click v&agrave;o link sau</p>\r\n"
				+ "<p><a href=\""+url+"\">"+url+"</a></p>";
		return nd;
	}

}
