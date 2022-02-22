package electronicid.temperature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import electronicid.temperature.dto.IncResponseDTO;
import electronicid.temperature.dto.LecturasDTO;
/**
 * Servicio que calcula incremento maximo en las lecturas que nos llegan del termostato
 * @author fvigueras
 *
 */
@Service
public class GestionTemperaturaService {

	/**
	 * Método que recorre las lecturas y devuelve incremento máximo y éxito de la tarea.
	 * Devolverá false si lecturasDTO.listaTemperaturas es null
	 * @param lecturasDTO
	 * @return
	 */
	public IncResponseDTO loadIncrement(LecturasDTO lecturasDTO) {
		Integer maxIncrement = 0;
		IncResponseDTO incResponseDTO = new IncResponseDTO();
		try {
			List<Integer> lista = lecturasDTO.getReadings();
			for (int i = 0; i < lista.size(); i++) {
				for (int j = i; j < lista.size(); j++) {
					Integer increment = lista.get(j) - lista.get(i);
					if(maxIncrement <  increment) {
						maxIncrement = increment;
					}
				}
			}
			incResponseDTO.setExito(Boolean.TRUE);
			incResponseDTO.setIncremento(maxIncrement);
		}catch(Exception e) {
			//lecturasDTO == NULL
			incResponseDTO.setExito(Boolean.FALSE);
			incResponseDTO.setIncremento(maxIncrement);
		}
		return incResponseDTO;
	}



}
