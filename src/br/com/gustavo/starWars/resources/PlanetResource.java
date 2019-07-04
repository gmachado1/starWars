package br.com.gustavo.starWars.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.gustavo.starWars.model.domain.Planet;
import br.com.gustavo.starWars.service.PlanetService;

@Path("/planets")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class PlanetResource {

	private PlanetService service;

	@PostConstruct
	private void init() {
		service = new PlanetService();
	}

	@GET
	public List<Planet> list(@QueryParam("name") String name) {
		if (name != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", name);
			return service.getPlanetByName(map);
		}
		return service.list();
	}

	@GET
	@Path("/{id}")
	public Planet getById(@PathParam("id") int id) {
		Planet p = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("_id", id);
		p = service.getById(map);
		return p;
	}

	@POST
	public Response save(Planet p) {
		String msg = "Erro adding Planet! :-( ";
		try {
			System.out.println(p);
			p = service.save(p);
			msg = "Planet added! id of the planet:" + p.get_Id();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(msg);
		}

		return Response.status(Status.CREATED).entity(p).build();
	}

	@PUT
	@Path("/{id}")
	public void update(Planet newPlanet, @PathParam("id") int id) {
		String msg = "Error on changing planet!";
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("_id", id);
			Planet oldPlanet = service.getById(map); 
			service.update(oldPlanet,newPlanet);
			System.out.println(newPlanet);
			msg = "Planet changed!";
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(msg);
		}

	}

	@DELETE
	@Path("/{id}")
	public void remove(@PathParam("id") int id) {
		String msg = "Error on removing planet!";
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("_id", id);
			Planet p = service.getById(map);
			p.set_Id(id);
			service.remove(p);
			msg = "Planet removed! Bye bye...";
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(msg);
		}
	}
}
