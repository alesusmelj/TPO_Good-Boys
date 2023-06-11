package testMain;
import modelo.Adopcion;
import modelo.Alarma;
import modelo.Refugio;
import modelo.TratamientoMedico;
import modelo.Usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Utilidades {

	public static int nroMatricula = 1;

	public static int contadorNumeroMatricula() {
		int aux = nroMatricula;
		nroMatricula++;
		return aux;	
	}
	
	public static void esperar(int segundos) {
		try {
			Thread.sleep(segundos*1000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static LocalDateTime solicitarUnaFecha() {
        Scanner scanner = new Scanner(System.in);
        // Solicitar al usuario que ingrese una fecha
        System.out.print("Ingrese una fecha (formato: dd/MM/yyyy HH:mm:ss): ");
        String fechaIngresada = scanner.nextLine();
        // Definir el formato de la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime fecha = LocalDateTime.parse(fechaIngresada, formatter);
		return fecha;
	 
    } 
	
	public static Timer claseTimer(Alarma alarma, int periodo) {
		Timer timer = new Timer();
		long tiempoInicial = 0;
		long periodo2 = periodo*60*1000;
		System.out.println(periodo2);
		TratamientoMedico tratamiento = (TratamientoMedico) alarma.getTipo();
		long duracionTotal = calcularDiferenciaFechas(tratamiento.getFechaInicio(),tratamiento.getFechaFin())*60*1000;
		System.out.println(duracionTotal);
        TimerTask task = new TimerTask() {
        	long tiempoInicio = System.currentTimeMillis();
            @Override
            public void run() {
                System.out.println(alarma);
                long tiempoActual = System.currentTimeMillis();
                long duracionTranscurrida = tiempoActual - tiempoInicio;
                if(duracionTranscurrida >= duracionTotal) {
                	cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, tiempoInicial, periodo2);
        return timer;
	}
    public static long calcularDiferenciaFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return ChronoUnit.MINUTES.between(fechaInicio, fechaFin);
    }
}

