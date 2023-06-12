package testMain;

import adapterAutentificador.Autenticador;
import adapterAutentificador.IAdapterAutenticador;
import modelo.Refugio;
import modelo.Veterinario;

public class MenuVeterinario {

	public void MenuPrincipal() {
		//-------------CREACION DE CLASES PARA LAS PRUEBAS VETERINARIO------------
        IAdapterAutenticador autenticacion = new Autenticador();
        Veterinario juan = new Veterinario("Juan","Martinez","juan2023","12345");
        Veterinario maria = new Veterinario("Maria","Gomez","maria2023","6789");
        //--------------AUTENTICACION DE USUARIOS-------------------------------
		maria.setAdapter(autenticacion);
        //-------------VETERINARIO MOCKEADO CON INICIO DE SESION------------
        System.out.println("-------REFUGIO GUD BOY-------");
		juan.setAdapter(autenticacion);
		Refugio.setUsuario(juan);
		juan.autenticar("juan2023","12345", juan.getTipoUsuario());
		System.out.println("------------------------------------");
		System.out.println("----------MENU----------");
		System.out.println("1-Ingesar un nuevo animal al refugio\n"
				+ "2-Exportar la ficha tecnica de un animal");
	}
}
