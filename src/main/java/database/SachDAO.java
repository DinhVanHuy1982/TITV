package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DAOInterface.DAOInterface;
import model.Sach;
import model.TacGia;
import model.TheLoai;

public class SachDAO implements DAOInterface<Sach>{
	@Override
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> data= new ArrayList<Sach>();
		Connection con = JDBCUtil.getConnection();
		try {
			String sql = "SELECT * FROM sanpham";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String masanpham = rs.getString("masanpham");
				String tensanpham = rs.getString("tensanpham");
				String matacgia = rs.getString("matacgia");
				int namxuatban = rs.getInt("namxuatban");
				double gianhap = rs.getDouble("gianhap");
				double giagoc = rs.getDouble("giagoc");
				double giaban = rs.getDouble("giaban");
				int soluong 	 = rs.getInt("soluong");		
				String matheloai = rs.getString("matheloai");
				String ngonngu = rs.getString("ngonngu");
				String mota = rs.getString("mota");
				
				TheLoai theLoai = new TheLoai(matheloai, null);
				TheLoai tld = new TheLoaiDAO().selectByID(theLoai);
				
				TacGia tacGia = new TacGia(matacgia, null, null, null);
				TacGia tgd = new TacGiaDAO().selectByID(tacGia);
				
				Sach sach = new Sach(masanpham, tensanpham, tgd, namxuatban, gianhap, giagoc, giaban, soluong, tld, ngonngu, mota);
				data.add(sach);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		JDBCUtil.closeConnection(con);
		return data;
	}

	@Override
	public Sach selectByID(Sach t) {
		Sach data= new Sach();
		Connection con = JDBCUtil.getConnection();
		try {
			String sql = "SELECT * FROM sanpham WHERE masanpham=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaSach());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String masanpham = rs.getString("masanpham");
				String tensanpham = rs.getString("tensanpham");
				String matacgia = rs.getString("matacgia");
				int namxuatban = rs.getInt("namxuatban");
				double gianhap = rs.getDouble("gianhap");
				double giagoc = rs.getDouble("giagoc");
				double giaban = rs.getDouble("giaban");
				int soluong 	 = rs.getInt("soluong");		
				String matheloai = rs.getString("matheloai");
				String ngonngu = rs.getString("ngonngu");
				String mota = rs.getString("mota");
				
				TheLoai theLoai = new TheLoai(matheloai, null);
				TheLoai tld = new TheLoaiDAO().selectByID(theLoai);
				
				TacGia tacGia = new TacGia(matacgia, null, null, null);
				TacGia tgd = new TacGiaDAO().selectByID(tacGia);
				
				Sach sach = new Sach(masanpham, tensanpham, tgd, namxuatban, gianhap, giagoc, giaban, soluong, tld, ngonngu, mota);
				data=sach;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		JDBCUtil.closeConnection(con);
		return data;
		
	}

	@Override
	public int insert(Sach t) {
		int dem=0;
		Connection con = JDBCUtil.getConnection();
		try {
			String sql = "INSERT INTO sanpham(masanpham, tensanpham, matacgia, namxuatban,"
					+ " gianhap, giagoc, giaban, soluong, matheloai, ngonngu, mota)"
					+ " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getMaSach());
			st.setString(2,t.getTenSach());
			st.setString(3,t.getTacGia().getMaTacGia());
			st.setInt(4,t.getNamXuatBan());
			st.setDouble(5,t.getGiaNhap());
			st.setDouble(6,t.getGiaGoc());
			st.setDouble(7,t.getGiaBan());
			st.setInt(8,t.getSoLuong());
			st.setString(9,t.getTheLoai().getMaTheLoai());
			st.setString(10,t.getNgonNgu());
			st.setString(11,t.getMoTa());

			dem = st.executeUpdate();
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Có "+dem+" dòng bị thay đổi!");
		JDBCUtil.closeConnection(con);
		return dem;
		
	}

	@Override
	public int insertAll(ArrayList<Sach> arrlist) {
		Connection con = JDBCUtil.getConnection();
		int dem=0;
		try {
			
			
			for(Sach t: arrlist){
				String sql =  "INSERT INTO sanpham(masanpham, tensanpham, matacgia, namxuatban,"
					+ " gianhap, giagoc, giaban, soluong, matheloai, ngonngu, mota)"
					+ " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,t.getMaSach());
				st.setString(2,t.getTenSach());
				st.setString(3,t.getTacGia().getMaTacGia());
				st.setInt(4,t.getNamXuatBan());
				st.setDouble(5,t.getGiaNhap());
				st.setDouble(6,t.getGiaGoc());
				st.setDouble(7,t.getGiaBan());
				st.setInt(8,t.getSoLuong());
				st.setString(9,t.getTheLoai().getMaTheLoai());
				st.setString(10,t.getNgonNgu());
				st.setString(11,t.getMoTa());
				dem+= st.executeUpdate();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Có "+dem+" dòng bị thay đổi!");
		JDBCUtil.closeConnection(con);
		return dem;
		
	}

	@Override
	public int delete(Sach t) {
		int dem=0;
		Connection con = JDBCUtil.getConnection();
		try {
			String sql = "DELETE FROM sanpham WHERE masanpham=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getMaSach());

			dem = st.executeUpdate();
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Có "+dem+" dòng bị thay đổi!");
		JDBCUtil.closeConnection(con);
		return dem;
		
		
	}

	@Override
	public int deleteAll(ArrayList<Sach> arrlist) {
		Connection con = JDBCUtil.getConnection();
		int dem=0;
		try {
			
			
			for(Sach t: arrlist){
				String sql =  "DELETE FROM sanpham WHERE masanpham=?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,t.getMaSach());
				
				dem+= st.executeUpdate();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Có "+dem+" dòng bị thay đổi!");
		JDBCUtil.closeConnection(con);
		return dem;
		
	}

	@Override
	public int update(Sach t) {
		Connection con = JDBCUtil.getConnection();
		int dem=0;
		try {
			String sql =  "UPDATE sanpham SET masanpham=?, tensanpham=?, matacgia=?, namxuatban=?, "
					+ "gianhap=?, giagoc=?, giaban=?, soluong=?, "
					+ "matheloai=?, ngonngu=?, mota=?  WHERE masanpham=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getMaSach());
			st.setString(2,t.getTenSach());
			st.setString(3,t.getTacGia().getMaTacGia());
			st.setInt(4,t.getNamXuatBan());
			st.setDouble(5,t.getGiaNhap());
			st.setDouble(6,t.getGiaGoc());
			st.setDouble(7,t.getGiaBan());
			st.setInt(8,t.getSoLuong());
			st.setString(9,t.getTheLoai().getMaTheLoai());
			st.setString(10,t.getNgonNgu());
			st.setString(11,t.getMoTa());
			st.setString(12,t.getMaSach());
			dem+= st.executeUpdate();
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Có "+dem+" dòng bị thay đổi!");
		JDBCUtil.closeConnection(con);
		return dem;
		
	}
	public static void main(String[] args) {
		SachDAO sd = new SachDAO();
		TacGia tacgia_new = new TacGia("TG12", "Đinh Văn Huy", new Date(2002-1900, 7, 19), null);
		TheLoai theLoai = new TheLoai("TCT", "Truyện cổ tích");
		Sach sach = new Sach("SP05", null, tacgia_new, 0, 0, 0, 0, 0, theLoai, null, null);
		sd.insert(sach);
		ArrayList<Sach> list= new ArrayList<>();
		list = sd.selectAll();
		for(Sach s: list) {
			String row="Mã sách: "+s.getMaSach();
			System.out.println(row);
		}
		
	}
	
	
}
