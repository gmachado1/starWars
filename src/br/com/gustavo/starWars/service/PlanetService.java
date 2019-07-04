package br.com.gustavo.starWars.service;

import java.util.List;
import java.util.Map;

import com.mongodb.DBObject;

import br.com.gustavo.starWars.model.dao.PlanetDAO;
import br.com.gustavo.starWars.model.domain.Planet;

public class PlanetService {

	private PlanetDAO dao = new PlanetDAO();

	public List<Planet> list() {
		return dao.findPlanets();
	}

	public Planet getById(Map<String, Object> map) {
		return dao.findPlanet(map);
	}

	public Planet save(Planet p) {
		return dao.save(p);
	}

	public Planet update(Planet oldPlanet,Planet newPlanet) {
		return dao.update(oldPlanet, newPlanet);
	}

	public void remove(Planet p) {
		dao.delete(p);
	}

	public List<Planet> getPlanetByName(Map<String, Object> mapKeyValue) {
		return dao.findPlanets(mapKeyValue);
	}

}
