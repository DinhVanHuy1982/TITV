package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DAOInterface.DAOInterface;
import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang>{
	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> ketqua = new ArrayList<KhachHang>();
		// TODO Auto-generated method stub
		try {	
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM KhachHang";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while(rs.next()) {
				String maKhachHang = rs.getString("maKhachHang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String gioiTinh = rs.getString("gioitinh");
				String hoVaTen = rs.getString("hoten");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang=rs.getString("diachinhanhang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email= rs.getString("email");
				boolean dangKiNBTEM=rs.getBoolean("dangkinhanbangtin");
				String maxacthuc = rs.getString("maxacthuc");
				Date thoigianhieulucmaxacthuc = rs.getDate("thoigianhieulucmaxacthuc");
				int trangthaixacthuc = rs.getInt("trangthaixacthuc");
				String duongdananh= rs.getString("duongdananh");
				KhachHang KhachHang = new KhachHang(maKhachHang, tenDangNhap, matKhau, gioiTinh, hoVaTen, diaChi, diaChiNhanHang, ngaySinh, soDienThoai, email,dangKiNBTEM);
				ketqua.add(KhachHang);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketqua;
	}

	@Override
	public KhachHang selectByID(KhachHang t) {
		KhachHang ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang WHERE makhachhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKhachHang());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String maKhacHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hoten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String diaChiMuaHang = rs.getString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkinhanbangtin");
				String maXacThuc = rs.getString("maxacthuc");
				Date thoigianhieulucMaXacThuc = rs.getDate("thoigianhieulucmaxacthuc");
				boolean trangThaiXacThuc = rs.getBoolean("trangthaixacthuc");
				String duongDanAnh = rs.getString("duongdananh");
				ketQua = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang,
						diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, maXacThuc, thoigianhieulucMaXacThuc, trangThaiXacThuc, duongDanAnh);
				
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public boolean kiemTraTDN(String tdn) {
		
		// TODO Auto-generated method stub
		try {	
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM KhachHang WHERE tendangnhap=? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tdn);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			// Bước 4:
			while(rs.next()) {
				return true;
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public KhachHang kiemTraTaiKhoan(String tdn,String matKhau) {
		KhachHang ketqua = new KhachHang();
		// TODO Auto-generated method stub
		try {	
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM KhachHang WHERE tendangnhap=? and matkhau=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tdn);
			st.setString(2, matKhau);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			// Bước 4:
			while(rs.next()) {
				String maKhachHang = rs.getString("maKhachHang");
				
				String gioiTinh = rs.getString("gioitinh");
				String hoVaTen = rs.getString("hoten");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang=rs.getString("diachinhanhang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email= rs.getString("email");
				boolean dangKiNBTEM=rs.getBoolean("dangkinhanbangtin");
				String maxacthuc = rs.getString("maxacthuc");
				Date thoigianhieulucmaxacthuc = rs.getDate("thoigianhieulucmaxacthuc");
				Boolean trangthaixacthuc = rs.getBoolean("trangthaixacthuc");
				String duongdananh= rs.getString("duongdananh");
				KhachHang KhachHang = new KhachHang(maKhachHang, tdn, matKhau, gioiTinh, hoVaTen, diaChiNhanHang, diaChiNhanHang, diaChi, ngaySinh, soDienThoai, email, dangKiNBTEM, maxacthuc, thoigianhieulucmaxacthuc, trangthaixacthuc, duongdananh);
				ketqua = KhachHang;
				break;
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketqua;
	}

	@Override
	public int insert(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			if(isEmpty(t)) {
				// Bước 2: tạo ra đối tượng statementmaKhachHang, String hoVaTen, Date ngaySinh, String tieuSu
				String sql = "INSERT INTO KhachHang (makhachhang, tendangnhap, matkhau, hoten, "
						+ "gioitinh, diachi, diachinhanhang, diachimuahang, "
						+ "ngaysinh, sodienthoai, email, dangkinhanbangtin, "
						+ "maxacthuc, thoigianhieulucmaxacthuc, trangthaixacthuc, duongdananh) "+
						" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaKhachHang());
				st.setString(2, t.getTenDangNhap());
				st.setString(3, t.getMatKhau());
				st.setString(4, t.getHoVaTen());
				st.setString(5,t.getGioiTinh() );
				st.setString(6,t.getDiaChi() );
				st.setString(7,t.getDiaChiNhanHang() );
				st.setString(8,t.getDiaChiMuaHang());
				st.setDate(9,t.getNgaySinh() );
				st.setString(10,t.getSoDienThoai() );
				st.setString(11,t.getEmail() );
				st.setBoolean(12,t.isDangKiNBTEM() );
				st.setString(13,t.getMaXacThuc() );
				st.setDate(14,t.getThoiGianHieuLucMaXacThuc() );
				st.setBoolean(15,t.getTrangThaiXacThuc() );
				st.setString(16,"Chưa đưa vào");
				
				// Bước 3: thực thi câu lệnh SQL
				ketQua = st.executeUpdate();
			}
			
			// Bước 4:
			//System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<KhachHang> arrlist) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statementmaKhachHang, String hoVaTen, Date ngaySinh, String tieuSu
			for(KhachHang t:arrlist) {
				String sql = "INSERT INTO KhachHang (makhachhang, tendangnhap, matkhau, hoten, "
						+ "gioitinh, diachi, diachinhanhang, diachimuahang, "
						+ "ngaysinh, sodienthoai, email, dangkinhanbangtin, "
						+ "maxacthuc, thoigianhieulucmaxacthuc, trangthaixacthuc, duongdananh) "+
						" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaKhachHang());
				st.setString(2, t.getTenDangNhap());
				st.setString(3, t.getMatKhau());
				st.setString(4, t.getHoVaTen());
				st.setString(5,t.getGioiTinh() );
				st.setString(6,t.getDiaChi() );
				st.setString(7,t.getDiaChiNhanHang() );
				st.setString(8,t.getDiaChiMuaHang());
				st.setDate(9,t.getNgaySinh() );
				st.setString(10,t.getSoDienThoai() );
				st.setString(11,t.getEmail() );
				st.setBoolean(12,t.isDangKiNBTEM() );
				st.setString(13,t.getMaXacThuc() );
				st.setDate(14,t.getThoiGianHieuLucMaXacThuc() );
				st.setBoolean(15,t.getTrangThaiXacThuc() );
				st.setString(16,t.getDuongDanAnh() );
				
				// Bước 3: thực thi câu lệnh SQL
				ketQua = st.executeUpdate();
			}
			
			
			// Bước 4:
			//System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
		
	}

	@Override
	public int delete(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statementmaKhachHang, String hoVaTen, Date ngaySinh, String tieuSu
			String sql = "DELETE FROM KhachHang WHERE maKhachHang=? ";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKhachHang());

			
			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<KhachHang> arrlist) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statementmaKhachHang, String hoVaTen, Date ngaySinh, String tieuSu
			for(KhachHang t:arrlist) {
				String sql = "DELETE FROM KhachHang WHERE maKhachHang=?";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaKhachHang());						
				// Bước 3: thực thi câu lệnh SQL
				ketQua += st.executeUpdate();
			}
			
			
			// Bước 4:
			//System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int update(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statementmaKhachHang, String hoVaTen, Date ngaySinh, String tieuSu
			
				String sql = "UPDATE KhachHang SET makhachhang=?, tendangnhap=?, matkhau=?, hoten=?, "
						+ "gioitinh=?, diachi=?, diachinhanhang=?, diachimuahang=?, "
						+ "ngaysinh=?, sodienthoai=?, email=?, dangkinhanbangtin=?, "
						+ "maxacthuc=?, thoigianhieulucmaxacthuc=?, trangthaixacthuc=?, duongdananh=? "
						+ "WHERE maKhachHang=?";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaKhachHang());
				st.setString(2, t.getTenDangNhap());
				st.setString(3, t.getMatKhau());
				st.setString(4, t.getHoVaTen());
				st.setString(5,t.getGioiTinh() );
				st.setString(6,t.getDiaChi() );
				st.setString(7,t.getDiaChiNhanHang() );
				st.setString(8,t.getDiaChiMuaHang());
				st.setDate(9,t.getNgaySinh() );
				st.setString(10,t.getSoDienThoai() );
				st.setString(11,t.getEmail() );
				st.setBoolean(12,t.isDangKiNBTEM() );
				st.setString(13,t.getMaXacThuc() );
				st.setDate(14,t.getThoiGianHieuLucMaXacThuc() );
				st.setBoolean(15,t.getTrangThaiXacThuc() );
				st.setString(16,t.getDuongDanAnh() );
				st.setString(17, t.getMaKhachHang());
				// Bước 3: thực thi câu lệnh SQL
				ketQua = st.executeUpdate();
			
			
			
			// Bước 4:
			//System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
	
	public int updateImage(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statementmaKhachHang, String hoVaTen, Date ngaySinh, String tieuSu
			
				String sql = "UPDATE KhachHang SET duongdananh=? "
						+ "WHERE maKhachHang=?";
				
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1,t.getDuongDanAnh() );
				st.setString(2, t.getMaKhachHang());
				// Bước 3: thực thi câu lệnh SQL
				ketQua = st.executeUpdate();
			
			
			
			// Bước 4:
			//System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
	public int updateVerifyInformation(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statementmaKhachHang, String hoVaTen, Date ngaySinh, String tieuSu
			
				String sql = "UPDATE KhachHang SET "+
						"maxacthuc=?, thoigianhieulucmaxacthuc=?, trangthaixacthuc=?  "
						+ "WHERE maKhachHang=?";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaXacThuc());
				st.setDate(2, t.getThoiGianHieuLucMaXacThuc());
				st.setBoolean(3, t.getTrangThaiXacThuc());
				
				st.setString(4, t.getMaKhachHang());
				// Bước 3: thực thi câu lệnh SQL
				ketQua = st.executeUpdate();
			
			
			
			// Bước 4:
			//System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	public boolean isEmpty(KhachHang t) {
		
		Connection con = JDBCUtil.getConnection();
		String sql= "SELECT COUNT(maKhachHang) FROM KhachHang WHERE maKhachHang = ?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKhachHang());
			ResultSet count = st.executeQuery();
			if(count.next()) {
				int dem = count.getInt(0);
				if(dem!=0) return false;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static void main(String[] arg) {
		KhachHangDAO khd = new KhachHangDAO();
		//ArrayList<KhachHang> list= new ArrayList<KhachHang>();
		KhachHang KhachHang_new = new KhachHang("1668936750222", null, null, null,null, null, null, null, null, null, false);
		KhachHang_new=khd.selectByID(KhachHang_new);
		StringBuilder row=new StringBuilder();
		row.append("Mã tác giả: ").append(KhachHang_new.getMaKhachHang());
		row.append("\tTên đăng nhập: ").append(KhachHang_new.getTenDangNhap());
		row.append("\tMật khẩu: ").append(KhachHang_new.getMatKhau());
		row.append("\tGiới tính: ").append(KhachHang_new.getGioiTinh());
		row.append("\tHọ và tên: ").append(KhachHang_new.getHoVaTen());
		row.append("\tĐịa chỉ: ").append(KhachHang_new.getDiaChi());
		System.out.println(row);
//		list = khd.selectAll();
//		for(KhachHang KhachHang: list) {
//			StringBuilder row=new StringBuilder();
//			row.append("Mã tác giả: ").append(KhachHang.getMaKhachHang());
//			row.append("\tTên đăng nhập: ").append(KhachHang.getTenDangNhap());
//			row.append("\tMật khẩu: ").append(KhachHang.getMatKhau());
//			row.append("\tGiới tính: ").append(KhachHang.getGioiTinh());
//			row.append("\tHọ và tên: ").append(KhachHang.getHoVaTen());
//			row.append("\tĐịa chỉ: ").append(KhachHang.getDiaChi());
//			System.out.println(row);
//		}
		//khd.delete(KhachHang_new);
		
		
	}
}
