package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import DAOInterface.DAOInterface;
import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia>{
	@Override
	public ArrayList<TacGia> selectAll() {
		ArrayList<TacGia> ketqua = new ArrayList<TacGia>();
		// TODO Auto-generated method stub
		try {	
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM tacgia";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String hoVaTen = rs.getString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getString("tieusu");
				TacGia tacGia = new TacGia(maTacGia, hoVaTen, ngaySinh,tieuSu);
				ketqua.add(tacGia);
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
	public TacGia selectByID(TacGia t) {
		TacGia ketqua = new TacGia();
		// TODO Auto-generated method stub
		try {	
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM tacgia WHERE matacgia=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String hoVaTen = rs.getString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getString("tieusu");
				TacGia tacGia = new TacGia(maTacGia, hoVaTen, ngaySinh,tieuSu);
				ketqua = tacGia;
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
	public int insert(TacGia t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			if(isEmpty(t)) {
				// Bước 2: tạo ra đối tượng statementmaTacGia, String hoVaTen, Date ngaySinh, String tieuSu
				String sql = "INSERT INTO tacgia (matacgia, hovaten,ngaysinh,tieusu) "+
						" VALUES (?,?,?,?)";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaTacGia());
				st.setString(2, t.getHoVaTen());
				st.setDate(3, t.getNgaySinh());
				st.setString(4, t.getTieuSu());
				
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
	public int insertAll(ArrayList<TacGia> arrlist) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statementmaTacGia, String hoVaTen, Date ngaySinh, String tieuSu
			for(TacGia t:arrlist) {
				String sql = "INSERT INTO tacgia (matacgia, hovaten,ngaysinh,tieusu) "+
						" VALUES (?,?,?,?)";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaTacGia());
				st.setString(2, t.getHoVaTen());
				st.setDate(3, t.getNgaySinh());
				st.setString(4, t.getTieuSu());
				
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
	public int delete(TacGia t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statementmaTacGia, String hoVaTen, Date ngaySinh, String tieuSu
			String sql = "DELETE FROM tacgia WHERE matacgia=? ";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());

			
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
	public int deleteAll(ArrayList<TacGia> arrlist) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statementmaTacGia, String hoVaTen, Date ngaySinh, String tieuSu
			for(TacGia t:arrlist) {
				String sql = "DELETE FROM tacgia WHERE matacgia=?";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaTacGia());						
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
	public int update(TacGia t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statementmaTacGia, String hoVaTen, Date ngaySinh, String tieuSu
			
				String sql = "UPDATE tacgia SET matacgia=?, hovaten=?,ngaysinh=?,tieusu=? WHERE matacgia=?";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaTacGia());
				st.setString(2, t.getHoVaTen());
				st.setDate(3, t.getNgaySinh());
				st.setString(4, t.getTieuSu());			
				st.setString(5, t.getMaTacGia());
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
	public boolean isEmpty(TacGia t) {
		
		Connection con = JDBCUtil.getConnection();
		String sql= "SELECT COUNT(matacgia) FROM tacgia WHERE matacgia = ?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());
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
		TacGiaDAO tgd = new TacGiaDAO();
//		ArrayList<TacGia> list= new ArrayList<TacGia>();
		TacGia tacgia_new = new TacGia("TG12", "Đinh Văn Huy", new Date(2002-1900, 7, 19), null);
		tgd.insert(tacgia_new);
//		list = tgd.selectAll();
//		for(TacGia tacGia: list) {
//			StringBuilder row=new StringBuilder();
//			row.append("Mã tác giả: ").append(tacGia.getMaTacGia());
//			row.append("\tTên tác giả: ").append(tacGia.getHoVaTen());
//			row.append("\tNgày sinh: ").append(tacGia.getNgaySinh().toString());
//			row.append("\tTiểu sử: ").append(tacGia.getTieuSu());
//			System.out.println(row);
//		}
		
//		ArrayList<TacGia> list_insert= new ArrayList<TacGia>();
//		list_insert.add(new TacGia("TG11", "Đinh Văn Huy", new Date(2002-1900, 7, 19), null));
//		list_insert.add(new TacGia("TG12", "Đinh Văn Huy", new Date(2002-1900, 7, 19), null));
//		list_insert.add(new TacGia("TG13", "Đinh Văn Huy", new Date(2002-1900, 7, 19), null));
//		tgd.insertAll(list_insert);
		
		
		//tgd.delete(new TacGia("TG6", null, null, null));
		//tgd.deleteAll(list_insert);
		
		//tgd.update(new TacGia("TG9", "Trần Thị Thanh Hiền", new Date(2005-1900, 7, 7), null));
	}
}
