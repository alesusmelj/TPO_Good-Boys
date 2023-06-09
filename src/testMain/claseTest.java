package testMain;

import modelo.Veterinario;
import modelo.Visitador;
import adapterAutentificador.Autenticador;
import adapterAutentificador.IAdapterAutenticador;
import estrategiaAdapterNotificacion.AdapterSMS;
import estrategiaAdapterNotificacion.EstrategiaDeNotificacion;
import estrategiaAdapterNotificacion.NotificacionPorSMS;
import estrategiaAdapterNotificacion.NotificacionPorWhatsApp;
import estrategiaAdapterNotificacion.NotificacionPorEmail;
import estrategiaAdapterNotificacion.AdapterWhatsApp;
import estrategiaAdapterNotificacion.AdapterEmail;

import modelo.Animal;
import modelo.AnimalDomestico;
import modelo.CadenciaVisitas;
import modelo.Cliente;
import modelo.EDiaVisita;
import modelo.EpreferenciaRecordatorio;
import modelo.Especie;
import modelo.EtipoAnimal;
import modelo.Notificacion;
import modelo.Notificador;
import modelo.Usuario;

public class claseTest {

	public static void main(String[] args) {
		//---Notificador---
		Notificador notificador = new Notificador();
		EstrategiaDeNotificacion notificadorSMS = new NotificacionPorSMS(new AdapterSMS());
		EstrategiaDeNotificacion notificadorWhatsApp = new NotificacionPorWhatsApp(new AdapterWhatsApp());
		EstrategiaDeNotificacion notificadorEmail = new NotificacionPorEmail(new AdapterEmail());
		//----Autenticador----
		IAdapterAutenticador autenticacion = new Autenticador();
		//Agregamos un veterinario y seteamos su adapter de autenticacion y lo agregamos a la lista de usuarios
		Veterinario juan = new Veterinario("Juan","Martinez","juan2023","12345");
		juan.setAdapter(autenticacion);
		Utilidades.setUsuario(juan);
		//Agregamos otro veterinario y seteamos su adapter de autenticacion y lo agregamos a la lista de usuarios
		Veterinario maria = new Veterinario("Maria","Gomez","maria2023","6789");
		maria.setAdapter(autenticacion);
		Utilidades.setUsuario(maria);		
		//Agregamos visitador y seteamos su adapter de autenticacion y lo agregamos a la lista de usuarios
		Visitador humberto = new Visitador("Humberto","Felk","humberto2023","123");
		humberto.setAdapter(autenticacion);
		Utilidades.setUsuario(humberto);		
		//Autenticación de Veterinarios
		juan.autenticar("juan2023","12345", juan.getTipoUsuario());
		maria.autenticar("maria2023","6789", maria.getTipoUsuario());
		juan.cerrarSesion();
		maria.autenticar("maria2023","6789", maria.getTipoUsuario());
		//Autenticacion de Visitadores
		
		
		//Creacion de especies
		Especie perro = new Especie("Perro",EtipoAnimal.DOMESTICO);
		Especie gato = new Especie("Gato",EtipoAnimal.DOMESTICO);
		Especie canario = new Especie("Canario",EtipoAnimal.DOMESTICO);
		Especie loro = new Especie("Canario",EtipoAnimal.DOMESTICO);
		Especie tortuga = new Especie("Canario",EtipoAnimal.DOMESTICO);
		Especie zorro = new Especie("Zorro",EtipoAnimal.SALVAJE);
		Especie pinguino = new Especie("Pingüino",EtipoAnimal.SALVAJE);
		Especie halcon = new Especie("Halcón",EtipoAnimal.SALVAJE);
		
		//Creacion de Animal
		Animal primerGato = new AnimalDomestico(gato,15,3,5);
		Utilidades.esperar(2);
		System.out.println("Acaba de ingresar un animal al refugio");
		System.out.println(primerGato.toString());
		//Creacion de Cliente
		Cliente pablo = new Cliente("pablo","diaz","soltero","pablodiaz@gmail.com","12345","empleado",false,"quiero adoptar",gato,0);
		Utilidades.esperar(2);
		System.out.println("Acaba de ingresar un cliente al refugio interesado por adoptar un animal");
		primerGato.setSaludable(true);
		Utilidades.esperar(2);
		pablo.solicitarAdopcion(primerGato,humberto,new CadenciaVisitas(EDiaVisita.LUNES),EpreferenciaRecordatorio.SMS);
		Notificacion notificacion = new Notificacion("que onda amigo",pablo,2);
		
		switch(pablo.getPreferenciaRecordatorio()) {
		case SMS: notificador.cambiarEstrategiaNotificacion(notificadorSMS); break;
		case WHATSAPP: notificador.cambiarEstrategiaNotificacion(notificadorWhatsApp); break;
		case EMAIL: notificador.cambiarEstrategiaNotificacion(notificadorEmail); break;
		}
		System.out.println(notificacion.toString());
		notificador.enviar(notificacion);
	}
}
