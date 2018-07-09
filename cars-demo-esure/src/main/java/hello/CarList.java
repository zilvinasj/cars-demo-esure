package hello;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
public class CarList {
	//
	@JsonProperty("cars")
	private List<Cars> cars;

	public List<Cars> getEntries(){
		return this.cars;
	}
	public void setEntries(List<Cars> entries){
		this.cars = entries;
	}
}
