package controllers;

import java.util.Scanner;

import estadoCondicionMedica.Enfermo;
import modelo.Animal;
import modelo.AnimalDomestico;
import modelo.AnimalSalvaje;
import modelo.Especie;
import modelo.EtipoAnimal;
import modelo.FichaTecnica;
import modelo.Refugio;

public class AnimalController {
	
	public Animal ingresarAnimal() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor, para ingresar un animal llene los siguientes datos:");
		System.out.println("Ingrese el tipo de animal: \n 1-Animal domestico \n 2-Animal salvaje");
		String decision = sc.nextLine();
		String aux = "1";
		String aux2 = "2";
		while((!decision.equals("1")) && (!decision.equals("2"))) {
			System.out.println("Error. Por favor seleccione una opcion");
			System.out.println("Ingrese el tipo de animal: \n 1-Animal domestico \n 2-Animal salvaje");
			decision = sc.nextLine();
		}
		switch(decision) {
		case "1": return ingresarAnimalDomestico();
		case "2": return ingresarAnimalSalvaje();
		}
		return null;
		
	}
	
	public Animal ingresarAnimalDomestico() {
		Scanner sc = new Scanner(System.in);
		Animal nuevoAnimal = new AnimalDomestico();
		FichaTecnica fichaTecnicaNuevoAnimal = new FichaTecnica(nuevoAnimal);
		nuevoAnimal.setFichaTecnica(fichaTecnicaNuevoAnimal);
		Refugio.setAnimales(nuevoAnimal);
		System.out.println("Por favor, para ingresar un animal llene los siguientes datos:");
		System.out.println("Ingrese el tipo de animal: \n 1-Perro \n 2-Gato \n 3-Canario \n 4-Loro \n 5-Tortuga");
		String decision = sc.nextLine();
		while((!decision.equals("1")) && (!decision.equals("2")) && (!decision.equals("3")) && (!decision.equals("4")) && (!decision.equals("5"))) {
			System.out.println("Error. Por favor seleccione una opcion");
			System.out.println("Ingrese el tipo de animal: \n 1-Perro \n 2-Gato \n 3-Canario \n 4-Loro \n 5-Tortuga");
			decision = sc.nextLine();
		}
		switch(decision) {
			case "1": nuevoAnimal.setEspecie(Refugio.getEspecies().get(0)); break;
			case "2": nuevoAnimal.setEspecie(Refugio.getEspecies().get(1)); break;
			case "3": nuevoAnimal.setEspecie(Refugio.getEspecies().get(2)); break;
			case "4": nuevoAnimal.setEspecie(Refugio.getEspecies().get(3)); break;
			case "5": nuevoAnimal.setEspecie(Refugio.getEspecies().get(4)); break;
		}
		guardarDatosAnimal(nuevoAnimal);
		return nuevoAnimal;
	}
	
	public Animal ingresarAnimalSalvaje() {
		Scanner sc = new Scanner(System.in);
		Animal nuevoAnimal = new AnimalSalvaje();
		FichaTecnica fichaTecnicaNuevoAnimal = new FichaTecnica(nuevoAnimal);
		nuevoAnimal.setFichaTecnica(fichaTecnicaNuevoAnimal);
		Refugio.setAnimales(nuevoAnimal);	
		System.out.println("Por favor, para ingresar un animal llene los siguientes datos:");
		System.out.println("Ingrese el tipo de animal: \n 1-Zorro \n 2-Pingüino \n 3-Halcon");
		String decision = sc.nextLine();
		while((!decision.equals("1")) && (!decision.equals("2")) && (!decision.equals("3"))) {
			System.out.println("Error. Por favor seleccione una opcion");
			System.out.println("Ingrese el tipo de animal: \n 1-Zorro \n 2-Pingüino \n 3-Halcon");
			decision = sc.nextLine();
		}
		switch(decision) {
		case "1": nuevoAnimal.setEspecie(Refugio.getEspecies().get(5)); break;
		case "2": nuevoAnimal.setEspecie(Refugio.getEspecies().get(6)); break;
		case "3": nuevoAnimal.setEspecie(Refugio.getEspecies().get(7)); break;
		}
		guardarDatosAnimal(nuevoAnimal);
		return nuevoAnimal;
	}
	
	public Double solicitarAltura() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese la altura del animal en cm: ");
		Double altura = sc.nextDouble();
		return altura;
	}
	
	public Double solicitarPeso() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el peso del animal en kg: ");
		Double peso = sc.nextDouble();
		return peso;
	}
	
	public Double solicitarEdad() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese la edad aproximada del animal en años: ");
		Double edad = sc.nextDouble();
		return edad;
	}

	public void guardarDatosAnimal(Animal nuevoAnimal) {
		nuevoAnimal.setAltura(solicitarAltura());
		nuevoAnimal.setPeso(solicitarPeso());
		nuevoAnimal.setEdadAproximada(solicitarEdad());
		nuevoAnimal.setEstado(new Enfermo());
	}
	
}
