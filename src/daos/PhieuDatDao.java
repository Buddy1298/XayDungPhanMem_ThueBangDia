package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.DVD;
import entities.MyEntityManager;
import entities.PhieuDatTruoc;

public class PhieuDatDao {
	private EntityManager em ;
	public PhieuDatDao() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	
	public void themPhieuDatTruoc (PhieuDatTruoc p) {
		EntityTransaction tr= em.getTransaction();
		tr.begin();
		em.persist(p);
		tr.commit();
		em.clear();
		
	}
	public List<PhieuDatTruoc> getdPhieuDatByTieuDeDVD(long idTieuDe) {
		return em.createQuery("select pdt from PhieuDatTruoc pdt where pdt.tieuDeDVD.iDTieuDe="+idTieuDe+" and pdt.trangThai=false order by pdt.thoiGianDat ASC " ).getResultList();
	}
	public void capNhatTrangThaiPhieuDat(PhieuDatTruoc pt) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		em.merge(pt);
		tr.commit();
		em.clear();
	}
	public List<PhieuDatTruoc> getDsPhieuDatTruoc(){
		return em.createQuery("From PhieuDatTruoc").getResultList();
	}
	@SuppressWarnings("unchecked")
	public int ktraDatTruoc(long idTieuDe) {
		List<PhieuDatTruoc> listpd = em.createQuery("select pdt from PhieuDatTruoc pdt").getResultList();
		int n = 0;
		for(PhieuDatTruoc pd : listpd) {
			if(pd.getTieuDeDVD().getiDTieuDe()==idTieuDe) {
				n++;
			}
		}
		if(n==0) {
			return 0;
		} else {
			return 1;
		}	
	}
	public void huyPhieuDat(long idtieude,long idKh) {	
		em.getTransaction().begin();
		em.createQuery("delete from PhieuDatTruoc where iDTieuDe="+idtieude+" and iDKH="+idKh).executeUpdate();
		em.getTransaction().commit();	
		em.clear();
	}
	public void huyChoChoDiaDVD(long idTieuDe){		
		EntityTransaction tr = em.getTransaction();		
		tr.begin();
		em.createQuery("update DVD set trangThai=0 where trangThai=2 and iDTieuDe="+idTieuDe).executeUpdate();
		tr.commit();
		em.clear();
	}
	
	

}
