/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTests {

	@Autowired
	private MockMvc mockMvc;
	//Giving a colour that no car has and checking if it returns nothing
	@Test
	public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

		this.mockMvc.perform(get("/cars").param("colour","pink")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string("[]"));
	}
	//Checks if it gives a 200 response for a colour query
	@Test
	public void paramGreetingShouldReturnTailoredMessage() throws Exception {

		this.mockMvc.perform(get("/cars").param("colour", "blue"))
		.andDo(print()).andExpect(status().isOk());
	}
	//Checks if asking for a white car gives back a correct response
	@Test
	public void paramWhiteShouldReturnTailoredMessage() throws Exception {
		String actual = "[{\"brand\":\"renault\",\"model\":\"megane\",\"fuel\":\"petrol\",\"doors\":5,\"colour\":\"white\"}]";
		this.mockMvc.perform(get("/cars").param("colour", "white"))
		.andDo(print()).andExpect(status().isOk()).andExpect(content().string(actual));
	}

}
