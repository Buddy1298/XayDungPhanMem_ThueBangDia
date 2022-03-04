package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PhieuDatTruoc_PK implements Serializable{
	private long khachHang;
	private long tieuDeDVD;
	public PhieuDatTruoc_PK() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (khachHang ^ (khachHang >>> 32));
		result = prime * result + (int) (tieuDeDVD ^ (tieuDeDVD >>> 32));
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
		PhieuDatTruoc_PK other = (PhieuDatTruoc_PK) obj;
		if (khachHang != other.khachHang)
			return false;
		if (tieuDeDVD != other.tieuDeDVD)
			return false;
		return true;
	}
	
	
	

}
