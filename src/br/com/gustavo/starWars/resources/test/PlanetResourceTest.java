package br.com.gustavo.starWars.resources.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import br.com.gustavo.starWars.exceptions.DAOException;
import br.com.gustavo.starWars.model.dao.PlanetDao;
import br.com.gustavo.starWars.model.domain.Planet;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlanetResourceTest {

	static PlanetDao planetDao = new PlanetDao();
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
	@RepeatedTest(5)
	void testA() {
		// testASavePlanets() {
		planets = planetDao.list();

		int size = planets.size();
		int id = planets.lastIndexOf(planets) + 1;

		Planet p = new Planet();
		p.setName((id % 2 == 0) ? "planet" + id : "moon" + id);
		p.setTerrain((id % 2 == 0) ? "soil" + id : id + "soil");
		p.setClimate((id % 2 == 0) ? "habitável" + id : id + "inabitável");

		invalidId = planetDao.save(p).getId() + 1; // used on Test: testEIdNotExist(testE)

		int newSize = planetDao.list().size();

		assertEquals(size + 1, newSize);
	}

	/**
	 * Test method get
	 */
	@Test
	void testB() {
		// testBIdExist() {
		Planet aux = planetDao.list().get(0);
		Planet p = planetDao.getById(aux.getId());
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
		expect = assertThrows(DAOException.class, () -> planetDao.update(p));
		assertEquals(400, expect.getCode());// error name field

		p.setName("Plutão");
		p.setTerrain("12");
		p.setClimate("wheather");
		expect = assertThrows(DAOException.class, () -> planetDao.save(p));
		assertEquals(400, expect.getCode());// error Terrain field
		expect = assertThrows(DAOException.class, () -> planetDao.update(p));
		assertEquals(400, expect.getCode());// error Terrain field

		p.setName("Plutão");
		p.setTerrain("123");
		p.setClimate("1");
		expect = assertThrows(DAOException.class, () -> planetDao.save(p));
		assertEquals(400, expect.getCode());// error climate field
		expect = assertThrows(DAOException.class, () -> planetDao.update(p));
		assertEquals(400, expect.getCode());// error climate field

	}

	/**
	 * Testing if id is less then zero
	 */
	@Test
	void testD() {
		// testDIdLessThenZero() {
		DAOException expect = assertThrows(DAOException.class, () -> planetDao.getById(-1));
		assertEquals(400, expect.getCode());

		Planet p = new Planet();
		p.setId(-1);
		expect = assertThrows(DAOException.class, () -> planetDao.getById(p.getId()));
		assertEquals(400, expect.getCode());

		expect = assertThrows(DAOException.class, () -> planetDao.remove(p.getId()));
		assertEquals(400, expect.getCode());

		expect = assertThrows(DAOException.class, () -> planetDao.update(p));
		assertEquals(400, expect.getCode());
	}

	/**
	 * Test if id does not exist
	 */
	@Test
	void testE() {
		// testEIdNotExist() {
		assertEquals(true, invalidId > 0);
		DAOException expect = assertThrows(DAOException.class, () -> planetDao.getById(invalidId));
		assertEquals(404, expect.getCode());

		Planet p = new Planet();
		p.setId(invalidId);
		p.setName("AnyName");
		p.setTerrain("123");
		p.setClimate("wheather");
		expect = assertThrows(DAOException.class, () -> planetDao.update(p));
		assertEquals(404, expect.getCode());

		expect = assertThrows(DAOException.class, () -> planetDao.remove(invalidId));
		assertEquals(404, expect.getCode());

	}

	/**
	 * Test ifplanet is been found
	 */
	@Test
	void testF() {
		// testFFindPlanetByName() {
		Planet p = planetDao.list().get(0);

		assertEquals(true, planetDao.planetIsValid(p));
		int ifExist = planetDao.getByName(p.getName()).size();
		assertEquals(true, ifExist > 0);

		DAOException expect = assertThrows(DAOException.class, () -> planetDao.getByName("zzzz"));
		assertEquals(404, expect.getCode());
		// CAUTION: It may have a planet with the name "zzzz". If you got error here,
		// look on your database.
	}

	/**
	 * Test remove Planet
	 */
	@RepeatedTest(5)
	void testG() {
		// testGRemovePlanets() {
		planets = planetDao.list();
		int size = planets.size();

		assertEquals(true, size > 0);

		Planet p = planets.get(size - 1);
		planetDao.remove(p.getId());

		planets = planetDao.list();
		int newSize = planets.size();

		assertEquals(--size, newSize);
	}

}