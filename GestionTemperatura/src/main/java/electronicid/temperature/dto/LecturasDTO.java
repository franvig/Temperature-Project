package electronicid.temperature.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO Entrada API Rest
 * @author fvigueras
 *
 */
public class LecturasDTO {
	
	private List<Integer> readings = new ArrayList<>();

	public List<Integer> getReadings() {
		return readings;
	}

	public void setReadings(List<Integer> readings) {
		this.readings = readings;
	}

}
