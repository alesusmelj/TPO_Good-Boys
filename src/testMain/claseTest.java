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

		Mock mock = new Mock();
		mock.ingresoMock();
		Animal primerGato = mock.primerGato;
		Animal primerZorro = mock.primerZorro;
		Animal primerTortuga = mock.primerTortuga;
		Animal primerHalcon = mock.primerHalcon;
		Veterinario juan = mock.juan;
		Veterinario maria = mock.maria;
		Visitador humberto = mock.humberto;
		Visitador pedro = mock.pedro;
		Cliente pablo = mock.pablo;
		Cliente matias = mock.matias;
		Cliente claudio = mock.claudio;

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

		//Autenticación de Veterinarios
		juan.autenticar("juan2023","12345", juan.getTipoUsuario());
		System.out.println(Refugio.getUserConectado());

		//pablo.solicitarAdopcion(primerGato,humberto,new CadenciaVisitas(EDiaVisita.LUNES),EpreferenciaRecordatorio.SMS);
		
		primerGato.recuperar(primerGato);
		primerGato.recuperar(primerGato);
		primerGato.recuperar(primerGato);
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
//		Utilidades.esperar(15);
//		Utilidades.timer.cancel(); // podemos usar esto cuando el veterinario pasa a finalizado un tratamiento
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
