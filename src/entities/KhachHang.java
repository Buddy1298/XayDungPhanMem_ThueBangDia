package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KhachHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long iDKH;
	private String ten;
	private String diaChi;
	private String sdt;
	private float phiTreHan;

	public KhachHang() {
		super();
	}
	public KhachHang(String ten, String diaChi, String sdt, float phiTreHan) {
		super();
		this.ten = ten;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.phiTreHan = phiTreHan;
	}
	public KhachHang(String ten, String diaChi, String sdt) {
		super();
		this.ten = ten;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}

	public KhachHang(long iDKH, String ten, String diaChi, String sdt) {
		super();
		this.iDKH = iDKH;
		this.ten = ten;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}

	public long getiDKH() {
		return iDKH;
	}

	public void setiDKH(long iDKH) {
		this.iDKH = iDKH;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	

	public float getphiTreHan() {
		return phiTreHan;
	}
	public void setphiTreHan(float phiTreHan) {
		this.phiTreHan = phiTreHan;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (iDKH ^ (iDKH >>> 32));
		return result;
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
		if (iDKH != other.iDKH)
			return false;
		return true;
	}

}
