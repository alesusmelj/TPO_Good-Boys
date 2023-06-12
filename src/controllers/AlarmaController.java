package controllers;

import java.time.LocalDateTime;
import java.util.Scanner;

import estadoCondicionMedica.Enfermo;
import estadoCondicionMedica.Saludable;
import modelo.Accion;
import modelo.Alarma;
import modelo.Animal;
import modelo.Control;
import modelo.Refugio;
import modelo.SeguimientoTratamiento;
import modelo.TratamientoMedico;
import modelo.Veterinario;
import testMain.Utilidades;

public class AlarmaController {

	public Alarma crearAlarmaControl(Animal animal) {
		Control control = new Control();
		Alarma alarma = control.crearAlarma(control);
		configuracionAlarmaControl(control,animal);
		Refugio.setAlarma(alarma);
		alarma.enviarNotificacionPush();
		System.out.println("Se ha creado una nueva alarma de control");
		return alarma;
	}

	public Alarma crearAlarmaTratamientoMedico(Animal animal) {
		TratamientoMedico tratamiento = new TratamientoMedico();
		Alarma alarma = tratamiento.crearAlarma(tratamiento);
		configuracionAlarmaTratamiento(tratamiento, animal);
		Refugio.setAlarma(alarma);
		alarma.enviarNotificacionPush();
		System.out.println("Se ha creado una nueva alarma de tratamiento medico");
		return alarma;
	}

