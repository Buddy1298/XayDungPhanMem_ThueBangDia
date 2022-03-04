package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long iDHD;
	private LocalDate ngayThue;
	@ManyToOne
	@JoinColumn(name = "iDKH")
	private KhachHang khachHang;
	public HoaDon() {
		super();
	}
	
	public HoaDon(LocalDate ngayThue, KhachHang khachHang) {
		super();
		this.ngayThue = ngayThue;
		this.khachHang = khachHang;
	}

	public HoaDon(long iDHD, LocalDate ngayThue, KhachHang khachHang) {
		super();
		this.iDHD = iDHD;
		this.ngayThue = ngayThue;
		this.khachHang = khachHang;
	}
	public long getiDHD() {
		return iDHD;
	}
	public void setiDHD(long iDHD) {
		this.iDHD = iDHD;
	}
	public LocalDate getNgayThue() {
		return ngayThue;
	}
	public void setNgayThue(LocalDate ngayThue) {
		this.ngayThue = ngayThue;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	
	
	
	

}
