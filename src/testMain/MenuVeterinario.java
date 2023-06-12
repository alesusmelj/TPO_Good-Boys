package testMain;

import java.util.Scanner;

import adapterAutentificador.Autenticador;
import adapterAutentificador.IAdapterAutenticador;
import controllers.AlarmaController;
import controllers.AnimalController;
import estadoCondicionMedica.Saludable;
import estrategiaExportacion.AdapterExcel;
import estrategiaExportacion.AdapterPDF;
import estrategiaExportacion.ExportarExcel;
import estrategiaExportacion.ExportarPDF;
import estrategiaExportacion.IExportar;
import modelo.Alarma;
import modelo.Animal;
import modelo.AnimalDomestico;
import modelo.AnimalSalvaje;
import modelo.Especie;
import modelo.EtipoAnimal;
import modelo.Exportador;
import modelo.FichaTecnica;
import modelo.Refugio;
import modelo.TratamientoMedico;
import modelo.Veterinario;

public class MenuVeterinario {

	public void MenuPrincipal() {
		//---------------CREACION DE ESPECIES PARA LAS PRUEBAS-------------------
		Especie perro = new Especie("Perro",EtipoAnimal.DOMESTICO);
		Refugio.getInstance().setEspecies(perro);
		Especie gato = new Especie("Gato",EtipoAnimal.DOMESTICO);
		Refugio.getInstance().setEspecies(gato);
		Especie canario = new Especie("Canario",EtipoAnimal.DOMESTICO);
		Refugio.getInstance().setEspecies(canario);
		Especie loro = new Especie("Loro",EtipoAnimal.DOMESTICO);
		Refugio.getInstance().setEspecies(loro);
		Especie tortuga = new Especie("Tortuga",EtipoAnimal.DOMESTICO);
		Refugio.getInstance().setEspecies(tortuga);
		Especie zorro = new Especie("Zorro",EtipoAnimal.SALVAJE);
		Refugio.getInstance().setEspecies(zorro);
		Especie pinguino = new Especie("Pinguino",EtipoAnimal.SALVAJE);
		Refugio.getInstance().setEspecies(pinguino);
		Especie halcon = new Especie("Halcon",EtipoAnimal.SALVAJE);
		Refugio.getInstance().setEspecies(halcon);
		//--------------ANIMALES PARA PRUEBA ------------------------
        Animal primerGato = new AnimalDomestico(gato,15,3,5);
        FichaTecnica fichaTecnicGato = new FichaTecnica(primerGato);
        primerGato.setFichaTecnica(fichaTecnicGato);
        Refugio.getInstance().setAnimales(primerGato);
        primerGato.cambiarEstado(new Saludable());
        Animal primerTortuga = new AnimalDomestico(tortuga,7,9,17);
        FichaTecnica fichaTecnicaTortuga = new FichaTecnica(primerTortuga);
        primerTortuga.setFichaTecnica(fichaTecnicaTortuga);
        Refugio.getInstance().setAnimales(primerTortuga);
        Animal primerZorro = new AnimalSalvaje(zorro, 20, 5, 7);
        FichaTecnica fichaTecnicaZorro = new FichaTecnica(primerZorro);
        primerZorro.setFichaTecnica(fichaTecnicaZorro);
        Refugio.getInstance().setAnimales(primerZorro);
        primerZorro.cambiarEstado(new Saludable());
        Animal primerHalcon = new AnimalSalvaje(halcon, 19, 29, 20);
        FichaTecnica fichaTecnicaHalcon = new FichaTecnica(primerHalcon);
        primerHalcon.setFichaTecnica(fichaTecnicaHalcon);
        Refugio.getInstance().setAnimales(primerHalcon);	
		//-------------CREACION DE CLASES PARA LAS PRUEBAS VETERINARIO-----------
        IAdapterAutenticador autenticacion = new Autenticador();
        Veterinario juan = new Veterinario("Juan","Martinez","juan2023","12345");
        Veterinario maria = new Veterinario("Maria","Gomez","maria2023","6789");
		maria.setAdapter(autenticacion);
		juan.setAdapter(autenticacion);
		//--------------CONTROLADORES QUE SE VAN A UTILIZAR--------------------
		AnimalController animalController = new AnimalController();
		AlarmaController alarmaController = new AlarmaController();
		//-----------------EXPORTADOR---------------------------------------------
		Exportador exportador = new Exportador();
		IExportar exportarPDF = new ExportarPDF(new AdapterPDF());
		IExportar exportarExcel = new ExportarExcel(new AdapterExcel());
		//---------------VARIABLES A UTILIZAR-----------------------------------
		Scanner sc = new Scanner(System.in);
		char opcion;
        //-------------VETERINARIO MOCKEADO CON INICIO DE SESION----------------
        System.out.println("-------REFUGIO GUD BOY-------");
        Refugio.getInstance().setUsuario(juan);
		juan.autenticar("juan2023","12345", juan.getTipoUsuario());
		while(true) {
		System.out.println("---------------------------------------");
		System.out.println("------------------MENU-----------------");
		System.out.println("1-Ingresar un nuevo animal al refugio");
		System.out.println("2-Visualizar animales del refugio");
		System.out.println("3-Visualizar alarmas/notificaciones pendientes de atender");
		System.out.println("Presione 0 para salir del programa");
		opcion = sc.nextLine().charAt(0);
		switch(opcion) {
		case '1':
			System.out.println("Ha seleccionado la opcion para ingresar un nuevo animal");
			animalController.ingresarAnimal();
			boolean salirOpcion1 = false;
			while(!salirOpcion1) {
				System.out.println("a-Ingresar otro animal");
				System.out.println("b-Volver al menu principal");
				char opcionOpcion1 = sc.nextLine().charAt(0);
				switch(opcionOpcion1) {
				case 'a':
					System.out.println("Ha seleccionado la opcion para ingresar otro animal");
					animalController.ingresarAnimal();
					break;
				case 'b':
					salirOpcion1 = true;
					break;
				default:
					System.out.println("Opcion invalida. Intente nuevamente");
				}
			}
			break;
		case '2':
			System.out.println("Ha seleccionado la opcion para visualizar los animales del refugio");
			if(Refugio.getInstance().getAnimales().size() != 0) {
				Refugio.getInstance().listarAnimales();
			}
			else {
				System.out.println("No hay animales en el refugio.");
			}
			boolean salirOpcion2 = false;
			while(!salirOpcion2) {
				System.out.println("a-Exportar la ficha tecnica de un animal");
				System.out.println("b-Crear una nueva alarma de control para un animal");
				System.out.println("c-Crear una nueva alarma de tratamiento medico para un animal");
				System.out.println("d-Volver al menu principal");
				char opcionOpcion2 = sc.nextLine().charAt(0);
				switch(opcionOpcion2) {
					case 'a':
						if(Refugio.getInstance().getAnimales().size() != 0) {
						System.out.println("Ha seleccionado la opcion para exportar la ficha tecnica de un animal");
						System.out.println("Ingrese el id del animal que desea exportar su ficha tecnica");
						Scanner sc2 = new Scanner(System.in);
						int opcionId = sc2.nextInt();
						System.out.println("1-Exportar en PDF");
						System.out.println("2-Exportar en Excel");
						Scanner sc3 = new Scanner(System.in);
						int opcionExp = sc3.nextLine().charAt(0);
						switch(opcionExp) {
							case '1': exportador.cambiarEstrategia(exportarPDF);
									exportador.exportar(Refugio.getInstance().buscarAnimal(opcionId).getFichaTecnica());
									break;
							case '2': exportador.cambiarEstrategia(exportarExcel);
									  exportador.exportar(Refugio.getInstance().buscarAnimal(opcionId).getFichaTecnica());
									  break;
						}
					}
					else {
						System.out.println("No hay animales en el refugio.");
					}
						break;
					case 'b':
						if(Refugio.getInstance().getAnimales().size() != 0) {
						System.out.println("Ha seleccionado la opcion para crear una alarma de control para un animal");
						System.out.println("Ingrese el id del animal");
						Scanner sc2 = new Scanner(System.in);
						int opcionId = sc2.nextInt();
						alarmaController.crearAlarmaControl(Refugio.getInstance().buscarAnimal(opcionId));
						}
					else {
						System.out.println("No hay animales en el refugio.");
						}
						break;
					case 'c':
						if(Refugio.getInstance().getAnimales().size() != 0) {
						System.out.println("Ha seleccionado la opcion para crear una alarma de tratamiento medico para un animal");
						System.out.println("Ingrese el id del animal");
						Scanner sc2 = new Scanner(System.in);
						int opcionId = sc2.nextInt();
						alarmaController.crearAlarmaTratamientoMedico(Refugio.getInstance().buscarAnimal(opcionId));
						}
					else {
						System.out.println("No hay animales en el refugio.");
						}
						break;	
					case 'd':
						salirOpcion2 = true;
						break;
					default:
						System.out.println("Opcion invalida. Intente nuevamente");
				}
			}
			break;
		case '3': 
			System.out.println("Ha seleccionado la opcion para visualizar las alarmas pendientes");
			if(Refugio.getInstance().getAlarmas().size() != 0) {
				Refugio.getInstance().listarAlarmas();
			}
			else {
				System.out.println("No hay ninguna alarma/notificacion pendiente de atencion");
			}
			boolean salirOpcion3 = false;
			while(!salirOpcion3) {
				System.out.println("a-Atender una alarma");
				System.out.println("b-Volver al menu principal");
				char opcionOpcion3 = sc.nextLine().charAt(0);
				switch(opcionOpcion3) {
					case 'a':
						if(Refugio.getInstance().getAlarmas().size() != 0) {
							System.out.println("Ha seleccionado la opcion para atender una alarma pendiente de un animal");
							System.out.println("Ingrese el id del animal");
							Scanner sc2 = new Scanner(System.in);
							Scanner sc3 = new Scanner(System.in);
							int opcionId = sc2.nextInt();
							System.out.println("Ingrese el numero de la lista de la alarma que desea atender");
							int opcionAlarma = sc3.nextInt() - 1;
							Alarma alarma = Refugio.getInstance().getAlarmas().get(opcionAlarma);
							if(alarma.getTipo().getClass().equals(TratamientoMedico.class)) {
								alarmaController.atenderTratamientoMedico((Veterinario) Refugio.getInstance().getUserConectado(),alarma,
										Refugio.getInstance().buscarAnimal(opcionId));
							}
							else if(alarma.getTipo().getClass().equals(modelo.Control.class)){
								alarmaController.atenderControl((Veterinario) Refugio.getInstance().getUserConectado(), alarma,
										Refugio.getInstance().buscarAnimal(opcionId));
							}
						}
					else {
						System.out.println("No hay alarmas/notificaciones pendientes de atencion.");
						};
						break;
					case 'b':
						salirOpcion3 = true;
						break;
					default:
						System.out.println("Opcion invalida. Intente nuevamente");
				}
			}
			break;
		case '0': 
			System.out.println("Saliendo del programa...");
			return;
		default:
			System.out.println("Opcion invalida. Intente nuevamente");
		}
	
		}

	}
}
