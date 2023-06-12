package testMain;

import java.util.Scanner;

import adapterAutentificador.Autenticador;
import adapterAutentificador.IAdapterAutenticador;
import controllers.AdopcionController;
import controllers.AnimalController;
import controllers.ClienteController;
import estadoCondicionMedica.Saludable;
import modelo.Animal;
import modelo.AnimalDomestico;
import modelo.AnimalSalvaje;
import modelo.Cliente;
import modelo.Especie;
import modelo.EtipoAnimal;
import modelo.FichaTecnica;
import modelo.Refugio;
import modelo.Seguimiento;
import modelo.Visita;
import modelo.Visitador;

public class MenuVisitador {
	
	public void menuVisitador() {
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
		//--------------ANIMALES PARA PRUEBA ADOPCION------------------------
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
		//-------------CREACION DE CLASES PARA LAS PRUEBAS VISITADOR----------
        IAdapterAutenticador autenticacion = new Autenticador();
        Visitador pedro = new Visitador("Pedro","Martinez","pepe2023","12345");
        Visitador raul = new Visitador("Raul","Gomez","rau2023","6789");
        //--------------AUTENTICACION DE USUARIOS-------------------------------
        raul.setAdapter(autenticacion);
        pedro.setAdapter(autenticacion);
        //--------------CONTROLADORES-------------------------------
        ClienteController clienteController = new ClienteController();
        AnimalController animalController = new AnimalController();
        AdopcionController adopcionCOntroller = new AdopcionController();
		//---------------VARIABLES A UTILIZAR-----------------------------------
		Scanner sc = new Scanner(System.in);
		char opcion;
        //-------------VETERINARIO MOCKEADO CON INICIO DE SESION----------------
        System.out.println("-------REFUGIO GUD BOY-------");
        Refugio.getInstance().setUsuario(pedro);
        pedro.autenticar("pepe2023","12345", pedro.getTipoUsuario());
        while(true) {
	        System.out.println("------------------------------------");
			System.out.println("----------MENU----------");
			System.out.println("Seleccione una opción:");
			System.out.println("1-Ingresar un nuevo animal al refugio");
			System.out.println("2-Visualizar seguimientos");
			System.out.println("3-Registrar un nuevo cliente para adopcion");
			System.out.println("4-Visualizar animales del refugio");
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
					System.out.println("Ha seleccionado la opcion para visualizar los seguimientos de adopcion en curso");
					if(Refugio.getInstance().getSeguimientoAdopciones().size() != 0) {
						Refugio.getInstance().listarSeguimientos();
					}
					else {
						System.out.println("No hay seguimientos.");
					}
					boolean salirOpcion2 = false;
					while(!salirOpcion2) {
						System.out.println("a-Realizar seguimiento/crear visita");
						System.out.println("b-Ver visitas de un seguimiento");
						System.out.println("c-Volver al menu principal");
						char opcionOpcion2 = sc.nextLine().charAt(0);
						switch(opcionOpcion2) {
							case 'a':
								if(Refugio.getInstance().getSeguimientoAdopciones().size() != 0) {
								System.out.println("Ha seleccionado la opcion para crear una visita");
								System.out.println("Ingrese el numero de la lista del seguimiento al que quiere crearle una visita");
								Scanner sc2 = new Scanner(System.in);
								int opcionSeguimiento = sc2.nextInt() - 1;
								Seguimiento seguimiento = Refugio.getInstance().getSeguimientoAdopciones().get(opcionSeguimiento);
								seguimiento.getEstado().realizarSeguimiento(seguimiento);
							}
							else {
								System.out.println("No hay seguimientos.");
							}
								break;
							case 'b':
								if(Refugio.getInstance().getSeguimientoAdopciones().size() != 0) {
									System.out.println("Ha seleccionado la opcion para ver las visitas de un seguimiento");
									System.out.println("Ingrese el numero de la lista del seguimiento para ver las visitas asociadas");
									Scanner sc2 = new Scanner(System.in);
									int opcionSeguimiento = sc2.nextInt() - 1;
									Seguimiento seguimiento = Refugio.getInstance().getSeguimientoAdopciones().get(opcionSeguimiento);
									Refugio.getInstance().listarVisitasDeSeguimiento(seguimiento);
									System.out.println("Para finalizar una visita seleccione el numero de la lista, si presiona 0 se vuelve al menu anterior");
									int opcionVisita = sc2.nextInt();
										if(opcionVisita > 0) {
										Visita visita = seguimiento.getVisitas().get(opcionVisita-1);
										visita.finalizarVisita(seguimiento);
										}
								}
								else {
									System.out.println("No hay seguimientos.");
								}
									break;
							case 'c':
								salirOpcion2 = true;
								break;
							default:
								System.out.println("Opcion invalida. Intente nuevamente");
						}
					}
					break;
				case '3': 
					System.out.println("Ha seleccionado registrar un cliente");
					Cliente cliente = clienteController.crearCliente(); 
					System.out.println("A continuacion se le muestran los animales que hay en el refugio, ingresel id del animal que sera adoptado");
					if(Refugio.getInstance().getAnimales().size() != 0) {
						Refugio.getInstance().listarAnimales();
						Scanner sc2 = new Scanner(System.in);
						int opcionId = sc2.nextInt();
						Animal animal = Refugio.getInstance().buscarAnimal(opcionId);
						if(animal != null) {
							adopcionCOntroller.crearAdopcion(cliente, animal, (Visitador) Refugio.getInstance().getUserConectado());
						}
						else {
							System.out.println("El id ingresado no corresponde a un animal");
						}
					}
					else {
						System.out.println("No hay animales en el refugio.");
					}
					break;
				case '4': 
					System.out.println("Ha seleccionado la opcion para visualizar los animales del refugio");
					if(Refugio.getInstance().getAnimales().size() != 0) {
						Refugio.getInstance().listarAnimales();
					}
					else {
						System.out.println("No hay animales en el refugio.");
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