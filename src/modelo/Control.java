package modelo;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 
 */
public class Control implements TipoAlarma{

    /**
     * Default constructor
     */
    public Control() {
    	this.fecha = LocalDateTime.now();
    }

    /**
     * 
     */
    private List<Accion> accionesARealizar;

    /**
     * 
     */
    private LocalDateTime fecha;
    
	@Override
	public void crearAlarma() {
		Alarma alarma = new Alarma(this);
	}

	public void agregarAcccion (Accion accion) {
		this.accionesARealizar.add(accion);
	}

}