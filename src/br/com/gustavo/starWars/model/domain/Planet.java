package br.com.gustavo.starWars.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Planets")
public class Planet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String terrain;
	private String climate;

	public Planet() {

	}

	public Planet(int id, String name, String terrain, String climate) {
		super();
		this.id = id;
		this.name = name;
		this.terrain = terrain;
		this.climate = climate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	@Override
	public String toString() {
		return "Planet [id=" + id + ", name=" + name + ", terrain=" + terrain + ", climate=" + climate + "]";
	}

}