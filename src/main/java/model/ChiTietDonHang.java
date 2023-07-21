package model;

import java.util.Objects;

public class ChiTietDonHang {
	private String maChiTietDonHang;
	private DonHang donHang;
	private Sach sach;
	private int soLuong;
	private double giaBia;
	private double giamGia;
	private double giaBan;
	private double thueVAT;
	private double tongTien;
	public ChiTietDonHang(String maChiTietDonHang, DonHang donHang, Sach Sach, int soLuong, double giaBia,
			double giamGia, double giaBan, double thueVAT, double tongTien) {
		
		this.maChiTietDonHang = maChiTietDonHang;
		this.donHang = donHang;
		this.sach = Sach;
		this.soLuong = soLuong;
		this.giaBia = giaBia;
		this.giamGia = giamGia;
		this.giaBan = giaBan;
		this.thueVAT = thueVAT;
		this.tongTien = tongTien;
	}
	public ChiTietDonHang() {
		
	}
	public String getMaChiTietDonHang() {
		return maChiTietDonHang;
	}
	public void setMaChiTietDonHang(String maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}
	public DonHang getDonHang() {
		return donHang;
	}
	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}
	public Sach getSach() {
		return sach;
	}
	public void setMaSach(Sach maSach) {
		this.sach = maSach;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGiaBia() {
		return giaBia;
	}
	public void setGiaBia(double giaBia) {
		this.giaBia = giaBia;
	}
	public double getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public double getThueVAT() {
		return thueVAT;
	}
	public void setThueVAT(double thueVAT) {
		this.thueVAT = thueVAT;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(donHang, giaBan, giaBia, giamGia, maChiTietDonHang, sach, soLuong, thueVAT, tongTien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDonHang other = (ChiTietDonHang) obj;
		return Objects.equals(donHang, other.donHang)
				&& Double.doubleToLongBits(giaBan) == Double.doubleToLongBits(other.giaBan)
				&& Double.doubleToLongBits(giaBia) == Double.doubleToLongBits(other.giaBia)
				&& Double.doubleToLongBits(giamGia) == Double.doubleToLongBits(other.giamGia)
				&& Objects.equals(maChiTietDonHang, other.maChiTietDonHang) && Objects.equals(sach, other.sach)
				&& soLuong == other.soLuong
				&& Double.doubleToLongBits(thueVAT) == Double.doubleToLongBits(other.thueVAT)
				&& Double.doubleToLongBits(tongTien) == Double.doubleToLongBits(other.tongTien);
	}
	
	
}
