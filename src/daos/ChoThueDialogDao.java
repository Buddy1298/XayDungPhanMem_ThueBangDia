package daos;

import java.util.List;

import javax.persistence.EntityManager;

import entities.DVD;
import entities.MyEntityManager;

public class ChoThueDialogDao {
	private EntityManager em;

	public ChoThueDialogDao() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	public List<String> getAllLoaiDia() {
		return em.createQuery("select tenLoai from LoaiDVD", String.class).getResultList();
	}

	public List<String> getTenTieuDeTheoLoai(int iDLoai) {
		return em.createQuery("select iDDVD,tenTieuDe from TieuDeDVD where iDLoai=" + iDLoai, String.class)
				.getResultList();
	}

	public List<DVD> getAllDVD() {
		return em.createQuery("from DVD", DVD.class).getResultList();
	}
	
	public List<DVD> getDVDsByTrangThaiSanSangChoThue(){
		return em.createQuery("from DVD where trangThai=0", DVD.class).getResultList();
	}

	public DVD getDVDById(long id) {
		return em.find(DVD.class, id);
	}

}
