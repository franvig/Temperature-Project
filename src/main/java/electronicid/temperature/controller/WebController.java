package electronicid.temperature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import electronicid.temperature.dto.IncResponseDTO;
import electronicid.temperature.dto.ReadingsDTO;
import electronicid.temperature.service.TemperatureService;

@RestController
public class WebController {
	
	@Autowired
	private TemperatureService temperatureService;
	
	@PostMapping("/v2/stats/compute")
    public IncResponseDTO loadIncrement(@RequestBody ReadingsDTO readingsDTO) {
		return temperatureService.loadIncrement(readingsDTO);
    }

}
