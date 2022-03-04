package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.KhachHang;
import entities.MyEntityManager;
import entities.PhieuGhiNhanThanhToanPhiTreHan;


public class PhieuGhiNhanThanhToanDao {
	private EntityManager em ;
	public PhieuGhiNhanThanhToanDao() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	public void themPhieuGhiNhanThanhToan(PhieuGhiNhanThanhToanPhiTreHan pgn) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		em.persist(pgn);
		tr.commit();
		em.clear();
	}
	
	public List<PhieuGhiNhanThanhToanPhiTreHan> getPhieuGhiNhanMoiNhat(long idKH) {
		return em.createQuery("from PhieuGhiNhanThanhToanPhiTreHan where iDKH="+idKH+"order by ngayThanhToan DESC ",PhieuGhiNhanThanhToanPhiTreHan.class).getResultList();
	}
	public List<PhieuGhiNhanThanhToanPhiTreHan> getDSPhieuGhiNhan(long idKH) {
		return em.createQuery("select pth from PhieuGhiNhanThanhToanPhiTreHan pth where pth.khachHang.iDKH="+idKH).getResultList();
	}
	public void xoaLichSuThanhToan(long idKH) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		em.createQuery("delete from PhieuGhiNhanThanhToanPhiTreHan where iDKH="+idKH).executeUpdate();
		tr.commit();
		em.clear();
	}
}
