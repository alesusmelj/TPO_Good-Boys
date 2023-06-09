package modelo;

import java.util.*;

/**
 * 
 */
public class TratamientoMedico implements TipoAlarma{

    /**
     * Default constructor
     */
    public TratamientoMedico(Date fechaInicio, Date fechaFin, String desc, String nombre, int periodicidad) {
    	this.fechaInicio = fechaInicio;
    	this.fechaFin = fechaFin;
    	this.descripcion = desc;
    	this.nombre = nombre;
    	this.periodicidad = periodicidad;
    	this.estaFinalizado = false;
    }

    private Date fechaInicio;
    private Date fechaFin;
    private List<Accion> acciones;
    private String descripcion;
    private String nombre;
    private int periodicidad;
    private boolean estaFinalizado;

    
    public void marcarFinalizado() {
    }


    public void modificarTratamiento() {
    	
    }
    
    public void agregarAccion (Accion accion) {
    	this.acciones.add(accion);
    }

	@Override
	public void crearAlarma() {
		Alarma alarma = new Alarma(this);	
	}

}