package br.com.gustavo.starWars.resources.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import br.com.gustavo.starWars.exceptions.DAOException;
import br.com.gustavo.starWars.model.dao.PlanetDAO;
import br.com.gustavo.starWars.model.domain.Planet;
import br.com.gustavo.starWars.service.PlanetService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlanetResourceTest {

	static PlanetDAO planetDao = new PlanetDAO();
	static PlanetService service = new PlanetService();
	static List<Planet> planets = new ArrayList<Planet>();

	static int invalidId;

	@AfterAll
	static void tearDownAfterClass() throws Exception {
//		Planet p = new Planet();
//
//		p.setName("Alderaan");
//		p.setTerrain("grasslands, mountains");
//		p.setClimate("temperate");
//		planetDao.save(p);
//
//		p.setName("Yavin IV");
//		p.setTerrain("jungle, rainforests");
//		p.setClimate("temperate, tropical");
//		planetDao.save(p);
//
//		p.setName("Hoth");
//		p.setTerrain("tundra, ice caves, mountain ranges");
//		p.setClimate("frozen");
//		planetDao.save(p);
//
//		p.setName("Dagobah");
//		p.setTerrain("swamp, jungles");
//		p.setClimate("murky");
//		planetDao.save(p);

	}

	@BeforeEach
	void setUp() {

//		Planet p = new Planet();
//
//		p.setName("Endor");
//		p.setTerrain("forests, mountains, lakes");
//		p.setClimate("temperate");
//		validId = planetDao.save(p).getId();
	}

	@AfterEach
	void tearDown() {
		// TODO Auto-generated method stub
		// planetDao.remove(validId);
	}

	/**
	 * Testing if save method
	 */
	@RepeatedTest(2)
	void testA() {
		// testASavePlanets() {
		planets = planetDao.findPlanets();
				
		int size = planets.size();
		int id = planets.get(size-1).get_Id()+1;

		Planet p = new Planet();
		p.set_Id(id);
		p.setName((id % 2 == 0) ? "planet" + id : "moon" + id);
		p.setTerrain((id % 2 == 0) ? "soil" + id : id + "soil");
		p.setClimate((id % 2 == 0) ? "habitável" + id : id + "inabitável");

		invalidId = planetDao.save(p).get_Id()+1; // used on Test: testEIdNotExist(testE)

		int newSize = planetDao.findPlanets().size();

		assertEquals(size + 1, newSize);
	}

	/**
	 * Test method getID exist
	 */
	@Test
	void testB() {
		// testBIdExist() {
		Planet aux = planetDao.findPlanets().get(0);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("_id", aux.get_Id());
		
		Planet p = service.getById(map);
				
		assertEquals(true, planetDao.planetIsValid(p));
	}

	/**
	 * Test if name lenght is been tested
	 */
	@Test
	void testC() {
		// testCInvalidPlanet() {

		Planet p = new Planet();
		p.setName("");// empty name
		p.setTerrain("123");
		p.setClimate("123");
		DAOException expect = assertThrows(DAOException.class, () -> planetDao.save(p));
		assertEquals(400, expect.getCode());// error name field
		
		Planet oldPlanet = planetDao.findPlanets().get(0);
		Planet newPlanet = new Planet();
		newPlanet.setName("");// empty name
		newPlanet.setTerrain("1234");
		newPlanet.setClimate("123");
		expect = assertThrows(DAOException.class, () -> planetDao.update(oldPlanet, newPlanet));
		assertEquals(400, expect.getCode());// error name field

		newPlanet.setName("Plutão");
		newPlanet.setTerrain("12");
		newPlanet.setClimate("wheather");
		expect = assertThrows(DAOException.class, () -> planetDao.save(p));
		assertEquals(400, expect.getCode());// error Terrain field
		expect = assertThrows(DAOException.class, () -> planetDao.update(oldPlanet,newPlanet));
		assertEquals(400, expect.getCode());// error Terrain field

		newPlanet.setName("Plutão");
		newPlanet.setTerrain("123");
		newPlanet.setClimate("1");
		expect = assertThrows(DAOException.class, () -> planetDao.save(p));
		assertEquals(400, expect.getCode());// error climate field
		expect = assertThrows(DAOException.class, () -> planetDao.update(oldPlanet,newPlanet));
		assertEquals(400, expect.getCode());// error climate field

	}

	/**
	 * Testing if id is less then zero
	 */
	@Test
	void testD() {
		// testDIdLessThenZero() {
		Planet aux = planetDao.findPlanets().get(0);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("_id", -1);
		
		DAOException expect = assertThrows(DAOException.class, () -> planetDao.findPlanet(map));
		assertEquals(400, expect.getCode());

		
		
		
		Planet p = new Planet();
		p.set_Id(-1);
		expect = assertThrows(DAOException.class, () -> service.getById(map));
		assertEquals(400, expect.getCode());

		expect = assertThrows(DAOException.class, () -> service.remove(p));
		assertEquals(400, expect.getCode());

		expect = assertThrows(DAOException.class, () -> planetDao.update(aux,p));
		assertEquals(400, expect.getCode());
	}

	/**
	 * Test if id does not exist
	 */
	@Test
	void testE() {
		// testEIdNotExist() {
		assertEquals(true, invalidId > 0);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("_id", invalidId);
		DAOException expect = assertThrows(DAOException.class, () -> planetDao.findPlanetById(map));
		assertEquals(404, expect.getCode());

		Planet p = new Planet();
		p.set_Id(invalidId);
		expect = assertThrows(DAOException.class, () -> planetDao.delete(p));
		assertEquals(400, expect.getCode());

	}

	/**
	 * Test ifplanet is been found
	 */
	@Test
	void testF() {
		// testFFindPlanetByName() {
		Planet p = planetDao.findPlanets().get(0);

		assertEquals(true, planetDao.planetIsValid(p));

	}

	/**
	 * Test remove Planet
	 */
	@RepeatedTest(3)
	void testG() {
		// testGRemovePlanets() {
		planets = planetDao.findPlanets();
		int size = planets.size();
		if (size==0) {
			Planet p = new Planet(8, "Naboo", "grassy hills, swamps, forests, mountains", "temperate");
			service.save(p);
			size = planets.size();
		}
		assertEquals(true, size > 0);

		Planet p = planets.get(size - 1);
		service.remove(p);

		planets = planetDao.findPlanets();
		int newSize = planets.size();

		assertEquals(--size, newSize);
	}

}