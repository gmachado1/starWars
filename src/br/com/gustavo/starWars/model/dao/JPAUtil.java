package br.com.gustavo.starWars.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * Class not been used, class used before migration from mysql to mongo
 * @author gustavo
 *
 */
public class JPAUtil {
	private static EntityManagerFactory emf;

	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("planets");
		}
		return emf.createEntityManager();
	}
}