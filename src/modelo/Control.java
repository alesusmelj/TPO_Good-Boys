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
	public Alarma crearAlarma(TipoAlarma tipo) {
		Alarma alarma = new Alarma(this);
		return alarma;
	}

	public void agregarAccion (Accion accion) {
		this.accionesARealizar.add(accion);
	}

}