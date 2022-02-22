package electronicid.temperature.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import electronicid.temperature.dto.IncResponseDTO;
import electronicid.temperature.dto.ReadingsDTO;
import electronicid.temperature.service.TemperatureService;

@SpringBootTest
class TempetarureServiceTest {
	
	@Autowired TemperatureService temperatureService;

	@Test
	void loadIncrement() {
		ReadingsDTO readingsDTO = new ReadingsDTO();
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(15);
		list.add(18);
		list.add(1);
		list.add(8);
		readingsDTO.setReadings(list);
		IncResponseDTO incResponseDTO=temperatureService.loadIncrement(readingsDTO);
		assertThat(incResponseDTO.getIncrement()==8 && incResponseDTO.getSuccess()).isTrue();
		list = new ArrayList<Integer>();
		readingsDTO.setReadings(list);
		incResponseDTO=temperatureService.loadIncrement(readingsDTO);
		assertThat(incResponseDTO.getIncrement()==0 && incResponseDTO.getSuccess()).isTrue();
		list.add(1);
		incResponseDTO=temperatureService.loadIncrement(readingsDTO);
		assertThat(incResponseDTO.getIncrement()==0 && incResponseDTO.getSuccess()).isTrue();
		list.add(1);
		list.add(1);
		incResponseDTO=temperatureService.loadIncrement(readingsDTO);
		assertThat(incResponseDTO.getIncrement()==0 && incResponseDTO.getSuccess()).isTrue();
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		readingsDTO.setReadings(list);
		incResponseDTO=temperatureService.loadIncrement(readingsDTO);
		assertThat(incResponseDTO.getIncrement()==2 && incResponseDTO.getSuccess()).isTrue();
		list = new ArrayList<Integer>();
		list.add(3);
		list.add(2);
		list.add(1);
		readingsDTO.setReadings(list);
		incResponseDTO=temperatureService.loadIncrement(readingsDTO);
		assertThat(incResponseDTO.getIncrement()==0 && incResponseDTO.getSuccess()).isTrue();
		readingsDTO.setReadings(null);
		incResponseDTO=temperatureService.loadIncrement(readingsDTO);
		assertThat(incResponseDTO.getSuccess()).isFalse();
	}

}
