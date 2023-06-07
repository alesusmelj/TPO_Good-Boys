package Modelo;

import java.util.*;

/**
 * 
 */
public abstract class Usuario {

    /**
     * Default constructor
     */
    public Usuario() {
    }


    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String password;
    private IAdapterAutenticador autenticacion;
    private EtipoUsuario tipoUsuario;

    public boolean autenticar(String usuario, String password, EtipoUsuario tipoUsuario) {
        // TODO implement here
        return false;
    }

}