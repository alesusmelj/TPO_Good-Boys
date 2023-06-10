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
	
	public void ingresarAnimalDomestico() {
		Scanner sc = new Scanner(System.in);
		Animal nuevoAnimal = new AnimalDomestico();
		FichaTecnica fichaTecnicaNuevoAnimal = new FichaTecnica(nuevoAnimal);
		Refugio.animales.add(nuevoAnimal);
		System.out.println("Por favor, para ingresar un animal llene los siguientes datos:");
		System.out.println("Ingrese el tipo de animal: \n 1-Perro \n 2-Gato \n 3-Canario \n 4-Loro \n 5-Tortuga");
		String decision = sc.nextLine();
		switch(decision) {
		case "1": nuevoAnimal.setEspecie(Refugio.especies.get(0)); break;
		case "2": nuevoAnimal.setEspecie(Refugio.especies.get(1)); break;
		case "3": nuevoAnimal.setEspecie(Refugio.especies.get(2)); break;
		case "4": nuevoAnimal.setEspecie(Refugio.especies.get(3)); break;
		case "5": nuevoAnimal.setEspecie(Refugio.especies.get(4)); break;
		}
		System.out.println("Ingrese la altura del animal en cm: ");
		nuevoAnimal.setAltura(sc.nextDouble());
		System.out.println("Ingrese el peso del animal en kg: ");
		nuevoAnimal.setPeso(sc.nextDouble());
		System.out.println("Ingrese la edad aproximada del animal en años: ");
		nuevoAnimal.setEdadAproximada(sc.nextDouble());
		nuevoAnimal.setEstado(new Enfermo());	
	}
	public void ingresarAnimalSalvaje() {
		Scanner sc = new Scanner(System.in);
		Animal nuevoAnimal = new AnimalSalvaje();
		FichaTecnica fichaTecnicaNuevoAnimal = new FichaTecnica(nuevoAnimal);
		Refugio.animales.add(nuevoAnimal);	
		System.out.println("Por favor, para ingresar un animal llene los siguientes datos:");
		System.out.println("Ingrese el tipo de animal: \n 1-Zorro \n 2-Pingüino \n 3-Halcon");
		String decision = sc.nextLine();
		switch(decision) {
		case "1": nuevoAnimal.setEspecie(Refugio.especies.get(5)); break;
		case "2": nuevoAnimal.setEspecie(Refugio.especies.get(6)); break;
		case "3": nuevoAnimal.setEspecie(Refugio.especies.get(7)); break;
		}
		System.out.println("Ingrese la altura del animal en cm: ");
		nuevoAnimal.setAltura(sc.nextDouble());
		System.out.println("Ingrese el peso del animal en kg: ");
		nuevoAnimal.setPeso(sc.nextDouble());
		System.out.println("Ingrese la edad aproximada del animal en años: ");
		nuevoAnimal.setEdadAproximada(sc.nextDouble());
		nuevoAnimal.setEstado(new Enfermo());	
	}

}
