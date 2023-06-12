package modelo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import estadoCondicionMedica.Saludable;
import estadoSeguimiento.Finalizado;
import testMain.Utilidades;

/**
 * 
 */
public class Visita {


    public Visita() {
    }

    private LocalDateTime fecha;
    private EncuestaVisitador encuesta;
    private boolean estaFinalizada = false;
    
  
    
    public void finalizarVisita(Seguimiento seguimiento) {
    	Scanner sc = new Scanner(System.in);
    	enviarEncuesta();
    	this.estaFinalizada = true;
    	System.out.println("Desea continuar con las visitas? (S/N)");
    	String continuarVisita = sc.nextLine();
    	while ((!continuarVisita.toUpperCase().equals("S")) && (!continuarVisita.toUpperCase().equals("N"))) {
    		System.out.println("Error. Desea continuar con las visitas? (S/N)");
    		continuarVisita = sc.nextLine();
    	}
		if(continuarVisita.toUpperCase().equals("N")) {
			seguimiento.cambiarEstado(new Finalizado());
			Refugio.getInstance().eliminarSeguimiento(seguimiento);
		}
    }
    
    public void enviarEncuesta() {
    	Scanner sc = new Scanner(System.in);
    	EncuestaVisitador encuesta = new EncuestaVisitador();
    	System.out.println("Por favor indique el estado general del animal");
    	System.out.println("1: Bueno, 2: Malo, 3: Regular");
    	String estadoGeneral = sc.nextLine();
    	while ((!estadoGeneral.equals("1")) && (!estadoGeneral.equals("2")) && (!estadoGeneral.equals("3"))) {
    		System.out.println("Error. Por favor indique el estado general del animal");
        	System.out.println("1: Bueno, 2: Malo, 3: Regular");
        	estadoGeneral = sc.nextLine();
    	}
    	switch(estadoGeneral){
    		case "1": encuesta.setEstadoGeneralAnimal(ERespuestaEncuesta.BUENO);break;
    		case "2": encuesta.setEstadoGeneralAnimal(ERespuestaEncuesta.MALO);break;
    		case "3": encuesta.setEstadoGeneralAnimal(ERespuestaEncuesta.REGULAR);break;
    	}
    	
    	System.out.println("Por favor indique la limpieza del lugar");
    	System.out.println("1: Bueno, 2: Malo, 3: Regular");
    	String estadoLimpieza = sc.nextLine();
    	while ((!estadoLimpieza.equals("1")) && (!estadoLimpieza.equals("2")) && (!estadoLimpieza.equals("3"))) {
    		System.out.println("Error. Por favor indique la limpieza del lugar");
        	System.out.println("1: Bueno, 2: Malo, 3: Regular");
        	estadoLimpieza = sc.nextLine();
    	}
    	switch(estadoLimpieza){
    		case "1": encuesta.setLimpiezaLugar(ERespuestaEncuesta.BUENO);break;
    		case "2": encuesta.setLimpiezaLugar(ERespuestaEncuesta.MALO);break;
    		case "3": encuesta.setLimpiezaLugar(ERespuestaEncuesta.REGULAR);break;
    	}
    	
    	System.out.println("Por favor indique el estado del ambiente");
    	System.out.println("1: Bueno, 2: Malo, 3: Regular");
    	String estadoAmbiente = sc.nextLine();
    	while ((!estadoAmbiente.equals("1")) && (!estadoAmbiente.equals("2")) && (!estadoAmbiente.equals("3"))) {
    		System.out.println("Error. Por favor indique el estado general del animal");
        	System.out.println("1: Bueno, 2: Malo, 3: Regular");
        	estadoAmbiente = sc.nextLine();
    	}
    	switch(estadoGeneral){
    		case "1": encuesta.setAmbiente(ERespuestaEncuesta.BUENO);break;
    		case "2": encuesta.setAmbiente(ERespuestaEncuesta.MALO);break;
    		case "3": encuesta.setAmbiente(ERespuestaEncuesta.REGULAR);break;
    	}
    	
    	
    }

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public EncuestaVisitador getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(EncuestaVisitador encuesta) {
		this.encuesta = encuesta;
	}

}