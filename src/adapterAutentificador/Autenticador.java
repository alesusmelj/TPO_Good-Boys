package adapterAutentificador;

import java.util.*;

import modelo.EtipoUsuario;

/**
 * 
 */
public class Autenticador {

    public Autenticador() {
    }
    public boolean autenticar(String usuario, String password, EtipoUsuario tipoUsuario) {
        if (usuario != null) {
        	return true;
        }
        return false;
    }

}