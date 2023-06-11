package testMain;

import adapterAutentificador.Autenticador;
import adapterAutentificador.IAdapterAutenticador;
import controllers.AdopcionController;
import controllers.AlarmaController;
import controllers.AnimalController;
import controllers.ClienteController;
import estrategiaAdapterNotificacion.AdapterEmail;
import estrategiaAdapterNotificacion.AdapterSMS;
import estrategiaAdapterNotificacion.AdapterWhatsApp;
import estrategiaAdapterNotificacion.EstrategiaDeNotificacion;
import estrategiaAdapterNotificacion.NotificacionPorEmail;
import estrategiaAdapterNotificacion.NotificacionPorSMS;
import estrategiaAdapterNotificacion.NotificacionPorWhatsApp;
import estrategiaExportacion.AdapterExcel;
import estrategiaExportacion.AdapterPDF;
import estrategiaExportacion.ExportarExcel;
import estrategiaExportacion.ExportarPDF;
import estrategiaExportacion.IExportar;
import modelo.Alarma;
import modelo.Animal;
import modelo.AnimalDomestico;
import modelo.AnimalSalvaje;
import modelo.CadenciaVisitas;
import modelo.Cliente;
import modelo.EDiaVisita;
import modelo.EpreferenciaRecordatorio;
import modelo.Especie;
import modelo.EtipoAnimal;
import modelo.Exportador;
import modelo.Notificacion;
import modelo.Notificador;
import modelo.Refugio;
import modelo.TratamientoMedico;
import modelo.Veterinario;
import modelo.Visitador;

public class claseTest {

	public static void main(String[] args) {

		//--Controladores--
		ClienteController clienteController = new ClienteController();
		AnimalController animalController = new AnimalController();
		AdopcionController adopcionController = new AdopcionController();
		AlarmaController alarmaController = new AlarmaController();

		//---Notificador---
		Notificador notificador = new Notificador();
		EstrategiaDeNotificacion notificadorSMS = new NotificacionPorSMS(new AdapterSMS());
		EstrategiaDeNotificacion notificadorWhatsApp = new NotificacionPorWhatsApp(new AdapterWhatsApp());
		EstrategiaDeNotificacion notificadorEmail = new NotificacionPorEmail(new AdapterEmail());

		//---Exportador---
		Exportador exportador = new Exportador();
		IExportar exportarPDF = new ExportarPDF(new AdapterPDF());
		IExportar exportarExcel = new ExportarExcel(new AdapterExcel());

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

		//Autenticaci�n de Veterinarios
		juan.autenticar("juan2023","12345", juan.getTipoUsuario());
		System.out.println(Refugio.getUserConectado());
		//Autenticacion de Visitadores
		//Creacion de especies
		Especie perro = new Especie("Perro",EtipoAnimal.DOMESTICO);
		Refugio.especies.add(perro);
		Especie gato = new Especie("Gato",EtipoAnimal.DOMESTICO);
		Refugio.especies.add(gato);
		Especie canario = new Especie("Canario",EtipoAnimal.DOMESTICO);
		Refugio.especies.add(canario);
		Especie loro = new Especie("Loro",EtipoAnimal.DOMESTICO);
		Refugio.especies.add(loro);
		Especie tortuga = new Especie("Tortuga",EtipoAnimal.DOMESTICO);
		Refugio.especies.add(tortuga);
		Especie zorro = new Especie("Zorro",EtipoAnimal.SALVAJE);
		Refugio.especies.add(zorro);
		Especie pinguino = new Especie("Ping�ino",EtipoAnimal.SALVAJE);
		Refugio.especies.add(pinguino);
		Especie halcon = new Especie("Halc�n",EtipoAnimal.SALVAJE);
		Refugio.especies.add(halcon);
		
		//Creacion de Animal
		Animal primerGato = new AnimalDomestico(gato,15,3,5);
		Utilidades.esperar(2);
		System.out.println("Acaba de ingresar un animal al refugio");
		System.out.println(primerGato.toString());

		Animal primerZorro = new AnimalSalvaje(zorro, 15, 5, 3);
		Utilidades.esperar(2);
		System.out.println("Acaba de ingresar un animal al refugio.");
		System.out.println(primerZorro.toString());
		
		//Creacion de Cliente
		Cliente pablo = new Cliente("pablo","diaz","soltero","pablodiaz@gmail.com","12345","empleado",false,"quiero adoptar","Gato",0);
		Utilidades.esperar(2);
		System.out.println("Acaba de ingresar un cliente al refugio interesado por adoptar un animal");
		Utilidades.esperar(2);
		//pablo.solicitarAdopcion(primerGato,humberto,new CadenciaVisitas(EDiaVisita.LUNES),EpreferenciaRecordatorio.SMS);
		
		System.out.println();
		System.out.println("TEST SALVAJES");
		primerZorro.serAdoptado(primerZorro);
		primerZorro.recuperar(primerZorro);
		primerZorro.serAdoptado(primerZorro);
		System.out.println();
		System.out.println("TEST DOMESTICOS");
		primerGato.serAdoptado(primerGato);
		primerGato.recuperar(primerGato);
		primerGato.serAdoptado(primerGato);

		Animal animal = animalController.ingresarAnimal();
		animal.recuperar(animal);
		System.out.println(animal.toString());
		exportador.cambiarEstrategia(exportarExcel);
		exportador.exportar(animal.getFichaTecnica());
		adopcionController.crearAdopcion(pablo, animal, humberto, new CadenciaVisitas(EDiaVisita.JUEVES));
		Notificacion notificacion = new Notificacion("que onda amigo",pablo,2);
		switch(pablo.getPreferenciaRecordatorio()) {
			case SMS: notificador.cambiarEstrategiaNotificacion(notificadorSMS); break;
			case WHATSAPP: notificador.cambiarEstrategiaNotificacion(notificadorWhatsApp); break;
			case EMAIL: notificador.cambiarEstrategiaNotificacion(notificadorEmail); break;
		}
		System.out.println(notificacion.toString());
		notificador.enviar(notificacion);
		Alarma alarma = alarmaController.crearAlarmaTratamientoMedico(animal);
		TratamientoMedico trat = (TratamientoMedico) alarma.getTipo();
		Utilidades.esperar(15);
		Utilidades.timer.cancel(); // podemos usar esto cuando el veterinario pasa a finalizado un tratamiento
//		Cliente cliente2 = clienteController.crearCliente();
//		System.out.println(cliente2.toString());
		
	}
//	public void solicitarAutenticacion() {
//    	Scanner entrada = new Scanner(System.in);
//    	System.out.println("------------BIENVENIDO A GUD BOY, POR FAVOR INICE SESI�N----------");
//		System.out.println("Ingrese su nombre de usuario: ");  
//		String usuario = entrada.nextLine();
//		System.out.println("Ingrese su contrase�a: ");  
//		String password = entrada.nextLine();
//		System.out.println("Seleccione su rol: \n 1-Veterinario\n 2-Visitador");
//		String seleccion = entrada.nextLine();
//		EtipoUsuario tipoUsuario = EtipoUsuario.VETERINARIO;
//		tipoUsuario = seleccion.contentEquals("1")  ? EtipoUsuario.valueOf("VETERINARIO")
//				: EtipoUsuario.valueOf("VISITADOR");
//	}
}
