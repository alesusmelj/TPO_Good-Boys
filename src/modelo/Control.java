package modelo;

import java.time.LocalDateTime;
import java.util.*;

public class Control implements TipoAlarma{

    private List<Accion> accionesARealizar;
    private LocalDateTime fecha;
    
    public Control() {
    	this.fecha = LocalDateTime.now();
    }
    
	@Override
	public void crearAlarma() {
		Alarma alarma = new Alarma(this);
		
	}

	public void agregarAcccion (Accion accion) {
		this.accionesARealizar.add(accion);
	}

}