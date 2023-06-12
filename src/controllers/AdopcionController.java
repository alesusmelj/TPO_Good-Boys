package controllers;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.InputMismatchException;
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
	public void crearAdopcion(Cliente cliente, Animal animal, Visitador visitador) {
		if (cliente.puedeAdoptar() && animal.esAdoptable()) {		
			Seguimiento seguimiento = new Seguimiento(visitador);
			cliente.setPreferenciaRecordatorio(solicitarPreferenciaRecordatorio());
			seguimiento.setCadenciaVisitas(solicitarCadenciaVisitas());
			cliente.setAnimalesAdoptados(cliente.getAnimalesAdoptados() + 1);
			Adopcion adopcion = new Adopcion(cliente, animal);
			seguimiento.setAdopcion(adopcion);
			System.out.println(animal + "Adoptado correctamente");
			Refugio.setAdopciones(adopcion);
			System.out.println(seguimiento);
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
	public CadenciaVisitas solicitarCadenciaVisitas() {
        Scanner scanner = new Scanner(System.in);
        CadenciaVisitas cadenciaVisitas = null;
        boolean datosInvalidos = true;
        do {
	        try {
		        // Solicitar el día de la semana
		        System.out.print("Ingrese el día de la semana (1: Lunes, 2: Martes, 3 Miercoles, 4: Jueves, 5: Viernes): ");
		        int diaSemanaInt = scanner.nextInt();
		        DayOfWeek diaSemana = DayOfWeek.of(diaSemanaInt);
		        // Solicitar la hora de inicio del rango
		        System.out.print("Ingrese la hora de inicio del rango (formato: HH:mm): ");
		        String inicioRangoStr = scanner.next();
		        LocalTime inicioRango = LocalTime.parse(inicioRangoStr);  
		        // Solicitar la hora de fin del rango
		        System.out.print("Ingrese la hora de fin del rango (formato: HH:mm): ");
		        String finRangoStr = scanner.next();
		        LocalTime finRango = LocalTime.parse(finRangoStr);   
		        cadenciaVisitas = new CadenciaVisitas(diaSemana, inicioRango, finRango);
		        datosInvalidos = false;
	        } catch (InputMismatchException e) {
	        	System.out.println("Error: Se ingresó un valor inválido. Asegúrese de ingresar los datos correctamente.");
	        	scanner.nextLine();
	        } catch (Exception e) {
	        	System.out.println("Error: Ha ocurrido un problema al solicitar los datos. Inténtelo nuevamente.");
	        	scanner.nextLine();
	        }
        } while (datosInvalidos);
        return cadenciaVisitas;
	}
}
