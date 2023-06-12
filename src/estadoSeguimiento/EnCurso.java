package estadoSeguimiento;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.Notificacion;
import modelo.Seguimiento;
import modelo.Visita;
import testMain.Utilidades;

public class EnCurso implements EstadoSeguimiento {

    public EnCurso() {
    }

    public void realizarSeguimiento(Seguimiento seguimiento) {
    	Visita visita = new Visita();
    	seguimiento.setVisitas(visita);
    	Scanner sc = new Scanner(System.in);
        boolean datosInvalidos = true;
        do {
	        try {
			    System.out.println("Por favor indique la fecha cuando se va a realizar la visita: ");
			    visita.setFecha(Utilidades.solicitarUnaFecha());
		        System.out.print("Ingrese la hora de inicio del rango (formato: HH:mm): ");
		        String horaStr = sc.next();
		        LocalTime hora = LocalTime.parse(horaStr);
		        while(!Utilidades.estaEnRangoHorario(visita.getFecha(), seguimiento.getCadenciaVisitas().getDia(), seguimiento.getCadenciaVisitas().getRangoHorarioInicio(), seguimiento.getCadenciaVisitas().getRangoHorarioFin())) {
				    System.out.println("La fecha ingresada no corresponde con lo solicitado por el cliente. La cadencia es: " + seguimiento.getCadenciaVisitas());
				    System.out.println("Por favor indique la fecha cuando se va a realizar la visita: ");
				    visita.setFecha(Utilidades.solicitarUnaFecha());
			        System.out.print("Ingrese la hora de inicio del rango (formato: HH:mm): ");
			        horaStr = sc.next();
			        hora = LocalTime.parse(horaStr);
		        }
		        datosInvalidos = false;
	        } catch (InputMismatchException e) {
	        	System.out.println("Error: Se ingresó un valor inválido. Asegúrese de ingresar los datos correctamente.");
	        	sc.nextLine();
	        } catch (Exception e) {
	        	System.out.println("Error: Ha ocurrido un problema al solicitar los datos. Inténtelo nuevamente.");
	        	sc.nextLine();
	        }
        } while (datosInvalidos);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Por favor, indique los dias de anticipacion para el envio del recordatorio Ejemplo: 2 -> 2 dias antes"); 
        Notificacion notificacion = new Notificacion();
        notificacion.setDiasPreferencia(sc.nextInt());
        notificacion.setMensaje("Visita programada para la fecha: "+visita.getFecha());
        notificacion.setCliente(seguimiento.getAdopcion().getCliente());
        System.out.println("Se ha creado la visita");
        seguimiento.getNotificador().enviar(notificacion, visita);
    }
}