package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoaiDVD {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long iDLoai;
	private String tenLoai;
	private double giaThue;
	private int thoiGianThue; // tinh theo ngay

	public LoaiDVD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiDVD(long iDLoai, String tenLoai, double giaThue, int thoiGianThue) {
		super();
		this.iDLoai = iDLoai;
		this.tenLoai = tenLoai;
		this.giaThue = giaThue;
		this.thoiGianThue = thoiGianThue;
	}

	public long getiDLoai() {
		return iDLoai;
	}

	public void setiDLoai(long iDLoai) {
		this.iDLoai = iDLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public double getGiaThue() {
		return giaThue;
	}

	public void setGiaThue(double giaThue) {
		this.giaThue = giaThue;
	}

	public int getThoiGianThue() {
		return thoiGianThue;
	}

	public void setThoiGianThue(int thoiGianThue) {
		this.thoiGianThue = thoiGianThue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (iDLoai ^ (iDLoai >>> 32));
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
		LoaiDVD other = (LoaiDVD) obj;
		if (iDLoai != other.iDLoai)
			return false;
		return true;
	}

}
