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
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.naming.java.javaURLContextFactory;

import Util.Email;
import Util.MaXacThuc;
import database.KhachHangDAO;
import model.KhachHang;


/**
 * Servlet implementation class ClientController
 */
@WebServlet("/do-action")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hanhDong = request.getParameter("hanhDong");
		 if(hanhDong.equals("logout")) {
			LogOut(request,response);
		}else if(hanhDong.equals("verify")) {
			xacThuc(request, response);
		}else if(hanhDong.equals("login")) {
			Login(request,response);
		}else if(hanhDong.equals("register")) {
			Register(request,response);
		}
		 System.out.println(hanhDong);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hanhDong = request.getParameter("hanhDong");
		if(hanhDong.equals("login")) {
			Login(request,response);
		}if(hanhDong.equals("register")) {
			Register(request,response);
		}
		System.out.println(hanhDong);
	}
	private void Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
//			String forder = getServletContext().getRealPath(getInitParameter("avatar"));
//			System.out.println(forder);
//			File file;
//			int maxSize =5000*1024; //kích cỡ ảnh
//			int maxMemSize = 5000*1024;// 
//			
//			String  contentType = request.getContentType();
//			if(contentType.indexOf(contentType)>0) {
//				DiskFileItemFactory factory = new DiskFileItemFactory();
//				
//				//quy định dung lượng tối đa của 1 file
//				factory.setSizeThreshold(maxMemSize);
//				
//				//tạo file
//				ServletFileUpload upload = new ServletFileUpload(factory);
//				
//				List<FileItem> files = upload.parseRequest(request);
//				
//				for(FileItem fileItem: files) {
//					String fileName = System.currentTimeMillis()+ fileItem.getName();
//					String path = forder+"\\" +fileName;
//					file = new File(path);
//					fileItem.write(file);
//					
//					String duongDanAnh = fileName;
//				}
//			
//			}
			
			
			
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
				url="/khachhang/register.jsp";
			}else {
				
				Random rd= new Random();
				String maKhachHang = System.currentTimeMillis()+rd.nextInt(1000)+"";
				KhachHang khachHang = new KhachHang(maKhachHang, tenDangNhap, matKhau2, gioiTinh, hoVaTen, diaChiKhachHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYEmail!=null);
				System.out.println("vao toi day");
				if(khachHangDAO.insert(khachHang)>0) {
					
					System.out.println("dã tới đây");
					
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
					
				}else{
					baoLoi="Chưa thêm tài khoản thành cong";
					url="/khachhang/register.jsp";
				}
				
			}
			request.setAttribute("baoLoi", baoLoi);
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
	
	private void xacThuc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {


			String makhachang = request.getParameter("maKhachHang");
			String maxacthuc = request.getParameter("maXacThuc");
			
			System.out.println(makhachang);
			
			String url="";
			String msg="";
			KhachHangDAO khachHangDAO = new KhachHangDAO();

			KhachHang kh = new KhachHang(makhachang, null, null, null,null, null, null, null, null, null, false);
			
			KhachHang khachHang = khachHangDAO.selectByID(kh);
			//System.out.println(khachHang.getMaKhachHang());
			if(khachHang !=null) {
				String mxtSQL = khachHang.getMaXacThuc();
				if(mxtSQL.equals(maxacthuc)) {
					// thành công
					khachHang.setTrangThaiXacThuc(true);
					khachHangDAO.updateVerifyInformation(khachHang);
					 msg = "Xác thực thành công!";
				}else {
					// thất bại
					 msg = "Xác thực không thành công!";
				}
			}else {
				msg="Tài khoản không tồn tại";
			}
			url="/khachhang/thongbao.jsp";	
			
			request.setAttribute("msg", msg);
			RequestDispatcher dp = getServletContext().getRequestDispatcher(url);
			dp.forward(request, response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
	private void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			//matKhau = MaHoa.toSHA1(matKhau);

			KhachHang kh = new KhachHang();
			kh.setTenDangNhap(tenDangNhap);
			kh.setMatKhau(matKhau);

			KhachHangDAO khd = new KhachHangDAO();
			KhachHang khachHang = khd.kiemTraTaiKhoan(kh.getTenDangNhap(),kh.getMatKhau());
			String url = "";
			if (khachHang != null && khachHang.getTrangThaiXacThuc()) {
				// if (khachHang != null) {
				HttpSession session = request.getSession();
				session.setAttribute("khachHang", khachHang);
				url = "/index.jsp";
			} else {
				request.setAttribute("baoLoi",
						"Tên đăng nhập hoặc mật khẩu không đúng / hoặc Tài khoản chưa xác thực!");
				url = "/khachhang/dangnhap.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		try {
//			request.setCharacterEncoding("UTF-8");
//			response.setCharacterEncoding("UTF-8");
//			response.setContentType("text/html;charset=UTF-8");
//			
//			String tenDangNhap=request.getParameter("tenDangNhap");
//			String matKhau = request.getParameter("matKhau");
//			
//			request.setAttribute("matKhau", matKhau);
//			
//			KhachHangDAO khd = new KhachHangDAO();
//			String url="";
//			String baoloi="";
//			KhachHang khachHang = khd.kiemTraTaiKhoan(tenDangNhap,matKhau);
//			if(khachHang!=null) {
//					String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
//					if(khachHang.getTrangThaiXacThuc()==true) {
//						url="/index.jsp";
//						baoloi+="Thành công";
//						HttpSession session_login = request.getSession();
//						session_login.setAttribute("username", tenDangNhap);
//					}else {
//						baoloi+="Tài khoản chưa xác thực !";
//						url="/khachhang/login.jsp";
//					}
//				
//			}else {
//				baoloi+="Tên đăng nhập không tồn tại!";
//				url="/khachhang/login.jsp";
//			}
//			request.setAttribute("baoloi", baoloi);
//			request.setAttribute("tenDangNhap", tenDangNhap);
//			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
//			rd.forward(request, response);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	private void LogOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("khacHang");

			
			
			String url="/index.jsp";
			RequestDispatcher rp = getServletContext().getRequestDispatcher(url);
			rp.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
