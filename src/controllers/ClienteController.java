package controllers;

import java.util.Scanner;

import modelo.Cliente;
import modelo.Especie;
import modelo.EtipoAnimal;

public class ClienteController {
	public Cliente crearCliente() {
		Scanner sc = new Scanner(System.in);
		Cliente cliente = new Cliente();
		System.out.println("Para registrar al cliente ingresar los siguientes datos:");
		System.out.println("Nombre del cliente: ");
		cliente.setNombre(sc.nextLine());
		System.out.println("Apellido del cliente:");
		cliente.setApellido(sc.nextLine());
		System.out.println("Estado civil del cliente: ");
		cliente.setEstadoCivil(sc.nextLine());
		System.out.println("Email del cliente: ");
		cliente.setEmail(sc.nextLine());
		System.out.println("Telefono del cliente: ");
		cliente.setTelefono(sc.nextLine());
		System.out.println("Ocupacion del cliente: ");
		cliente.setOcupacion(sc.nextLine());
		System.out.println("Tiene otras mascotas? (S/N)");
		String decision = sc.nextLine();
		if(decision.contentEquals("S")){
			cliente.setOtrasMascotas(true);
		}
		else {
			cliente.setOtrasMascotas(false);
		}
		System.out.println("Motivo de adopcion: \n");
		cliente.setMotivoAdopcion(sc.nextLine());
		System.out.println("Por favor indique el tipo de animal que le interesa: (Escriba el nombre igual al listado, ejemplo: Perro");
		System.out.print("Perro \nGato \nCanario \nLoro \nTortuga\n");
		cliente.setTipoAnimalInteresado(sc.nextLine());
		return cliente;	
	}
}
