package controllers;

import java.util.Scanner;

import modelo.Accion;
import modelo.Alarma;
import modelo.Animal;
import modelo.Control;
import modelo.SeguimientoTratamiento;
import modelo.TratamientoMedico;
import testMain.Utilidades;

public class AlarmaController {

	public Alarma crearAlarmaControl(Animal animal) {
		Control control = new Control();
		Alarma alarma = control.crearAlarma(control);
		System.out.println("Se ha creado una nueva alarma de control");
		configuracionAlarmaControl(control,animal);
		alarma.enviarNotificacionPush();
		return alarma;
	}

	public Alarma crearAlarmaTratamientoMedico(Animal animal) {
		SeguimientoTratamiento seguimientoTratamiento = new SeguimientoTratamiento();
		TratamientoMedico tratamiento = new TratamientoMedico();
		seguimientoTratamiento.setTratamiento(tratamiento);
		Alarma alarma = tratamiento.crearAlarma(tratamiento);
		System.out.println("Se ha creado una nueva alarma de tratamiento medico");
		configuracionAlarmaTratamiento(tratamiento, animal);
		alarma.enviarNotificacionPush();
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
		System.out.println("Por último. Por favor ingrese la fecha en la que finalizará el tratamiento");
		tratamiento.setFechaFin(Utilidades.solicitarUnaFecha());
	}
//	public void enviarNotificacionPush(Alarma alarma, int periodo) {
//		Utilidades.claseTimer(alarma, periodo);
//	}
}
