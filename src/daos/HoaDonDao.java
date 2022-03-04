package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.CTHD;
import entities.HoaDon;
import entities.MyEntityManager;

public class HoaDonDao {
	private EntityManager em;

	public HoaDonDao() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	public boolean themHoaDon(HoaDon hd) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(hd);
			tr.commit();
//			em.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}

	public boolean themCTHD(CTHD cthd) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(cthd);
			tr.commit();
//			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}

}
