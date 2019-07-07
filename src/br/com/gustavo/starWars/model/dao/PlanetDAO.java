package br.com.gustavo.starWars.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.gustavo.starwars.converter.PlanetConverter;
import br.com.gustavo.starWars.exceptions.DAOException;
import br.com.gustavo.starWars.exceptions.ErrorCode;
import br.com.gustavo.starWars.model.domain.Planet;
import com.mongodb.DBObject;

/**
 * Class used from migration to Mongo
 * 
 * @author gustavo
 *
 */

public class PlanetDAO extends EntityDao<Planet> {

	public PlanetDAO() {
		super(Planet.class);
	}

	public Planet save(Planet planet) {
		Map<String, Object> mapPlanet = new PlanetConverter().converterToMap(planet);
		if (!planetIsValid(planet)) {
			throw new DAOException("Planeta com dados incompletos.", ErrorCode.BAD_REQUEST.getCode());
		}
		try {
			save(mapPlanet);

		} catch (RuntimeException e) {
			e.getLocalizedMessage();
			throw new DAOException("Erro ao salvar planeta no espaço. " + e.getMessage(),
					ErrorCode.SERVER_ERROR.getCode());

		}
		return planet;
	}

	public List<Planet> findPlanets(Map<String, Object> mapKeyValue) {
		List<DBObject> dbObject = findKeyValue(mapKeyValue);

		List<Planet> planets = new ArrayList<Planet>();
		try {
			for (DBObject dbo : dbObject) {
				Planet planet = new PlanetConverter().converterToPlanet(dbo);

				planets.add(planet);
			}
		} catch (RuntimeException ex) {
			throw new DAOException("Erro ao recuperar todos os planetas do universo: " + ex.getMessage(),
					ErrorCode.SERVER_ERROR.getCode());
		}

		return planets;
	}

	public Planet update(Planet oldPlanet, Planet newPlanet) {
		Map<String, Object> query = new PlanetConverter().converterToMap(oldPlanet);

		if (!planetIsValid(newPlanet)) {
			throw new DAOException("Planeta com dados incompletos.", ErrorCode.BAD_REQUEST.getCode());
		}

		Map<String, Object> map = new PlanetConverter().converterToMap(newPlanet);
		try {
			update(query, map);

		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
		return newPlanet;
	}

	public void delete(Planet planet) {
		
		if (!planetIsValid(planet)) {
			
			throw new DAOException("Planeta com dados incompletos.", ErrorCode.BAD_REQUEST.getCode());
		}
		
		Map<String, Object> map = new PlanetConverter().converterToMap(planet);

		
		delete(map);
	}

	public Planet findPlanet(Map<String, Object> mapKeyValue) {

		int id = (Integer) mapKeyValue.get("_id");
		if (id < 0) {
			throw new DAOException("Planeta com dados incompletos.", ErrorCode.BAD_REQUEST.getCode());
		}
		
		DBObject dbObject = findOne(mapKeyValue);

		Planet planet = new PlanetConverter().converterToPlanet(dbObject);

		return planet;
	}

	public Planet findPlanetById(Map<String, Object> mapKeyValue) {
		
		int id = (Integer) mapKeyValue.get("_id");
		if (id < 0) {
			throw new DAOException("Planeta com dados incompletos.", ErrorCode.BAD_REQUEST.getCode());
		}

		DBObject dbObject = findOne(mapKeyValue);
		
		if (dbObject == null) {
			throw new DAOException("Planeta inexistente.", ErrorCode.NOT_FOUND.getCode());
		}

		Planet planet = new PlanetConverter().converterToPlanet(dbObject);

		return planet;
	}

	public List<Planet> findPlanets() {

		List<DBObject> dbObject = findAll();

		List<Planet> planets = new ArrayList<Planet>();

		for (DBObject dbo : dbObject) {
			Planet planet = new PlanetConverter().converterToPlanet(dbo);

			planets.add(planet);
		}

		return planets;
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
}
