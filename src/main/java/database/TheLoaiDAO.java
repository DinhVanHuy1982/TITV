package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAOInterface.DAOInterface;
import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai>{
	//private ArrayList<TheLoai> data= new ArrayList<TheLoai>();

	@Override
	public ArrayList<TheLoai> selectAll() {
		ArrayList<TheLoai> data= new ArrayList<TheLoai>();
		Connection con = JDBCUtil.getConnection();
		try {
			String sql = "SELECT * FROM theloai";
			PreparedStatement pr = con.prepareStatement(sql);
		
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				String matheloai = rs.getString("matheloai");
				String tentheloai = rs.getString("tentheloai");
				TheLoai theLoai = new TheLoai(matheloai, tentheloai);
				data.add(theLoai);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeConnection(con);
		return data;
	}

	@Override
	public TheLoai selectByID(TheLoai t) {
		TheLoai data=new TheLoai();
		Connection con = JDBCUtil.getConnection();
		try {
			
			String sql = "SELECT * FROM theloai WHERE matheloai=?";
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, t.getMaTheLoai());
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				String matheloai = rs.getString("matheloai");
				String tentheloai = rs.getString("tentheloai");
				TheLoai theLoai = new TheLoai(matheloai, tentheloai);
				data=theLoai;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeConnection(con);
		return data;
		
	}

	@Override
	public int insert(TheLoai t) {
		int dem=0;
		Connection con = JDBCUtil.getConnection();
		try {
			
			String sql = "INSERT INTO theloai(matheloai,tentheloai) VALUES(?,?)";
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, t.getMaTheLoai());
			pr.setString(2, t.getTenTheLoai());
			dem = pr.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Có "+ dem+" dòng bị thay đổi!");
		JDBCUtil.closeConnection(con);
		return dem;
		
	}

	@Override
	public int insertAll(ArrayList<TheLoai> arrlist) {
		int dem=0;
		try {
			Connection con = JDBCUtil.getConnection();
			for(TheLoai theLoai: arrlist){
				String sql = "INSERT INTO theloai(matheloai,tentheloai) VALUES(?,?)";
				PreparedStatement pr = con.prepareStatement(sql);
				pr.setString(1, theLoai.getMaTheLoai());
				pr.setString(2, theLoai.getTenTheLoai());
				dem += pr.executeUpdate();
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Có "+ dem+" dòng bị thay đổi!");
		return dem;
		
	}

	@Override
	public int delete(TheLoai t) {
		int dem=0;
		Connection con = JDBCUtil.getConnection();
		try {
			
			String sql = "DELETE FROM theloai WHERE matheloai=?";
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, t.getMaTheLoai());
			dem = pr.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Có "+ dem+" dòng bị thay đổi!");
		JDBCUtil.closeConnection(con);
		return dem;
		
	}

	@Override
	public int deleteAll(ArrayList<TheLoai> arrlist) {
		int dem=0;
		try {
			Connection con = JDBCUtil.getConnection();
			for(TheLoai theLoai: arrlist){
				String sql = "DELETE FROM theloai WHERE matheloai=?";
				PreparedStatement pr = con.prepareStatement(sql);
				pr.setString(1, theLoai.getMaTheLoai());	
				dem += pr.executeUpdate();
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Có "+ dem+" dòng bị thay đổi!");
		return dem;
		
	}

	@Override
	public int update(TheLoai t) {
		int dem=0;
		Connection con = JDBCUtil.getConnection();
		try {
			
			String sql = "UPDATE theloai SET matheloai=?, tentheloai=? WHERE matheloai=?";
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, t.getMaTheLoai());
			pr.setString(2, t.getTenTheLoai());
			pr.setString(3, t.getMaTheLoai());
			dem = pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Có "+ dem+" dòng bị thay đổi!");
		JDBCUtil.closeConnection(con);
		return dem;
		
	}
	public static void main(String[] arg) {
		TheLoaiDAO tld = new TheLoaiDAO();
//		TheLoai theLoai = new TheLoai("TCT", "Truyện cổ tích");
//		tld.insert(theLoai);
		ArrayList<TheLoai> list= tld.selectAll();
		for(TheLoai tl: list) {
			String row = "Mã thể loại: "+ tl.getMaTheLoai()+"\t Tên thể loại: "+ tl.getTenTheLoai();
			System.out.println(row);
		}
	}
	
	
}
