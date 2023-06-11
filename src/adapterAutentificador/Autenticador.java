package adapterAutentificador;

import java.util.*;
import modelo.EtipoUsuario;
import modelo.Refugio;
import modelo.Usuario;
import testMain.Utilidades;

public class Autenticador implements IAdapterAutenticador {

    public Autenticador() {
	}

    public void autenticar(String usuario, String password, EtipoUsuario tipoUsuario) {

    	boolean iniciadoAux = false;
    	int contadorAux = 0;
    	System.out.println("Iniciando sesión...");
    	Utilidades.esperar(1);

    	for(Usuario u:Refugio.getUsuarios()) {
    		contadorAux++;

			if(iniciadoAux == false) {
				
				if(u.isAutenticado() == false) {
					if(u.getNombreUsuario() == usuario && u.getPassword() == password) {
						if(u.isAutenticado() == false) {
							
							System.out.println("El usuario: " + usuario + " (" + tipoUsuario + ")" + " ha iniciado sesión correctamente.");
							u.setAutenticado(true);
							Refugio.setUserConectado(u);
							iniciadoAux = true;
						}

						else if(u.isAutenticado() == true) {
							System.out.println("El usuario ya está conectado.");
						}
					}

					else if(Refugio.getUsuarios().size() == contadorAux && u.isAutenticado() == false) {
						System.out.println("El usuario o la contraseña es incorrecta.");
					}
				}

				else if(u.isAutenticado() == true) {
					System.out.println("No es posible iniciar sesión, ya hay una sesión activa.");
					iniciadoAux = true;
				}
			}
    	}
    }
}
