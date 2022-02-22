package electronicid.temperature.dto;

import java.util.ArrayList;
import java.util.List;

public class ReadingsDTO {
	
	private List<Integer> readings = new ArrayList<>();

	public List<Integer> getReadings() {
		return readings;
	}

	public void setReadings(List<Integer> readings) {
		this.readings = readings;
	}

}
