package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.KhachHang;
import entities.MyEntityManager;

public class KhachHangDao {
private EntityManager em ;
	
	public KhachHangDao() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	
	public void themKhachHang(KhachHang kh) throws Exception {
		
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(kh);
			tr.commit();
			em.clear();
		}catch (Exception e) {
			tr.rollback();
		}
		
	}
	public List<KhachHang> getdsKhachHang() {
		return em.createQuery("select kh from KhachHang kh").getResultList();
	}
	
	public KhachHang getKhbangSdt(String sdt) {
		return (KhachHang) em.createQuery("select kh from KhachHang kh where kh.sdt='"+sdt+"'  ").getResultList().get(0);
	}
	public KhachHang getKhbyTen(String ten) {
		return (KhachHang) em.createQuery("select kh from KhachHang kh where kh.ten='"+ten+"'  ").getResultList().get(0);
	}
	public KhachHang getKhbyId(long id) {
		KhachHang khachHang = em.find(KhachHang.class, id);
		return khachHang;
	}
	
	public void capnhatKhachHang(KhachHang kh) throws Exception {
		
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(kh);
			tr.commit();
			em.clear();
		}catch (Exception e) {
			tr.rollback();
			throw new Exception(e);
		}
		
	}
	
	public void xoaKhachHang(long id) {
		  KhachHang khachHang = em.find(KhachHang.class, id);
		  em.getTransaction().begin();
		  em.remove(khachHang);
		  em.getTransaction().commit();
		  em.clear();
	}
	
	public List<KhachHang> getdsKHDangThuebyTieuDeDVD(long idTieuDe) {
		return em.createQuery("select kh from KhachHang kh where kh.PhieuDatTruoc.TieuDeDVD.iDTieuDe=" + idTieuDe
				+ "and dvd.trangThai=1").getResultList();
	}



}
