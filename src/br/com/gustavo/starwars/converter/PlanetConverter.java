package br.com.gustavo.starwars.converter;

import java.util.HashMap;
import java.util.Map;

import com.mongodb.DBObject;

import br.com.gustavo.starWars.model.domain.Planet;
/**
 * Class used to convert atributes for mongo use. 
 * @author gustavo
 *
 */
public class PlanetConverter {

	public Map<String, Object> converterToMap(Planet planet) {
		Map<String, Object> mapPlanet = new HashMap<String, Object>();

		mapPlanet.put("_id", planet.get_Id());
		mapPlanet.put("name", planet.getName());
		mapPlanet.put("terrain", planet.getTerrain());
		mapPlanet.put("climate", planet.getClimate());

		return mapPlanet;
	}

	public Planet converterToPlanet(DBObject dbo) {
		Planet planet = new Planet();

		planet.set_Id((Integer)dbo.get("_id"));
		planet.setName((String) dbo.get("name"));
		planet.setTerrain((String) dbo.get("terrain"));
		planet.setClimate((String) dbo.get("climate"));

		return planet;
	}

}
