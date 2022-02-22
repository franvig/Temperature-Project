package electronicid.temperature.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import electronicid.temperature.dto.IncResponseDTO;
import electronicid.temperature.dto.ReadingsDTO;

@SpringBootTest
class WebControllerTest {
	@Autowired WebController webController;
	
	@Test
	void loadIncrement() {
		ReadingsDTO readingsDTO = new ReadingsDTO();
		IncResponseDTO response = webController.loadIncrement(readingsDTO);
		assertThat(response).isNotNull();
		
		readingsDTO = null;
		response = webController.loadIncrement(readingsDTO);
		assertThat(response).isNotNull();
		
	}

}
