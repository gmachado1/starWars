package br.com.gustavo.starWars.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Planets")
public class Planet {

	@Id
	private int _id;
	private String name;
	private String terrain;
	private String climate;

	public Planet() {

	}
	

	public Planet(int _id, String name, String terrain, String climate) {
		super();
		this._id = _id;
		this.name = name;
		this.terrain = terrain;
		this.climate = climate;
	}

	public int get_Id() {
		return _id;
	}

	public void set_Id(int _id) {
		this._id = _id;
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
		return "Planet [_id=" + _id + ", name=" + name + ", terrain=" + terrain + ", climate=" + climate + "]";
	}

}