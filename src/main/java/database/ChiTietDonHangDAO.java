package database;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DAOInterface.DAOInterface;
import model.ChiTietDonHang;
import model.DonHang;
import model.Sach;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang>{
	@Override
	public ArrayList<ChiTietDonHang> selectAll() {
		ArrayList<ChiTietDonHang> ketqua = new ArrayList<ChiTietDonHang>();
		// TODO Auto-generated method stub
		try {	
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM chitietdonhang";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maChiTietDonHang = rs.getString("maChiTietDonHang");
				String madonhang = rs.getString("madonhang");
				String masanpham = rs.getString("masanpham");
				int soluong = rs.getInt("soluong");
				Double giagoc = rs.getDouble("giagoc");
				Double giamgia = rs.getDouble("giamgia");
				Double giaban = rs.getDouble("giaban");
				Double thuevat = rs.getDouble("thuevat");
				Double tongtien = rs.getDouble("tongtien");
				
				DonHang donHang = new DonHang();
				donHang.setMaDonHang(madonhang);
				DonHang dh= new DonHangDAO().selectByID(donHang);
				
				Sach sach = new Sach();
				sach.setMaSach(masanpham);
				Sach s=new SachDAO().selectByID(sach);
				
				ChiTietDonHang chiTietDonHang = new ChiTietDonHang(maChiTietDonHang, dh, s, soluong, giagoc, giamgia, giaban, thuevat, tongtien);
				ketqua.add(chiTietDonHang);
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
	public ChiTietDonHang selectByID(ChiTietDonHang t) {
		ChiTietDonHang ketqua = new ChiTietDonHang();
		// TODO Auto-generated method stub
		try {	
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM ChiTietDonHang WHERE maChiTietDonHang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaChiTietDonHang());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maChiTietDonHang = rs.getString("maChiTietDonHang");
				String madonhang = rs.getString("madonhang");
				String masanpham = rs.getString("masanpham");
				int soluong = rs.getInt("soluong");
				Double giagoc = rs.getDouble("giagoc");
				Double giamgia = rs.getDouble("giamgia");
				Double giaban = rs.getDouble("giaban");
				Double thuevat = rs.getDouble("thuevat");
				Double tongtien = rs.getDouble("tongtien");
				
				DonHang donHang = new DonHang();
				donHang.setMaDonHang(madonhang);
				DonHang dh= new DonHangDAO().selectByID(donHang);
				
				Sach sach = new Sach();
				sach.setMaSach(masanpham);
				Sach s=new SachDAO().selectByID(sach);
				
				ChiTietDonHang chiTietDonHang = new ChiTietDonHang(maChiTietDonHang, dh, s, soluong, giagoc, giamgia, giaban, thuevat, tongtien);
				ketqua = chiTietDonHang;
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
	public int insert(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			if(isEmpty(t)) {
				// Bước 2: tạo ra đối tượng statementmaChiTietDonHang, String hoVaTen, Date ngaySinh, String tieuSu
				String sql = "INSERT INTO ChiTietDonHang (machitietdonhang, madonhang, masanpham, soluong, "
						+ "giagoc, giamgia, giaban, thuevat, tongtien) "+
						" VALUES (?,?,?,?,?,?,?,?,?)";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaChiTietDonHang());
				st.setString(2, t.getDonHang().getMaDonHang());
				st.setString(3, t.getSach().getMaSach());
				st.setInt(4, t.getSoLuong());
				st.setDouble(5, t.getGiaBia());
				st.setDouble(6, t.getGiamGia());
				st.setDouble(7, t.getGiaBan());
				st.setDouble(8, t.getThueVAT());
				st.setDouble(9, t.getTongTien());
				
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
	public int insertAll(ArrayList<ChiTietDonHang> arrlist) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statementmaChiTietDonHang, String hoVaTen, Date ngaySinh, String tieuSu
			for(ChiTietDonHang t:arrlist) {
				String sql = "INSERT INTO ChiTietDonHang (machitietdonhang, madonhang, masanpham, soluong, "
						+ "	giagoc, giamgia, giaban, thuevat, tongtien) "
						+ "VALUES (?,?,?,?,?,?,?,?,?)";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaChiTietDonHang());
				st.setString(2, t.getDonHang().getMaDonHang());
				st.setString(3, t.getSach().getMaSach());
				st.setInt(4, t.getSoLuong());
				st.setDouble(5, t.getGiaBia());
				st.setDouble(6, t.getGiamGia());
				st.setDouble(7, t.getGiaBan());
				st.setDouble(8, t.getThueVAT());
				st.setDouble(9, t.getTongTien());
				
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
	public int delete(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statementmaChiTietDonHang, String hoVaTen, Date ngaySinh, String tieuSu
			String sql = "DELETE FROM ChiTietDonHang WHERE maChiTietDonHang=? ";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaChiTietDonHang());

			
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
	public int deleteAll(ArrayList<ChiTietDonHang> arrlist) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statementmaChiTietDonHang, String hoVaTen, Date ngaySinh, String tieuSu
			for(ChiTietDonHang t:arrlist) {
				String sql = "DELETE FROM ChiTietDonHang WHERE maChiTietDonHang=?";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaChiTietDonHang());						
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
	public int update(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statementmaChiTietDonHang, String hoVaTen, Date ngaySinh, String tieuSu
			
				String sql = "UPDATE ChiTietDonHang SET machitietdonhang=?, madonhang=?, masanpham=?, soluong=?, giagoc=?, giamgia=?, giaban=?, thuevat=?, tongtien=? WHERE maChiTietDonHang=?";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaChiTietDonHang());
				st.setString(2, t.getDonHang().getMaDonHang());
				st.setString(3, t.getSach().getMaSach());
				st.setInt(4, t.getSoLuong());
				st.setDouble(5, t.getGiaBia());
				st.setDouble(6, t.getGiamGia());
				st.setDouble(7, t.getGiaBan());
				st.setDouble(8, t.getThueVAT());
				st.setDouble(9, t.getTongTien());
				st.setString(10, t.getMaChiTietDonHang());
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
	public boolean isEmpty(ChiTietDonHang t) {
		
		Connection con = JDBCUtil.getConnection();
		String sql= "SELECT COUNT(maChiTietDonHang) FROM ChiTietDonHang WHERE maChiTietDonHang = ?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaChiTietDonHang());
			ResultSet count = st.executeQuery();
			if(count.next()) {
				int dem = count.getInt(1);
				if(dem!=0) return false;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static void main(String[] arg) {
//		ChiTietDonHangDAO tgd = new ChiTietDonHangDAO();
//		ArrayList<ChiTietDonHang> list= new ArrayList<ChiTietDonHang>();
//		ChiTietDonHang ChiTietDonHang_new = new ChiTietDonHang("TG12", "Đinh Văn Huy", new Date(2002-1900, 7, 19), null);
//		tgd.insert(ChiTietDonHang_new);
//		list = tgd.selectAll();
//		for(ChiTietDonHang ChiTietDonHang: list) {
//			StringBuilder row=new StringBuilder();
//			row.append("Mã tác giả: ").append(ChiTietDonHang.getMaChiTietDonHang());
//			row.append("\tTên tác giả: ").append(ChiTietDonHang.getHoVaTen());
//			row.append("\tNgày sinh: ").append(ChiTietDonHang.getNgaySinh().toString());
//			row.append("\tTiểu sử: ").append(ChiTietDonHang.getTieuSu());
//			System.out.println(row);
//		}
		
//		ArrayList<ChiTietDonHang> list_insert= new ArrayList<ChiTietDonHang>();
//		list_insert.add(new ChiTietDonHang("TG11", "Đinh Văn Huy", new Date(2002-1900, 7, 19), null));
//		list_insert.add(new ChiTietDonHang("TG12", "Đinh Văn Huy", new Date(2002-1900, 7, 19), null));
//		list_insert.add(new ChiTietDonHang("TG13", "Đinh Văn Huy", new Date(2002-1900, 7, 19), null));
//		tgd.insertAll(list_insert);
		
		
		//tgd.delete(new ChiTietDonHang("TG6", null, null, null));
		//tgd.deleteAll(list_insert);
		
		//tgd.update(new ChiTietDonHang("TG9", "Trần Thị Thanh Hiền", new Date(2005-1900, 7, 7), null));
	}
}
