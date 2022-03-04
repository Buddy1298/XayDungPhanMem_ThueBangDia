package entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PhieuGhiNhanThanhToanPhiTreHan
 *
 */
@Entity
public class PhieuGhiNhanThanhToanPhiTreHan implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maPhieu;
	@ManyToOne
	@JoinColumn(name = "iDKH")
	private KhachHang khachHang;
	private LocalDateTime ngayThanhToan;
	private float soTienTra;
	private float soDuNo;
	private static final long serialVersionUID = 1L;

	public PhieuGhiNhanThanhToanPhiTreHan() {
		super();
	}

	public PhieuGhiNhanThanhToanPhiTreHan(KhachHang khachHang, LocalDateTime ngayThanhToan,float soDuNo,float soTienTra) {
		super();
		this.khachHang = khachHang;
		this.ngayThanhToan = ngayThanhToan;
		this.soDuNo = soDuNo;
		this.soTienTra = soTienTra;
		
	}

	public int getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(int maPhieu) {
		this.maPhieu = maPhieu;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public LocalDateTime getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(LocalDateTime ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public float getSoTienTra() {
		return soTienTra;
	}

	public void setSoTienTra(float soTienTra) {
		this.soTienTra = soTienTra;
	}

	public float getSoDuNo() {
		return soDuNo;
	}

	public void setSoDuNo(float soDuNo) {
		this.soDuNo = soDuNo;
	}	   
}
