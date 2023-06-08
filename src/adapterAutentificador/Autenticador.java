package adapterAutentificador;

import java.util.*;

import modelo.EtipoUsuario;
import modelo.Usuario;
import testMain.Utilidades;

public class Autenticador implements IAdapterAutenticador {

    public Autenticador() {
    }
    public void autenticar(String usuario, String password, EtipoUsuario tipoUsuario) {
    	boolean iniciadoAux = false;
    	int contadorAux = 0;
    	System.out.println("Iniciando sesi�n...");
    	for(Usuario u:Utilidades.getUsuarios()) {
    		contadorAux++;
    	if(iniciadoAux == false) {
	    		if(u.isAutenticado() == false) {
		    		if(u.getNombreUsuario() == usuario && u.getPassword() == password) {
		    			if(u.isAutenticado() == false) {
			    			System.out.println("El usuario: "+usuario+"("+tipoUsuario+")"+" ha iniciado sesi�n correctamente.");
			    			u.setAutenticado(true);
			    			iniciadoAux = true;
		    			}
		    			else if(u.isAutenticado() == true) {
		    				System.out.println("El usuario ya est� conectado");
		    			}
		    		}
		    		else if(Utilidades.getUsuarios().size() == contadorAux && u.isAutenticado() == false) {
		    			System.out.println("El usuario o la contrase�a es incorrecta");
		    		}
	    		}
	    		else if(u.isAutenticado() == true) {
	    			System.out.println("No es posible iniciar sesi�n, ya hay una sesi�n activa.");
	    			iniciadoAux = true;
	    		}
	    	}
    	}

    }
}