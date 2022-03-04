package entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.swing.text.StyledEditorKit.BoldAction;

@Entity
public class DVD {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long iDDVD;
	@ManyToOne
    @JoinColumn(name = "iDTieuDe")
	private TieuDeDVD tieuDeDVD;
	private int trangThai;
	public static final int SAN_CHO_THUE = 0;
	public static final int DA_THUE=1;
	public static final int DA_DAT_TRUOC = 2; 
	public static final int DA_HU_HONG = 3; 
	public DVD() {
		super();
	}
	public DVD(long iDDVD, TieuDeDVD tieuDeDVD, int trangThai) {
		super();
		this.iDDVD = iDDVD;
		this.tieuDeDVD = tieuDeDVD;
		this.trangThai = trangThai;
	}
	
	public DVD(TieuDeDVD tieuDeDVD, int trangThai) {
		super();
		this.tieuDeDVD = tieuDeDVD;
		this.trangThai = trangThai;
	}
	public long getiDDVD() {
		return iDDVD;
	}
	public void setiDDVD(long iDDVD) {
		this.iDDVD = iDDVD;
	}
	public TieuDeDVD getTieuDeDVD() {
		return tieuDeDVD;
	}
	public void setTieuDeDVD(TieuDeDVD tieuDeDVD) {
		this.tieuDeDVD = tieuDeDVD;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	
	
	
	

}
