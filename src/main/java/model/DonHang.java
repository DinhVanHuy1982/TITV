package model;

import java.sql.Date;
import java.util.Objects;

public class DonHang {
	private String maDonHang;
	private KhachHang khachHang;
	private String diaChiNguoiMua;
	private String diaChiNguoiNhan;
	private String trangThai;
	private String hinhThucThanhToan;
	private String trangThaiThanhToan;
	private double soTienThanhToan;
	private double soTienConThieu;
	private Date ngayDatHang;
	private Date ngayGiaoHang;
	public DonHang() {
		
	}
	public DonHang(String maDonHang, KhachHang khachHang, String diaChiNguoiMua, String diaChiNguoiNhan, String trangThai,
			String hinhThucThanhToan, String trangThaiThanhToan, double soTienThanhToan, double soTienConThieu,
			Date ngayDatHangl, Date ngayGiaoHang) {
		super();
		this.maDonHang = maDonHang;
		this.khachHang = khachHang;
		this.diaChiNguoiMua = diaChiNguoiMua;
		this.diaChiNguoiNhan = diaChiNguoiNhan;
		this.trangThai = trangThai;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.soTienThanhToan = soTienThanhToan;
		this.soTienConThieu = soTienConThieu;
		this.ngayDatHang = ngayDatHangl;
		this.ngayGiaoHang = ngayGiaoHang;
	}
	public String getMaDonHang() {
		return maDonHang;
	}
	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public String getdiaChiNguoiMua() {
		return diaChiNguoiMua;
	}
	public void setdiaChiNguoiMua(String diaChiNguoiMua) {
		this.diaChiNguoiMua = diaChiNguoiMua;
	}
	public String getdiaChiNguoiNhan() {
		return diaChiNguoiNhan;
	}
	public void setdiaChiNguoiNhan(String diaChiNguoiNhan) {
		this.diaChiNguoiNhan = diaChiNguoiNhan;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	public String getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}
	public void setTrangThaiThanhToan(String trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}
	public double getSoTienThanhToan() {
		return soTienThanhToan;
	}
	public void setSoTienThanhToan(double soTienThanhToan) {
		this.soTienThanhToan = soTienThanhToan;
	}
	public double getSoTienConThieu() {
		return soTienConThieu;
	}
	public void setSoTienConThieu(double soTienConThieu) {
		this.soTienConThieu = soTienConThieu;
	}
	public Date getNgayDatHang() {
		return ngayDatHang;
	}
	public void setNgayDatHang(Date ngayDatHangl) {
		this.ngayDatHang = ngayDatHangl;
	}
	public Date getNgayGiaoHang() {
		return ngayGiaoHang;
	}
	public void setNgayGiaoHang(Date ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}
	@Override
	public int hashCode() {
		return Objects.hash(diaChiNguoiMua, diaChiNguoiNhan, hinhThucThanhToan, khachHang, maDonHang, ngayDatHang,
				ngayGiaoHang, soTienConThieu, soTienThanhToan, trangThai, trangThaiThanhToan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonHang other = (DonHang) obj;
		return Objects.equals(diaChiNguoiMua, other.diaChiNguoiMua) && Objects.equals(diaChiNguoiNhan, other.diaChiNguoiNhan)
				&& Objects.equals(hinhThucThanhToan, other.hinhThucThanhToan)
				&& Objects.equals(khachHang, other.khachHang) && Objects.equals(maDonHang, other.maDonHang)
				&& Objects.equals(ngayDatHang, other.ngayDatHang) && Objects.equals(ngayGiaoHang, other.ngayGiaoHang)
				&& Double.doubleToLongBits(soTienConThieu) == Double.doubleToLongBits(other.soTienConThieu)
				&& Double.doubleToLongBits(soTienThanhToan) == Double.doubleToLongBits(other.soTienThanhToan)
				&& Objects.equals(trangThai, other.trangThai)
				&& Objects.equals(trangThaiThanhToan, other.trangThaiThanhToan);
	}
	
	
}
