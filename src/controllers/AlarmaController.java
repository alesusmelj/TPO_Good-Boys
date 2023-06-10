package controllers;

import java.util.Scanner;

import modelo.Accion;
import modelo.Alarma;
import modelo.Control;
import modelo.SeguimientoTratamiento;
import modelo.TratamientoMedico;

public class AlarmaController {
	
	public Alarma crearAlarmaControl() {
		Control control = new Control();
		Alarma alarma = control.crearAlarma(control);
		System.out.println("Se ha creado una nueva alarma de control");
		configuracionAlarmaControl(control);
		return alarma;
	}
	
	public void crearAlarmaTratamientoMedico() {
		SeguimientoTratamiento seguimientoTratamiento = new SeguimientoTratamiento();
		TratamientoMedico tratamiento = new TratamientoMedico();
		tratamiento.crearAlarma(tratamiento);
		System.out.println("Se ha creado una nueva alarma de tratamiento medico");
	}
	public void configuracionAlarmaControl(Control control) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Configuraci�n de alarma");
		System.out.println("Por favor indique las acciones a realizar. Se le solicitar� el nombre de la acci�n y luego la descripci�n de la misma.");
		System.out.println("Nombre de la acci�n a realizar:");
		String accion = sc.nextLine();
		System.out.println("Descripci�n de la acci�n a realizar:");
		String descripcion = sc.nextLine();
		control.agregarAccion(new Accion(accion,descripcion));
		System.out.println("�Desea agregar otra accion al control? Presione cualquier tecla para continuar, si desea dejar de a�adir acciones presione N");
		String decision = sc.nextLine();
		while((!decision.equals("N"))) {
			System.out.println("Nombre de la acci�n a realizar:");
			accion = sc.nextLine();
			System.out.println("Descripci�n de la acci�n a realizar:");
			descripcion = sc.nextLine();
			control.agregarAccion(new Accion(accion,descripcion));
			System.out.println("�Desea agregar otra accion al control? Presione cualquier tecla para continuar, si desea dejar de a�adir acciones presione N");
			decision = sc.nextLine();
		}
	}
	public void configuracionAlarmaTratamiento(TratamientoMedico tratamiento) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Configuraci�n de alarma");
		System.out.println("Por favor ingrese el nombre del tratamiento que se va a realizar");
		tratamiento.setNombre(sc.nextLine());
		System.out.println("Por favor ingrese la descripci�n del tratamiento que se va a realizar");
		tratamiento.setDescripcion(sc.nextLine());
		System.out.println("Por favor indique las acciones a realizar. Se le solicitar� el nombre de la acci�n y luego la descripci�n de la misma.");
		System.out.println("Nombre de la acci�n a realizar:");
		String accion = sc.nextLine();
		System.out.println("Descripci�n de la acci�n a realizar:");
		String descripcion = sc.nextLine();
		tratamiento.agregarAccion(new Accion(accion,descripcion));
		System.out.println("�Desea agregar otra accion al tratamiento? Presione cualquier tecla para continuar, si desea dejar de a�adir acciones presione N");
		String decision = sc.nextLine();
		while((!decision.equals("N"))) {
			System.out.println("Nombre de la acci�n a realizar:");
			accion = sc.nextLine();
			System.out.println("Descripci�n de la acci�n a realizar:");
			descripcion = sc.nextLine();
			tratamiento.agregarAccion(new Accion(accion,descripcion));
			System.out.println("�Desea agregar otra accion al tratamiento? Presione cualquier tecla para continuar, si desea dejar de a�adir acciones presione N");
			decision = sc.nextLine();
		}
		System.out.println("Por favor ingrese la fecha en la que finalizar� el tratamiento");
		
	}
	
}
