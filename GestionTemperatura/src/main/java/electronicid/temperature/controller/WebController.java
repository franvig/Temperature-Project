package electronicid.temperature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import electronicid.temperature.dto.IncResponseDTO;
import electronicid.temperature.dto.LecturasDTO;
import electronicid.temperature.service.GestionTemperaturaService;
/**
 * RestController
 * @author fvigueras
 *
 */
@RestController
public class WebController {
	
	@Autowired
	private GestionTemperaturaService gestionTemperaturaService;
	
	/**
	 * POST: Recibimos lista temperaturas y calculamos el mayor incremento
	 * @param lecturasDTO
	 */
	@PostMapping("/v2/stats/compute")
    public IncResponseDTO loadIncrement(@RequestBody LecturasDTO lecturasDTO) {
		return gestionTemperaturaService.loadIncrement(lecturasDTO);
    }

}
