package modelo;

import java.time.LocalDateTime;
import java.util.*;

public class Control implements TipoAlarma{

    private ArrayList<Accion> accionesARealizar;
    private LocalDateTime fecha;
    
    public Control() {
    	this.fecha = LocalDateTime.now();
    	this.accionesARealizar = new ArrayList();
    }
    
	@Override
	public Alarma crearAlarma(TipoAlarma tipo) {
		Alarma alarma = new Alarma(this);
		return alarma;
	}

	public void agregarAccion (Accion accion) {
		this.accionesARealizar.add(accion);
	}

	@Override
	public String toString() {
		return "Control [accionesARealizar=" + accionesARealizar + ", fecha=" + fecha + "]";
	}

	@Override
	public void enviarNotificacionPush(Alarma alarma) {
		if(Refugio.userConectado.getClass().equals(Veterinario.class)) {
			System.out.println(this.toString());
		}
	}
	
	

}