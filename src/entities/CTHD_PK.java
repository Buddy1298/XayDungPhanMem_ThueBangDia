package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CTHD_PK implements Serializable {
	private long hoaDon;
	private long dVD;

	public CTHD_PK() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (dVD ^ (dVD >>> 32));
		result = prime * result + (int) (hoaDon ^ (hoaDon >>> 32));
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
		CTHD_PK other = (CTHD_PK) obj;
		if (dVD != other.dVD)
			return false;
		if (hoaDon != other.hoaDon)
			return false;
		return true;
	}

	
}
