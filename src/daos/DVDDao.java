package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.DVD;
import entities.MyEntityManager;
import entities.PhieuDatTruoc;
import entities.TieuDeDVD;

public class DVDDao {
	private EntityManager em ;
	public DVDDao() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	
	public void themDVD(DVD dvd) throws Exception {
		
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(dvd);
			tr.commit();
		}catch (Exception e) {
			tr.rollback();
		}
		
	}
	public List<DVD> getdsDVD() {
		return em.createQuery("select dvd from DVD dvd").getResultList();
	}
	
	public List<DVD> getdsDVDbyTieuDeDVD(long idTieuDe) {
		return em.createQuery("select dvd from DVD dvd where dvd.tieuDeDVD.iDTieuDe="+idTieuDe+"and dvd.trangThai=0").getResultList();
	}
	
	public void deleteDVDbyID(long DVDid) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			DVD dvd = em.find(DVD.class, DVDid);
			em.remove(dvd);
			tr.commit();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
	}
	public DVD getDVDByID(long id) {
		return em.find(DVD.class, id);
	}
	public void updateDVD(DVD dvd) throws Exception {

		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(dvd);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}

	}

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
	
	// vu begin 12/8
		public List<DVD> getdsDVDDangThuebyTieuDeDVD(long idTieuDe) {
			return em
					.createQuery("select dvd from DVD dvd where dvd.tieuDeDVD.iDTieuDe=" + idTieuDe + "and dvd.trangThai=1")
					.getResultList();
		}

		public List<DVD> getdsDVDDangDatbyTieuDeDVD(long idTieuDe) {
			return em
					.createQuery("select dvd from DVD dvd where dvd.tieuDeDVD.iDTieuDe=" + idTieuDe + "and dvd.trangThai=2")
					.getResultList();
		}

		// vu end 12/8
	
	
	
	
	
}
