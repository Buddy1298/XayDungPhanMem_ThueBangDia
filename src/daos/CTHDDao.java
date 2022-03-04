package daos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import entities.CTHD;
import entities.MyEntityManager;

public class CTHDDao {
	private EntityManager em ;
	public CTHDDao() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	
	public List<CTHD> getdsCTHD() {
		return em.createQuery("select cthd from CTHD cthd").getResultList();
	}
	
	public CTHD getCTHDthoiGianThueGanNhat(long idDVD) {
		LocalDate date=LocalDate.of(2020, 11, 25);
		List<CTHD> lisCthds= em.createQuery("select cthd from CTHD cthd where cthd.dVD.iDDVD="+idDVD+"  ORDER BY cthd.hoaDon.iDHD DESC ").getResultList();
		 return lisCthds.get(0);
	}

}
