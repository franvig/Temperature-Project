package electronicid.temperature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import electronicid.temperature.dto.IncResponseDTO;
import electronicid.temperature.dto.ReadingsDTO;

@Service
public class TemperatureService {

	public IncResponseDTO loadIncrement(ReadingsDTO readingsDTO) {
		Integer maxIncrement = 0;
		IncResponseDTO incResponseDTO = new IncResponseDTO();
		try {
			List<Integer> list = readingsDTO.getReadings();
			for (int i = 0; i < list.size(); i++) {
				for (int j = i; j < list.size(); j++) {
					Integer increment = list.get(j) - list.get(i);
					if(maxIncrement <  increment) {
						maxIncrement = increment;
					}
				}
			}
			incResponseDTO.setSuccess(Boolean.TRUE);
			incResponseDTO.setIncrement(maxIncrement);
		}catch(Exception e) {
			//lecturasDTO == NULL
			incResponseDTO.setSuccess(Boolean.FALSE);
			incResponseDTO.setIncrement(maxIncrement);
		}
		return incResponseDTO;
	}



}
