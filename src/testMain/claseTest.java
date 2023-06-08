package testMain;

import modelo.Veterinario;
import adapterAutentificador.Autenticador;
import adapterAutentificador.IAdapterAutenticador;
import modelo.Usuario;

public class claseTest {

	public static void main(String[] args) {
		
		//Autenticador
		IAdapterAutenticador autenticacion = new Autenticador();
		//Agregamos un veterinario y seteamos su adapter de autenticacion y lo agregamos a la lista de usuarios
		Veterinario juan = new Veterinario("Juan","Martinez","juan2023","12345");
		juan.setAdapter(autenticacion);
		Utilidades.setUsuario(juan);
		//Agregamos otro veterinario y seteamos su adapter de autenticacion y lo agregamos a la lista de usuarios
		Veterinario maria = new Veterinario("Maria","Gomez","maria2023","6789");
		maria.setAdapter(autenticacion);
		Utilidades.setUsuario(maria);
		
		//Autenticación de Veterinarios
		juan.autenticar("juan2023","12345", juan.getTipoUsuario());
		maria.autenticar("maria2023","6789", maria.getTipoUsuario());
		juan.cerrarSesion();
		maria.autenticar("maria2023","6789", maria.getTipoUsuario());
		//Autenticacion de Visitadores
	}

}
