package controllers;

import java.util.Scanner;

import modelo.Adopcion;
import modelo.Animal;
import modelo.CadenciaVisitas;
import modelo.Cliente;
import modelo.EpreferenciaRecordatorio;
import modelo.Refugio;
import modelo.Seguimiento;
import modelo.Visitador;

public class AdopcionController {
	public void crearAdopcion(Cliente cliente, Animal animal, Visitador visitador, CadenciaVisitas cadencia) {
		if (cliente.puedeAdoptar() && animal.esAdoptable()) {
			Seguimiento seguimiento = new Seguimiento(visitador, cadencia);
			cliente.setPreferenciaRecordatorio(solicitarPreferenciaRecordatorio());
			cliente.setAnimalesAdoptados(cliente.getAnimalesAdoptados() + 1);
			Adopcion adopcion = new Adopcion(cliente, animal, seguimiento);
			System.out.println(animal + "Adoptado correctamente");
			Refugio.setAdopciones(adopcion);
		}
		else if(!cliente.puedeAdoptar()) {
			System.out.println("El cliente " + cliente.getNombre() + "ya posee mas de 2 mascotas");
		}
		else if(!animal.esAdoptable()) {
			System.out.println("El animal " + animal + "no se puede adoptar");
		}
	}
	
	public EpreferenciaRecordatorio solicitarPreferenciaRecordatorio() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor, para ingresar una preferencia de recordatorio llene los siguientes datos:");
		System.out.println("Seleccione un tipo de recordatorio: \n 1-SMS \n 2-Email \n 3-WhatsApp"); 
		String decision = sc.nextLine();
		while((!decision.equals("1")) && (!decision.equals("2")) && (!decision.equals("3"))) {
			System.out.println("Error. Por favor seleccione una opcion");
			System.out.println("Seleccione un tipo de recordatorio: \n 1-SMS \n 2-Email \n 3-WhatsApp");
			decision = sc.nextLine();
		}
		switch(decision) {
			case "1": return EpreferenciaRecordatorio.SMS;
			case "2": return EpreferenciaRecordatorio.EMAIL;
			case "3": return EpreferenciaRecordatorio.WHATSAPP;
		}
		return null;
	}
}
