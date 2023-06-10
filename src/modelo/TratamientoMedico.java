package modelo;

import java.util.*;

public class TratamientoMedico implements TipoAlarma{

    private Date fechaInicio;
    private Date fechaFin;
    private List<Accion> acciones;
    private String descripcion;
    private String nombre;
    private int periodicidad;
    private boolean estaFinalizado;

    public TratamientoMedico(Date fechaInicio, Date fechaFin, String desc, String nombre, int periodicidad) {
    	this.fechaInicio = fechaInicio;
    	this.fechaFin = fechaFin;
    	this.descripcion = desc;
    	this.nombre = nombre;
    	this.periodicidad = periodicidad;
    	this.estaFinalizado = false;
    }
    
    public TratamientoMedico() {
		// TODO Auto-generated constructor stub
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<Accion> getAcciones() {
		return acciones;
	}

	public void setAcciones(List<Accion> acciones) {
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

}