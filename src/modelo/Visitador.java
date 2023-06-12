package modelo;

import java.util.*;

public class Visitador extends Usuario {
	
    private EtipoUsuario tipoUsuario;

    public Visitador(String nombre,String apellido, String nombreUsuario, String password) {
    	super(nombre, apellido, nombreUsuario, password);
    	this.tipoUsuario = EtipoUsuario.VISITADOR;
    }

    public void completarEncuesta(EncuestaVisitador encuesta) {
    }

	@Override
	public String toString() {
		return "Visitador " + nombre + "[tipoUsuario=" + tipoUsuario + "]";
	}
    
}