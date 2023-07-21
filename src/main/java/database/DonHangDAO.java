package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DAOInterface.DAOInterface;
import model.DonHang;
import model.KhachHang;

public class DonHangDAO implements DAOInterface<DonHang>{
	@Override
	public ArrayList<DonHang> selectAll() {
		ArrayList<DonHang> data= new ArrayList<DonHang>();
		Connection con = JDBCUtil.getConnection();
		try {
			String sql = "SELECT * FROM donhang";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				
				String madonhang = rs.getString("madonhang");
				String makhachhang = rs.getString("makhachhang");
				String diachinguoimua = rs.getString("diachinguoimua");
				String diachinguoinhan = rs.getString("diachinguoinhan");
				String trangthai = rs.getString("trangthai");
				String thanhtoan = rs.getString("thanhtoan");
				String trangthaithanhtoan = rs.getString("trangthaithanhtoan");
				Double tienthanhtoan = rs.getDouble("tienthanhtoan");
				Double tienthieu = rs.getDouble("tienthieu");
				Date ngaydathang = rs.getDate("ngaydathang");
				Date ngaygiaohang = rs.getDate("ngaygiaohang");
				
				
				
				KhachHang kh = new KhachHang(makhachhang, null, null, null, null, null, null, null, null, null, false);
				KhachHang khachHang = new KhachHangDAO().selectByID(kh);
				
				DonHang donHang = new DonHang(madonhang, khachHang, diachinguoimua, diachinguoinhan, trangthai, thanhtoan, trangthaithanhtoan, tienthanhtoan, tienthieu, ngaydathang, ngaygiaohang); 
				data.add(donHang);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		JDBCUtil.closeConnection(con);
		return data;
	}

	@Override
	public DonHang selectByID(DonHang t) {
		DonHang data= new DonHang();
		Connection con = JDBCUtil.getConnection();
		try {
			String sql = "SELECT * FROM sanpham WHERE madonhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String madonhang = rs.getString("madonhang");
				String makhachhang = rs.getString("makhachhang");
				String diachinguoimua = rs.getString("diachinguoimua");
				String diachinguoinhan = rs.getString("diachinguoinhan");
				String trangthai = rs.getString("trangthai");
				String thanhtoan = rs.getString("thanhtoan");
				String trangthaithanhtoan = rs.getString("trangthaithanhtoan");
				Double tienthanhtoan = rs.getDouble("tienthanhtoan");
				Double tienthieu = rs.getDouble("tienthieu");
				Date ngaydathang = rs.getDate("ngaydathang");
				Date ngaygiaohang = rs.getDate("ngaygiaohang");
				
				
				
				KhachHang kh = new KhachHang(makhachhang, null, null, null, null, null, null, null, null, null, false);
				KhachHang khachHang = new KhachHangDAO().selectByID(kh);
				
				DonHang donHang = new DonHang(madonhang, khachHang, diachinguoimua, diachinguoinhan, trangthai, thanhtoan, trangthaithanhtoan, tienthanhtoan, tienthieu, ngaydathang, ngaygiaohang); 
				data=donHang;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		JDBCUtil.closeConnection(con);
		return data;
		
	}

	@Override
	public int insert(DonHang t) {
		int dem=0;
		Connection con = JDBCUtil.getConnection();
		try {
			String sql = "INSERT INTO donhang(madonhang, makhachhang, diachinguoimua, diachinguoinhan, "
					+ "trangthai, thanhtoan, trangthaithanhtoan, tienthanhtoan, "
					+ "tienthieu, ngaydathang, ngaygiaohang)"
					+ " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getMaDonHang());
			st.setString(2,t.getKhachHang().getMaKhachHang());
			st.setString(3,t.getdiaChiNguoiMua());
			st.setString(4,t.getdiaChiNguoiNhan());
			st.setString(5,t.getTrangThai());
			st.setString(6,t.getHinhThucThanhToan());
			st.setString(7,t.getTrangThaiThanhToan());
			st.setDouble(8,t.getSoTienThanhToan());
			st.setDouble(9,t.getSoTienConThieu());
			st.setDate(10,t.getNgayDatHang());
			st.setDate(11,t.getNgayGiaoHang());

			dem = st.executeUpdate();
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Có "+dem+" dòng bị thay đổi!");
		JDBCUtil.closeConnection(con);
		return dem;
		
	}

	@Override
	public int insertAll(ArrayList<DonHang> arrlist) {
		Connection con = JDBCUtil.getConnection();
		int dem=0;
		try {
			
			
			for(DonHang t: arrlist){
				String sql = "INSERT INTO donhang(madonhang, makhachhang, diachinguoimua, diachinguoinhan, "
						+ "trangthai, thanhtoan, trangthaithanhtoan, tienthanhtoan, "
						+ "tienthieu, ngaydathang, ngaygiaohang)"
						+ " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,t.getMaDonHang());
				st.setString(2,t.getKhachHang().getMaKhachHang());
				st.setString(3,t.getdiaChiNguoiMua());
				st.setString(4,t.getdiaChiNguoiNhan());
				st.setString(5,t.getTrangThai());
				st.setString(6,t.getHinhThucThanhToan());
				st.setString(7,t.getTrangThaiThanhToan());
				st.setDouble(8,t.getSoTienThanhToan());
				st.setDouble(9,t.getSoTienConThieu());
				st.setDate(10,t.getNgayDatHang());
				st.setDate(11,t.getNgayGiaoHang());

				dem += st.executeUpdate();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Có "+dem+" dòng bị thay đổi!");
		JDBCUtil.closeConnection(con);
		return dem;
		
	}

	@Override
	public int delete(DonHang t) {
		int dem=0;
		Connection con = JDBCUtil.getConnection();
		try {
			String sql = "DELETE FROM donhang WHERE madonhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getMaDonHang());

			dem = st.executeUpdate();
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Có "+dem+" dòng bị thay đổi!");
		JDBCUtil.closeConnection(con);
		return dem;
		
		
	}

	@Override
	public int deleteAll(ArrayList<DonHang> arrlist) {
		Connection con = JDBCUtil.getConnection();
		int dem=0;
		try {
			
			
			for(DonHang t: arrlist){
				String sql =  "DELETE FROM donhang WHERE madonhang=?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,t.getMaDonHang());
				
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
	public int update(DonHang t) {
		Connection con = JDBCUtil.getConnection();
		int dem=0;
		try {
			String sql =  "UPDATE sanpham SET masanpham=?, tensanpham=?, matacgia=?, namxuatban=?, "
					+ "gianhap=?, giagoc=?, giaban=?, soluong=?, "
					+ "matheloai=?, ngonngu=?, mota=?  WHERE masanpham=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getMaDonHang());
			st.setString(2,t.getKhachHang().getMaKhachHang());
			st.setString(3,t.getdiaChiNguoiMua());
			st.setString(4,t.getdiaChiNguoiNhan());
			st.setString(5,t.getTrangThai());
			st.setString(6,t.getHinhThucThanhToan());
			st.setString(7,t.getTrangThaiThanhToan());
			st.setDouble(8,t.getSoTienThanhToan());
			st.setDouble(9,t.getSoTienConThieu());
			st.setDate(10,t.getNgayDatHang());
			st.setDate(11,t.getNgayGiaoHang());
			st.setString(12,t.getMaDonHang());
			dem+= st.executeUpdate();
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Có "+dem+" dòng bị thay đổi!");
		JDBCUtil.closeConnection(con);
		return dem;
		
	}
	public static void main(String[] args) {
		DonHangDAO shd = new DonHangDAO();
		KhachHang KhachHang_new = new KhachHang("KH6", "Anhhuyditu00.", "Anhhuyditu00.", "nam", "Đinh Văn Huy", "Thanh Hóa", null, null, null, null, false);
		DonHang DonHang = new DonHang("DH1", KhachHang_new, null, null, null, null, null, 0, 0, null, null);
		shd.insert(DonHang);
		ArrayList<DonHang> list= new ArrayList<>();
		list = shd.selectAll();
		for(DonHang s: list) {
			String row="Mã đơn hàng: "+s.getMaDonHang();
			System.out.println(row);
		}
		
	}
	
	
}
