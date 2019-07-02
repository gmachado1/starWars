package br.com.gustavo.starWars.service;

import java.util.List;

import br.com.gustavo.starWars.model.dao.PlanetDao;
import br.com.gustavo.starWars.model.domain.Planet;

public class PlanetService {

	private PlanetDao dao = new PlanetDao();

	public List<Planet> list() {
		return dao.list();
	}

	public Planet getById(int id) {
		return dao.getById(id);
	}

	public Planet save(Planet p) {
		return dao.save(p);
	}

	public Planet update(Planet p) {
		return dao.update(p);
	}

	public void remove(int id) {
		dao.remove(id);
	}

	public List<Planet> getPlanetByName(String name) {
		return dao.getByName(name);
	}

}
