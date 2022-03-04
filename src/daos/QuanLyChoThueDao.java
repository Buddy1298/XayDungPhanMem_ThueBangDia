package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.CTHD;
import entities.HoaDon;
import entities.KhachHang;
import entities.MyEntityManager;

public class QuanLyChoThueDao {
	private EntityManager em;

	public QuanLyChoThueDao() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	public List<HoaDon> getAllHoaDon() {
		return em.createQuery("select hd from HoaDon hd", HoaDon.class).getResultList();
	}

	public List<CTHD> getAllChiTietHoaDon() {
		return em.createQuery("select ct from CTHD ct", CTHD.class).getResultList();
	}

	public List<HoaDon> getHoaDonsByIDKH(long id) {
		return em.createQuery("select ct from HoaDon ct where idKH=" + id, HoaDon.class).getResultList();
	}

	public List<CTHD> getChiTietHoaDonsByIDHD(long id) {
		return em.createQuery("select ct from CTHD ct where iDHD=" + id, CTHD.class).getResultList();
	}

	public KhachHang layThongTinKhachHang(long id) {
		return em.find(KhachHang.class, id);
	}

	public CTHD getCTHDByIdDVD(long id) {
		return em.createQuery("select ct from CTHD ct where iDDVD=" + id, CTHD.class).getSingleResult();
	}

	public List<CTHD> getChiTietHoaDonsByIDDVD(long id) {
		return em.createQuery("select ct from CTHD ct where iDDVD=" + id, CTHD.class).getResultList();
	}
	
	public List<CTHD> getChiTietHoaDonsByIDDVDOrderByNgay(long id) {
		return em.createQuery("select ct from CTHD ct where ct.dVD.iDDVD=" + id+" order by ct.hoaDon.iDHD DESC", CTHD.class).getResultList();
//		return em.createQuery("select ct,HD from CTHD ct, HoaDon HD WHERE ct.iDDVD="+id+" order by HD.iDHD desc", CTHD.class).getResultList();
	}

	public boolean updateCTHD(CTHD cthd) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(cthd);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}

	}

}
