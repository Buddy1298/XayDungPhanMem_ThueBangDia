package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(PhieuDatTruoc_PK.class)
public class PhieuDatTruoc {
	@Id
	@ManyToOne
	@JoinColumn(name = "iDKH")
	KhachHang khachHang;
	@Id
	@ManyToOne
	@JoinColumn(name = "iDTieuDe")
	TieuDeDVD tieuDeDVD;
	private boolean trangThai;
	private LocalDateTime thoiGianDat;
	public PhieuDatTruoc() {
		super();
	}
	
	public PhieuDatTruoc(KhachHang khachHang, TieuDeDVD tieuDeDVD, boolean trangThai, LocalDateTime thoiGianDat) {
		super();
		this.khachHang = khachHang;
		this.tieuDeDVD = tieuDeDVD;
		this.trangThai = trangThai;
		this.thoiGianDat = thoiGianDat;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public TieuDeDVD getTieuDeDVD() {
		return tieuDeDVD;
	}
	public void setTieuDeDVD(TieuDeDVD tieuDeDVD) {
		this.tieuDeDVD = tieuDeDVD;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public LocalDateTime getThoiGianDat() {
		return thoiGianDat;
	}
	public void setThoiGianDat(LocalDateTime thoiGianDat) {
		this.thoiGianDat = thoiGianDat;
	}

	

}
