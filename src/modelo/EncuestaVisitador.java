package modelo;

import java.util.*;

/**
 * 
 */
public class EncuestaVisitador {

    public EncuestaVisitador() {
    }

    private ERespuestaEncuesta estadoGeneralAnimal;
    private ERespuestaEncuesta limpiezaLugar;
    private ERespuestaEncuesta ambiente;
	public ERespuestaEncuesta getEstadoGeneralAnimal() {
		return estadoGeneralAnimal;
	}
	public void setEstadoGeneralAnimal(ERespuestaEncuesta estadoGeneralAnimal) {
		this.estadoGeneralAnimal = estadoGeneralAnimal;
	}
	public ERespuestaEncuesta getLimpiezaLugar() {
		return limpiezaLugar;
	}
	public void setLimpiezaLugar(ERespuestaEncuesta limpiezaLugar) {
		this.limpiezaLugar = limpiezaLugar;
	}
	public ERespuestaEncuesta getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(ERespuestaEncuesta ambiente) {
		this.ambiente = ambiente;
	}
    
}