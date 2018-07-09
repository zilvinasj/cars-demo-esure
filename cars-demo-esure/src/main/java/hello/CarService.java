package hello;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service

public class CarService {


	List<Cars> cars = new ArrayList<Cars>();

	public CarService() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		// deserialize contents of each file into an object of type
		CarList operator = mapper.readValue(new File("cars.json"), CarList.class);
		cars=operator.getEntries();
		//		for(int i =0; i<operator.getEntries().size();i++) {
		//			cars.add(operator.getEntries().get(i));
		//			
		//		}
	}
	//filters all the cars by given colour and returns a List with filtered results by colour
	public List<Cars> getCars(String colour) {
		List<Cars> filteredCars = new ArrayList<Cars>();

		for(int i = 0; i<cars.size();i++) {
			if(cars.get(i).getColour().equals(colour)) {
				filteredCars.add(cars.get(i));
			}
		}
		return filteredCars;
	}
	public List<Cars> getAll() {
		return cars;
	}
}

