package adapterAutentificador;

import java.util.*;

import modelo.EtipoUsuario;
import modelo.Usuario;
import testMain.Utilidades;

public class Autenticador implements IAdapterAutenticador {

    public Autenticador() {
    }
    public void autenticar(String usuario, String password, EtipoUsuario tipoUsuario) {
    	int contadorAux = 0;
    	for(Usuario u:Utilidades.getUsuarios()) {
    		contadorAux++;
	    		if(u.getNombreUsuario() == usuario && u.getPassword() == password) {
	    			System.out.println("El usuario: "+usuario+"("+tipoUsuario+")"+" ha iniciado sesión correctamente.");
	    		}
	    		else if(Utilidades.getUsuarios().size() - 1 == contadorAux) {
	    			System.out.println("El usuario o la contraseña es incorrecta");
	    		}
    	}

    }
}