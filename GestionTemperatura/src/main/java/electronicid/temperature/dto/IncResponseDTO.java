package electronicid.temperature.dto;

/**
 * DTO Respuesta para API REST
 * @author fvigueras
 *
 */
public class IncResponseDTO {
	
	private Integer incremento;
	private Boolean exito;
	
	public Integer getIncremento() {
		return incremento;
	}
	public void setIncremento(Integer incremento) {
		this.incremento = incremento;
	}
	public Boolean getExito() {
		return exito;
	}
	public void setExito(Boolean exito) {
		this.exito = exito;
	}
	
	

}
