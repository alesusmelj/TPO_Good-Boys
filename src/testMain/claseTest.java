package testMain;

import modelo.Veterinario;
import adapterAutentificador.Autenticador;
import modelo.Usuario;

public class claseTest {

	public static void main(String[] args) {
		
		//Autenticador
		Autenticador autenticador = new Autenticador();
		//Agregamos un veterinario
		Veterinario juan = new Veterinario("Juan","Martinez","juan2023","12345");
		Utilidades.setUsuario(juan);
		Veterinario maria = new Veterinario("Maria","Gomez","maria2023","6789");
		Utilidades.setUsuario(maria);
		System.out.println(juan);
		System.out.println(maria);
		System.out.println(Utilidades.getUsuarios());
		autenticador.autenticar("juan2023","12345",juan.getTipoUsuario());
	}

}
