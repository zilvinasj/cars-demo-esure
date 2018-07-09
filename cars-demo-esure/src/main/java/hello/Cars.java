package hello;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Cars {

	//POJO for the cars
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getCars() {
		return cars;
	}

	public void setCars(String cars) {
		this.cars = cars;
	}

	@JsonIgnoreProperties(value = "cars")
	@JsonIgnore
	private String cars;

	private String brand;
	private String model;
	private String fuel;
	private int doors;
	private String colour;
	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getFuel() {
		return fuel;
	}

	public int getDoors() {
		return doors;
	}

	public String getColour() {
		return colour;
	}

}


