package electronicid.temperature;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import electronicid.temperature.dto.IncResponseDTO;
import electronicid.temperature.dto.LecturasDTO;
import electronicid.temperature.service.GestionTemperaturaService;

@SpringBootTest
class GestionTemperaturaApplicationTests {
	
	@Autowired GestionTemperaturaService gestionTemperaturaService;

	@Test
	void loadIncrement() {
		LecturasDTO lecturasDTO = new LecturasDTO();
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(10);
		lista.add(15);
		lista.add(18);
		lista.add(1);
		lista.add(8);
		lecturasDTO.setReadings(lista);
		IncResponseDTO incResponseDTO=gestionTemperaturaService.loadIncrement(lecturasDTO);
		assertThat(incResponseDTO.getIncremento()==8 && incResponseDTO.getExito());
		lista = new ArrayList<Integer>();
		incResponseDTO=gestionTemperaturaService.loadIncrement(lecturasDTO);
		assertThat(incResponseDTO.getIncremento()==0 && incResponseDTO.getExito());
		lista.add(1);
		assertThat(incResponseDTO.getIncremento()==0 && incResponseDTO.getExito());
		lista.add(1);
		lista.add(1);
		assertThat(incResponseDTO.getIncremento()==0 && incResponseDTO.getExito());
		lista = new ArrayList<Integer>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		assertThat(incResponseDTO.getIncremento()==2 && incResponseDTO.getExito());
		lista = new ArrayList<Integer>();
		lista.add(3);
		lista.add(2);
		lista.add(1);
		assertThat(incResponseDTO.getIncremento()==0 && incResponseDTO.getExito());
		lista = null;
		assertThat(!incResponseDTO.getExito());
	}

}
