package daos;

import java.util.List;

import javax.persistence.EntityManager;

import entities.MyEntityManager;
import entities.TaiKhoan;

public class TaiKhoanDao {
	private EntityManager em;
	public TaiKhoanDao() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	public TaiKhoan kiemTra(String tenTK) {
		List<TaiKhoan> list = em.createQuery("select tk from TaiKhoan tk where tk.taiKhoan='"+tenTK+"'").getResultList();
		return list.get(0);
	}
}
