package br.com.gustavo.starWars.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.gustavo.starwars.converter.PlanetConverter;
import br.com.gustavo.starWars.model.domain.Planet;
import com.mongodb.DBObject;
/**
 * Class used from migration to Mongo
 * @author gustavo
 *
 */

public class PlanetDAO  extends EntityDao<Planet> {

    public PlanetDAO() {
        super(Planet.class);
    }

    public Planet save(Planet planet) {
        Map<String, Object> mapPlanet =
                new PlanetConverter().converterToMap(planet);
        try {
        	save(mapPlanet);
        	return planet;
        }catch (RuntimeException e) {
        	System.out.println("Error" + e.getMessage());
		}
        return null;
    }

    public Planet update(Planet oldPlanet, Planet newPlanet) {
    	 //TODO retornar modelo Planet
        Map<String, Object> query =
                new PlanetConverter().converterToMap(oldPlanet);

        Map<String, Object> map =
                new PlanetConverter().converterToMap(newPlanet);
        try {
        	 update(query, map);
        	return newPlanet;
        }catch (Exception e) {
        	System.out.println("Error" + e.getMessage());
		}
        return null;
    }

    public void delete(Planet planet) {
        Map<String, Object> map =
                new PlanetConverter().converterToMap(planet);

        delete(map);
    }

    public Planet findPlanet(Map<String, Object> mapKeyValue) {
        DBObject dbObject = findOne(mapKeyValue);

        Planet planet =
                new PlanetConverter().converterToPlanet(dbObject);

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

    public List<Planet> findPlanets(Map<String, Object> mapKeyValue) {
        List<DBObject> dbObject = findKeyValue(mapKeyValue);

        List<Planet> planets = new ArrayList<Planet>();

        for (DBObject dbo : dbObject) {
            Planet planet = new PlanetConverter().converterToPlanet(dbo);

            planets.add(planet);
        }

        return planets;
    }
}
