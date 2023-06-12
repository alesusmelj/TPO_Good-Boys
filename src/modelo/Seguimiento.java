package modelo;

import java.time.LocalTime;
import java.util.*;

import estadoSeguimiento.EnCurso;
import estadoSeguimiento.EstadoSeguimiento;
import testMain.Utilidades;

public class Seguimiento implements EstadoSeguimiento {

    private Visitador responsableSeguimiento;
    private CadenciaVisitas cadenciaVisitas;
    private EstadoSeguimiento estado;
    private List<Visita> visitas;
    private Notificador notificador;
    private Adopcion adopcion;
    

    public Seguimiento(Visitador responsableSeguimiento) {
    	this.responsableSeguimiento = responsableSeguimiento;
    	this.notificador = new Notificador();
    	this.estado = new EnCurso();
    	this.visitas = new ArrayList();
    }

    public void cambiarEstado(EstadoSeguimiento estado) {
    	this.estado = estado;
    }
    public void realizarSeguimiento() {
    }

    public void finalizarVisita(Visita visita) {
    }
    public void enviar() {
    }
	@Override
	public void realizarSeguimiento(Seguimiento segumiento) {
		this.estado.realizarSeguimiento(segumiento);
	}

	public Notificador getNotificador() {
		return notificador;
	}

	public void setNotificador(Notificador notificador) {
		this.notificador = notificador;
	}


	public CadenciaVisitas getCadenciaVisitas() {
		return cadenciaVisitas;
	}


	public void setCadenciaVisitas(CadenciaVisitas cadenciaVisitas) {
		this.cadenciaVisitas = cadenciaVisitas;
	}

	@Override
	public String toString() {
		return "Seguimiento [responsableSeguimiento=" + responsableSeguimiento + ", cadenciaVisitas=" + cadenciaVisitas
				+ ", estado=" + estado + ", visitas=" + visitas + "]";
	}

	public List<Visita> getVisitas() {
		return visitas;
	}

	public void setVisitas(Visita visita) {
		this.visitas.add(visita);
	}

	public Visitador getResponsableSeguimiento() {
		return responsableSeguimiento;
	}

	public void setResponsableSeguimiento(Visitador responsableSeguimiento) {
		this.responsableSeguimiento = responsableSeguimiento;
	}

	public EstadoSeguimiento getEstado() {
		return estado;
	}

	public void setEstado(EstadoSeguimiento estado) {
		this.estado = estado;
	}

	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;	
	}
	
	public Adopcion getAdopcion() {
		return adopcion;
	}

	public void setAdopcion(Adopcion adopcion) {
		this.adopcion = adopcion;
	}
	
}