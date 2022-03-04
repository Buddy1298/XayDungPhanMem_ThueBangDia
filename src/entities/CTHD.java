package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(CTHD_PK.class)
public class CTHD  implements Serializable{
	@Id
	@ManyToOne
	@JoinColumn(name = "iDHD")
	private HoaDon hoaDon;
	@Id
	@ManyToOne
	@JoinColumn(name = "iDDVD")
	private DVD dVD;
	private int thoiGianThue;
	public CTHD() {
		super();
	}
	public CTHD(HoaDon hoaDon, DVD dVD, int thoiGianThue) {
		super();
		this.hoaDon = hoaDon;
		this.dVD = dVD;
		this.thoiGianThue = thoiGianThue;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public DVD getdVD() {
		return dVD;
	}
	public void setdVD(DVD dVD) {
		this.dVD = dVD;
	}
	public int getThoiGianThue() {
		return thoiGianThue;
	}
	public void setThoiGianThue(int thoiGianThue) {
		this.thoiGianThue = thoiGianThue;
	}
	

}
