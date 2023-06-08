package modelo;

import java.util.*;

import adapterAutentificador.IAdapterAutenticador;

/**
 * 
 */
public abstract class Usuario {
    protected String nombre;
    protected String apellido;
    protected String nombreUsuario;
    protected String password;
    protected IAdapterAutenticador autenticacion;
    protected EtipoUsuario tipoUsuario;
	
    public Usuario(String nombre,String apellido, String nombreUsuario, String password) {
    };

    public boolean autenticar(String usuario, String password, EtipoUsuario tipoUsuario) {
        // TODO implement here
        return false;
    }

}