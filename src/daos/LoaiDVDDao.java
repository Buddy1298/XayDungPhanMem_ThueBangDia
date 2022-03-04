package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.LoaiDVD;
import entities.MyEntityManager;

public class LoaiDVDDao {
	private EntityManager em;
	public LoaiDVDDao() {
		em= MyEntityManager.getInstance().getEntityManager();
	}
	
	public List<LoaiDVD> getDsLoaiDVD (){
		return em.createQuery("select ldvd from LoaiDVD ldvd").getResultList();
	}
	
	public LoaiDVD getLoaiDVDbyTenLoai(String tenLoai) {
		return (LoaiDVD) em.createQuery("select ldvd from LoaiDVD ldvd where ldvd.tenLoai='" + tenLoai + "'  ")
				.getResultList().get(0);
	}

	public void capnhatLoaiDVD(LoaiDVD ldvd) throws Exception {

		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(ldvd);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			throw new Exception(e);
		}

	}
}

