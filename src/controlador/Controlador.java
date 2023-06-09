package controlador;

import modelo.CadenciaVisitas;

public class Controlador {
	private static Controlador instancia;
	private Controlador() {
		
	}
	public static Controlador getInstancia() {
		if(instancia==null)
			instancia = new Controlador();
		return instancia;
	}
	
	public void SolicitudAdopcion() {
		
	}
}
