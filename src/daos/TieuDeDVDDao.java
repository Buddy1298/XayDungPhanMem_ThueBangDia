package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.DVD;
import entities.MyEntityManager;
import entities.TieuDeDVD;

public class TieuDeDVDDao {
	private EntityManager em ;
	public TieuDeDVDDao() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	
	public void themTieuDeDVD(TieuDeDVD tieuDeDVD) throws Exception {
		
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(tieuDeDVD);
			tr.commit();
		}catch (Exception e) {
			tr.rollback();
		}
		
	}
	public TieuDeDVD getTieuDeDVDbyId(long id) {
		TieuDeDVD tieuDeDVD = em.find(TieuDeDVD.class, id);
		return tieuDeDVD;
	}
	
	public List<TieuDeDVD> getdsTieuDeDVD() {
		return em.createQuery("select tdvd from TieuDeDVD tdvd").getResultList();
	}
	public TieuDeDVD getTieuDeDVDByName(String name) {
		TieuDeDVD tieuDeDVD=null;
		tieuDeDVD= (TieuDeDVD) em.createQuery("select tieude from TieuDeDVD tieude where tieude.tenTieuDe='"+name+"'  ").getResultList().get(0);
		return tieuDeDVD;
	}
	public void updateTieuDeDVD(TieuDeDVD tieuDeDVD) {
	EntityTransaction tr= em.getTransaction();
	try {
		tr.begin();
		TieuDeDVD tieude= em.find(TieuDeDVD.class, tieuDeDVD.getiDTieuDe());
		tieude.setTenTieuDe(tieuDeDVD.getTenTieuDe());
		tieude.setLoaiDVD(tieuDeDVD.getLoaiDVD());
		tr.commit();
	}
	catch(Exception e){
			tr.rollback();
			e.printStackTrace();
		}
	}

}