	public void configuracionAlarmaControl(Control control,Animal animal) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Configuración de alarma de contro para el animal: "+animal);
		animal.getFichaTecnica().agregarControl(control);
		System.out.println("Por favor indique las acciones a realizar. Se le solicitará el nombre de la acción y luego la descripción de la misma.");
		System.out.println("Nombre de la acción a realizar:");
		String accion = sc.nextLine();
		System.out.println("Descripción de la acción a realizar:");
		String descripcion = sc.nextLine();
		control.agregarAccion(new Accion(accion,descripcion));
		System.out.println("¿Desea agregar otra accion al control? Presione cualquier tecla para continuar, si desea dejar de añadir acciones presione N");
		String decision = sc.nextLine();
		while(!decision.toUpperCase().equals("N")) {
			System.out.println("Nombre de la acción a realizar:");
			accion = sc.nextLine();
			System.out.println("Descripción de la acción a realizar:");
			descripcion = sc.nextLine();
			control.agregarAccion(new Accion(accion,descripcion));
			System.out.println("¿Desea agregar otra accion al control? Presione cualquier tecla para continuar, si desea dejar de añadir acciones presione N");
			decision = sc.nextLine();
		}
	}

	public void configuracionAlarmaTratamiento(TratamientoMedico tratamiento,Animal animal) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Configuración de alarma de tratamiento para el animal: "+animal);
		animal.getFichaTecnica().agregarTratamiento(tratamiento);
		System.out.println("Por favor ingrese el nombre del tratamiento que se va a realizar");
		tratamiento.setNombre(sc.nextLine());
		System.out.println("Por favor ingrese la descripción del tratamiento que se va a realizar");
		tratamiento.setDescripcion(sc.nextLine());
		System.out.println("Por favor indique la periodicidad del tratamiento. (En número entero, el valor se contará como minutos, ejemplo: 2 -> Cada 2 minutos");
		tratamiento.setPeriodicidad(sc.nextInt());
		System.out.println("Por favor indique las acciones a realizar. Se le solicitará el nombre de la acción y luego la descripción de la misma.");
		System.out.println("Nombre de la acción a realizar:");
		Scanner sc2 = new Scanner(System.in);
		String accion = sc2.nextLine();
		System.out.println("Descripción de la acción a realizar:");
		String descripcion = sc2.nextLine();
		tratamiento.agregarAccion(new Accion(accion,descripcion));
		System.out.println("¿Desea agregar otra accion al tratamiento? Presione cualquier tecla para continuar, si desea dejar de añadir acciones presione N");
		String decision = sc2.nextLine();
		while((!decision.toUpperCase().equals("N"))) {
			System.out.println("Nombre de la acción a realizar:");
			accion = sc2.nextLine();
			System.out.println("Descripción de la acción a realizar:");
			descripcion = sc2.nextLine();
			tratamiento.agregarAccion(new Accion(accion,descripcion));
			System.out.println("¿Desea agregar otra accion al tratamiento? Presione cualquier tecla para continuar, si desea dejar de añadir acciones presione N");
			decision = sc2.nextLine();
		}
		System.out.println("Por favor ingrese la fecha en la que iniciará el tratamiento");
		tratamiento.setFechaInicio(Utilidades.solicitarUnaFecha());
		System.out.println("Por ultimo. Por favor ingrese la fecha en la que finalizará el tratamiento");
		tratamiento.setFechaFin(Utilidades.solicitarUnaFecha());
	}
	
	public void atenderControl(Veterinario veterinario, Control control, Animal animal) {
		control.setVeterinario(veterinario);
		control.marcarFinalizado();
		Scanner sc = new Scanner(System.in);
		consultarEstadoAnimal(animal);
		System.out.println("Ingrese a modo de comentario lo realizado en el segumiento del tratamiento:");
		control.setComentario(sc.nextLine());
		Refugio.getAlarmas().remove(control);
	}

	public void atenderTratamientoMedico(Veterinario veterinario, TratamientoMedico tratamientoMedico, Animal animal) {
		SeguimientoTratamiento seguimientoTratamiento = new SeguimientoTratamiento();
		tratamientoMedico.setVeterinario(veterinario);
		Scanner sc = new Scanner(System.in);
		System.out.println("Desea finalizar el tratamiento: "+ tratamientoMedico + "? (S/N)");
		String respuesta = sc.nextLine();
		while ((!respuesta.toUpperCase().equals("S")) && (!respuesta.toUpperCase().equals("N"))) {
			System.out.println("Error. Desea finalizar el tratamiento: "+ tratamientoMedico + "? (S/N)");
			respuesta = sc.nextLine();
		}
		if (respuesta.toUpperCase().equals("S")) {
			tratamientoMedico.marcarFinalizado();
			Refugio.getAlarmas().remove(tratamientoMedico);
		}
		seguimientoTratamiento.setVeterinario(veterinario);
		seguimientoTratamiento.setFecha(LocalDateTime.now());
		consultarEstadoAnimal(animal);
		System.out.println("Ingrese a modo de comentario lo realizado en el segumiento del tratamiento:");
		seguimientoTratamiento.setComentario(sc.nextLine());
		seguimientoTratamiento.setTratamiento(tratamientoMedico);
		tratamientoMedico.setSeguimientosTratamiento(seguimientoTratamiento);
	}
	
	public void consultarEstadoAnimal (Animal animal) {
		Scanner sc = new Scanner(System.in);
		if(animal.getEstado().equals(Enfermo.class)) {
			System.out.println("El animal ya se encuentra saludable? (S/N)");
			String respuesta = sc.nextLine();
			while ((!respuesta.toUpperCase().equals("S")) && (!respuesta.toUpperCase().equals("N"))) {
				System.out.println("Error. El animal ya se encuentra saludable? (S/N)");
				respuesta = sc.nextLine();
			}
			if(respuesta.toUpperCase().equals("S")) {
				animal.cambiarEstado(new Saludable());
			}
		}else if(animal.getEstado().equals(Saludable.class)) {
			System.out.println("El animal tiene algun problema de salud? (S/N)");
			String respuesta = sc.nextLine();
			while ((!respuesta.toUpperCase().equals("S")) && (!respuesta.toUpperCase().equals("N"))) {
				System.out.println("Error. El animal tiene algun problema de salud? (S/N)");
				respuesta = sc.nextLine();
			}
			if(respuesta.toUpperCase().equals("S")) {
				animal.cambiarEstado(new Enfermo());
			}
		}
	}
}