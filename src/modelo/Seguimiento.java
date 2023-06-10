package modelo;

import java.util.*;

import estadoSeguimiento.EstadoSeguimiento;

public class Seguimiento implements EstadoSeguimiento {


    public Seguimiento(Visitador responsableSeguimiento,CadenciaVisitas cadenciaVisitas) {
    	this.responsableSeguimiento = responsableSeguimiento;
    	this.cadenciaVisitas = cadenciaVisitas;
    }

    private Visitador responsableSeguimiento;
    private CadenciaVisitas cadenciaVisitas;
    private EstadoSeguimiento estado;
    private List<Visita> visitas;
    
    public Notificador notificador;


    public void cambiarEstado() {
    }


    public void realizarSeguimiento() {
    }


    public void enviarEncuesta() {
    }


    public void finalizarVisita(Visita visita) {
    }


    public void enviar() {
    }


	@Override
	public void realizarSeguimiento(Seguimiento segumiento) {
		
	}


	@Override
	public void enviarEncuesta(Seguimiento seguimiento) {
		
	}


	public Notificador getNotificador() {
		return notificador;
	}


	public void setNotificador(Notificador notificador) {
		this.notificador = notificador;
	}

}