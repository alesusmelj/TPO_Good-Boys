package modelo;

import java.util.*;

import adapterAutentificador.IAdapterAutenticador;

/**
 * 
 */
public abstract class Usuario implements IAdapterAutenticador {
    protected String nombre;
    protected String apellido;
    protected String nombreUsuario;
    protected String password;
    protected IAdapterAutenticador autenticacion;
    protected EtipoUsuario tipoUsuario;
	
    public Usuario(String nombre,String apellido, String nombreUsuario, String password) {
    };

    public void autenticar(String usuario, String password, EtipoUsuario tipoUsuario) {
    	this.autenticacion.autenticar(usuario, password,tipoUsuario);
    }

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EtipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(EtipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}