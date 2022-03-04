package entities;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MyEntityManager {
	
	private static MyEntityManager instance;
	
	private EntityManager entityManager;
	
	private MyEntityManager() {
		entityManager = Persistence.createEntityManagerFactory("XayDungPhanMem").createEntityManager();

	}
	
	public static MyEntityManager getInstance() {
		if(instance == null)
			instance = new MyEntityManager();
		return instance;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	 

}