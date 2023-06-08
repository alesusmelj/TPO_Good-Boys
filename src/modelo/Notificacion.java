package modelo;

import java.util.*;

/**
 * 
 */
public class Notificacion {

    public Notificacion() {
    }

    private String mensaje;
    private Date fecha;
    private Cliente cliente;
    private int diasPreferencia;
    
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}