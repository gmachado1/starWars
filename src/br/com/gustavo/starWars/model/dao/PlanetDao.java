package br.com.gustavo.starWars.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gustavo.starWars.exceptions.DAOException;
import br.com.gustavo.starWars.exceptions.ErrorCode;
import br.com.gustavo.starWars.model.domain.Planet;
/**
 * Class not been use. it was used when it was using MYSQL
 * @author gustavo
 *
 */
public class PlanetDao {
	public Planet save(Planet p) {
		EntityManager em = JPAUtil.getEntityManager();

		if (!planetIsValid(p)) {
			throw new DAOException("Planeta com dados incompletos.", ErrorCode.BAD_REQUEST.getCode());
		}

		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();

		} catch (RuntimeException ex) {
			em.getTransaction().rollback();
			throw new DAOException("Erro ao salvar planeta no espaço. " + ex.getMessage(),
					ErrorCode.SERVER_ERROR.getCode());
		} finally {
			em.close();
		}
		return p;
	}
	
	public List<Planet> list() {
		EntityManager em = JPAUtil.getEntityManager();
		List<Planet> planets = null;

		try {
			planets = em.createQuery("select p from Planets p", Planet.class).getResultList();
		} catch (RuntimeException ex) {
			throw new DAOException("Erro ao recuperar todos os planetas do universo: " + ex.getMessage(),
					ErrorCode.SERVER_ERROR.getCode());
		} finally {
			em.close();
		}

		return planets;
	}

	public Planet getById(int id){
		Planet p = null;
		EntityManager em = JPAUtil.getEntityManager();

		if (id <= 0) {
			throw new DAOException("O id precisa ser maior do que 0.", ErrorCode.BAD_REQUEST.getCode());
		}

		try {
			p = em.find(Planet.class, id);
		} catch (RuntimeException ex) {
			throw new DAOException("Erro ao buscar planeta por id na galáxia: " + ex.getMessage(),
					ErrorCode.SERVER_ERROR.getCode());
		} finally {
			em.close();
		}

		if (p == null) {
			throw new DAOException("Planeta de id " + id + " não existe.", ErrorCode.NOT_FOUND.getCode());
		}
		return p;
	}


	public Planet update(Planet p){
		EntityManager em = JPAUtil.getEntityManager();
		Planet planetManaged = null;

		if (p.get_Id() <= 0) {
			throw new DAOException("O id precisa ser maior do que 0.", ErrorCode.BAD_REQUEST.getCode());
		}
		if (!planetIsValid(p)) {
			throw new DAOException("Planeta com dados incompletos.", ErrorCode.BAD_REQUEST.getCode());
		}

		try {
			em.getTransaction().begin();
			planetManaged = em.find(Planet.class, p.get_Id());
			planetManaged.setName(p.getName());
			planetManaged.setTerrain(p.getTerrain());
			planetManaged.setClimate(p.getClimate());
			// em.merge(produtoManaged);
			em.getTransaction().commit();
		} catch (NullPointerException ex) {
			em.getTransaction().rollback();
			throw new DAOException("Planeta informado para atualização não existe: " + ex.getMessage(),
					ErrorCode.NOT_FOUND.getCode());
		} catch (RuntimeException ex) {
			em.getTransaction().rollback();
			throw new DAOException("Erro ao atualizar planeta: " + ex.getMessage(), ErrorCode.SERVER_ERROR.getCode());
		} finally {
			em.close();
		}
		return planetManaged;
	}

	public void remove(int id)  {
		EntityManager em = JPAUtil.getEntityManager();
		Planet planet = null;

		if (id <= 0) {
			throw new DAOException("O id precisa ser maior do que 0.", ErrorCode.BAD_REQUEST.getCode());
		}

		try {
			em.getTransaction().begin();
			planet = em.find(Planet.class, id);
			em.remove(planet);
			em.getTransaction().commit();
		} catch (IllegalArgumentException ex) {
			em.getTransaction().rollback();
			throw new DAOException("Planeta informado para remoção não existe: " + ex.getMessage(),
					ErrorCode.NOT_FOUND.getCode());
		} catch (RuntimeException ex) {
			em.getTransaction().rollback();
			throw new DAOException("Erro ao remover planeta: " + ex.getMessage(), ErrorCode.SERVER_ERROR.getCode());
		} finally {
			em.close();
		}
	}

	public boolean planetIsValid(Planet p) {
		try {
			if ((p.getName().isEmpty()) || (p.getClimate().length() < 3) || (p.getTerrain().length() < 3))
				return false;
		} catch (NullPointerException ex) {
			throw new DAOException("Planeta com dados incompletos.", ErrorCode.BAD_REQUEST.getCode());
		}

		return true;
	}

	public List<Planet> getByName(String name) {
		EntityManager em = JPAUtil.getEntityManager();
		List<Planet> planets = null;

		try {
			planets = em.createQuery("select p from Planets p where p.name like :name", Planet.class)
					.setParameter("name", "%" + name + "%").getResultList();
		} catch (RuntimeException ex) {
			throw new DAOException("Erro ao buscar planetas pelo nome: " + ex.getMessage(),
					ErrorCode.SERVER_ERROR.getCode());
		} finally {
			em.close();
		}

		if (planets.isEmpty()) {
			throw new DAOException("A consulta não retornou elementos.", ErrorCode.NOT_FOUND.getCode());
		}

		return planets;
	}
}
