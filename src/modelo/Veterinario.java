package modelo;

import java.util.*;

import testMain.Utilidades;

/**
 * 
 */
public class Veterinario extends Usuario {

    public Veterinario(String nombre,String apellido, String nombreUsuario, String password) {
    	super(nombre, apellido, nombreUsuario, password);
    	this.nombre = nombre;
    	this.apellido = apellido;
    	this.nombreUsuario = nombreUsuario;
    	this.password = password;
    	this.nroMatricula = Utilidades.contadorNumeroMatricula();
    	this.tipoUsuario = EtipoUsuario.VETERINARIO;
    }
    private int nroMatricula;
    private EtipoUsuario tipoUsuario;
    
	public int getNroMatricula() {
		return nroMatricula;
	}

	public EtipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	@Override
	public String toString() {
		return "Nombre: "+nombre+" Apellido: "+apellido+" nombreUsuario: "+nombreUsuario+" password: "+password+" Nro matricula: "+nroMatricula;
	}

}