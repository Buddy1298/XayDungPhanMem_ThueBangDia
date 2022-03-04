package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class TieuDeDVD {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long iDTieuDe;
	private String tenTieuDe;
	@ManyToOne
	@JoinColumn(name = "iDLoai")
	private LoaiDVD loaiDVD;
	public TieuDeDVD() {
		super();
	}
	
	public TieuDeDVD(String tenTieuDe, LoaiDVD loaiDVD) {
		super();
		this.tenTieuDe = tenTieuDe;
		this.loaiDVD = loaiDVD;
	}

	public TieuDeDVD(long iDTieuDe, String tenTieuDe, LoaiDVD loaiDVD) {
		super();
		this.iDTieuDe = iDTieuDe;
		this.tenTieuDe = tenTieuDe;
		this.loaiDVD = loaiDVD;
	}
	public long getiDTieuDe() {
		return iDTieuDe;
	}
	public void setiDTieuDe(long iDTieuDe) {
		this.iDTieuDe = iDTieuDe;
	}
	public String getTenTieuDe() {
		return tenTieuDe;
	}
	public void setTenTieuDe(String tenTieuDe) {
		this.tenTieuDe = tenTieuDe;
	}
	public LoaiDVD getLoaiDVD() {
		return loaiDVD;
	}
	public void setLoaiDVD(LoaiDVD loaiDVD) {
		this.loaiDVD = loaiDVD;
	}
	
	
	
	

}
