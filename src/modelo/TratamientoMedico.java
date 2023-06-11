package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import testMain.Utilidades;

public class TratamientoMedico implements TipoAlarma{

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private ArrayList<Accion> acciones;
    private String descripcion;
    private String nombre;
    private int periodicidad;
    private boolean estaFinalizado;

    public TratamientoMedico(LocalDateTime fechaFin, String desc, String nombre, int periodicidad) {
    	this.fechaFin = fechaFin;
    	this.descripcion = desc;
    	this.nombre = nombre;
    	this.periodicidad = periodicidad;
    	this.estaFinalizado = false;
    	this.acciones = new ArrayList();
    }
    
    public TratamientoMedico() {
		this.acciones = new ArrayList();
	}

	public void marcarFinalizado() {
    	this.estaFinalizado = true;
    }


    public void modificarTratamiento() {
    	
    }
    
    public void agregarAccion (Accion accion) {
    	this.acciones.add(accion);
    }

	@Override
	public Alarma crearAlarma(TipoAlarma tipo) {
		Alarma alarma = new Alarma(this);	
		return alarma;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<Accion> getAcciones() {
		return acciones;
	}

	public void setAcciones(ArrayList<Accion> acciones) {
		this.acciones = acciones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(int periodicidad) {
		this.periodicidad = periodicidad;
	}

	public boolean isEstaFinalizado() {
		return estaFinalizado;
	}

	public void setEstaFinalizado(boolean estaFinalizado) {
		this.estaFinalizado = estaFinalizado;
	}

	@Override
	public String toString() {
		return "TratamientoMedico [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", acciones=" + acciones
				+ ", descripcion=" + descripcion + ", nombre=" + nombre + ", periodicidad=" + periodicidad
				+ ", estaFinalizado=" + estaFinalizado + "]";
	}

	@Override
	public void enviarNotificacionPush(Alarma alarma) {
		if(Refugio.getUserConectado().getClass().equals(Veterinario.class)) {
			Utilidades.claseTimer(alarma, periodicidad);
		}
		
	}
	
	

}