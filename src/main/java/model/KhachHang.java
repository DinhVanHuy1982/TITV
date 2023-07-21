	package model;

import java.sql.Date;
import java.util.Objects;

public class KhachHang {
	private String maKhachHang;
	private String tenDangNhap;
	private String matKhau;
	private String gioiTinh;
	private String hoVaTen;
	private String diaChi;
	private String diaChiNhanHang;
	private String diaChiMuaHang;
	public String getDiaChiMuaHang() {
		return diaChiMuaHang;
	}

	public void setDiaChiMuaHang(String diaChiMuaHang) {
		this.diaChiMuaHang = diaChiMuaHang;
	}

	private Date ngaySinh;
	private String soDienThoai;
	private String email;
	private boolean dangKiNBTEM;
	private String maXacThuc;
	private Date ThoiGianHieuLucMaXacThuc;
	private boolean TrangThaiXacThuc;
	private String DuongDanAnh;
	
	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String gioiTinh, String hoVaTen,
			String diaChi, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email,
			boolean dangKiNBTEM, String duongDanAnh) {
		
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.gioiTinh = gioiTinh;
		this.hoVaTen = hoVaTen;
		this.diaChi = diaChi;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKiNBTEM = dangKiNBTEM;
		DuongDanAnh = duongDanAnh;
	}

	public KhachHang() {
		
	}

	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String gioiTinh, String hoVaTen,
			String diaChi, String diaChiNhanHang, Date ngaySinh, String soDienThoai, String email, boolean dangKiNBTEM
			) {
		
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.gioiTinh = gioiTinh;
		this.hoVaTen = hoVaTen;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKiNBTEM = dangKiNBTEM;
		
		
	}
	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String gioiTinh, String hoVaTen,
			String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email,
			boolean dangKiNBTEM, String maXacThuc, Date thoiGianHieuLucMaXacThuc, boolean trangThaiXacThuc,
			String duongDanAnh) {
		
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.gioiTinh = gioiTinh;
		this.hoVaTen = hoVaTen;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKiNBTEM = dangKiNBTEM;
		this.maXacThuc = maXacThuc;
		this.ThoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
		this.TrangThaiXacThuc = trangThaiXacThuc;
		this.DuongDanAnh = duongDanAnh;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	/**
	 * @param maKhachHang the maKhachHang to set
	 */
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	/**
	 * @return the tenDangNhap
	 */
	public String getTenDangNhap() {
		return tenDangNhap;
	}

	/**
	 * @param tenDangNhap the tenDangNhap to set
	 */
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	/**
	 * @return the matKhau
	 */
	public String getMatKhau() {
		return matKhau;
	}

	/**
	 * @param matKhau the matKhau to set
	 */
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	/**
	 * @return the gioiTinh
	 */
	public String getGioiTinh() {
		return gioiTinh;
	}

	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	/**
	 * @return the hoVaTen
	 */
	public String getHoVaTen() {
		return hoVaTen;
	}

	/**
	 * @param hoVaTen the hoVaTen to set
	 */
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}

	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	/**
	 * @return the diaChiNhanHang
	 */
	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	/**
	 * @param diaChiNhanHang the diaChiNhanHang to set
	 */
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	/**
	 * @return the ngaySinh
	 */
	public Date getNgaySinh() {
		return ngaySinh;
	}

	/**
	 * @param ngaySinh the ngaySinh to set
	 */
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	/**
	 * @return the soDienThoai
	 */
	public String getSoDienThoai() {
		return soDienThoai;
	}

	/**
	 * @param soDienThoai the soDienThoai to set
	 */
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dangKiNBTEM
	 */
	public boolean isDangKiNBTEM() {
		return dangKiNBTEM;
	}

	/**
	 * @param dangKiNBTEM the dangKiNBTEM to set
	 */
	public void setDangKiNBTEM(boolean dangKiNBTEM) {
		this.dangKiNBTEM = dangKiNBTEM;
	}

	/**
	 * @return the maXacThuc
	 */
	public String getMaXacThuc() {
		return maXacThuc;
	}

	/**
	 * @param maXacThuc the maXacThuc to set
	 */
	public void setMaXacThuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}

	/**
	 * @return the thoiGianHieuLucMaXacThuc
	 */
	public Date getThoiGianHieuLucMaXacThuc() {
		return ThoiGianHieuLucMaXacThuc;
	}

	/**
	 * @param thoiGianHieuLucMaXacThuc the thoiGianHieuLucMaXacThuc to set
	 */
	public void setThoiGianHieuLucMaXacThuc(Date thoiGianHieuLucMaXacThuc) {
		ThoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
	}

	/**
	 * @return the trangThaiXacThuc
	 */
	public boolean getTrangThaiXacThuc() {
		return TrangThaiXacThuc;
	}

	/**
	 * @param trangThaiXacThuc the trangThaiXacThuc to set
	 */
	public void setTrangThaiXacThuc(boolean trangThaiXacThuc) {
		TrangThaiXacThuc = trangThaiXacThuc;
	}

	/**
	 * @return the duongDanAnh
	 */
	public String getDuongDanAnh() {
		return DuongDanAnh;
	}

	/**
	 * @param duongDanAnh the duongDanAnh to set
	 */
	public void setDuongDanAnh(String duongDanAnh) {
		DuongDanAnh = duongDanAnh;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DuongDanAnh, ThoiGianHieuLucMaXacThuc, TrangThaiXacThuc, dangKiNBTEM, diaChi, diaChiMuaHang,
				diaChiNhanHang, email, gioiTinh, hoVaTen, maKhachHang, maXacThuc, matKhau, ngaySinh, soDienThoai,
				tenDangNhap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(DuongDanAnh, other.DuongDanAnh)
				&& Objects.equals(ThoiGianHieuLucMaXacThuc, other.ThoiGianHieuLucMaXacThuc)
				&& TrangThaiXacThuc == other.TrangThaiXacThuc && dangKiNBTEM == other.dangKiNBTEM
				&& Objects.equals(diaChi, other.diaChi) && Objects.equals(diaChiMuaHang, other.diaChiMuaHang)
				&& Objects.equals(diaChiNhanHang, other.diaChiNhanHang) && Objects.equals(email, other.email)
				&& Objects.equals(gioiTinh, other.gioiTinh) && Objects.equals(hoVaTen, other.hoVaTen)
				&& Objects.equals(maKhachHang, other.maKhachHang) && Objects.equals(maXacThuc, other.maXacThuc)
				&& Objects.equals(matKhau, other.matKhau) && Objects.equals(ngaySinh, other.ngaySinh)
				&& Objects.equals(soDienThoai, other.soDienThoai) && Objects.equals(tenDangNhap, other.tenDangNhap);
	}
	
	
	
	
}
