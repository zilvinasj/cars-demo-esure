package hello;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class CarController {
	//mapping for all the cars
	@RequestMapping("/cars")
	public List<Cars> cars() throws JsonParseException, JsonMappingException, IOException {
		CarService cs = new CarService();
		return cs.getAll();
	}
	@Autowired
	CarService cs;
	//mapping for cars to be filtered by colour
	@RequestMapping(value = "/cars", params = "colour")
	public List<Cars> getCars(@RequestParam("colour") String colour) {
		return cs.getCars(colour);
	}



}
