package modelo;

import java.time.LocalTime;
import java.util.*;

import estadoSeguimiento.EstadoSeguimiento;
import testMain.Utilidades;

public class Seguimiento implements EstadoSeguimiento {

    private Visitador responsableSeguimiento;
    private CadenciaVisitas cadenciaVisitas;
    private EstadoSeguimiento estado;
    private List<Visita> visitas;
    private Notificador notificador;
    private Adopcion adopcion;
    

    public Seguimiento(Visitador responsableSeguimiento) {
    	this.responsableSeguimiento = responsableSeguimiento;
    	this.notificador = new Notificador();
    }

    public void cambiarEstado(EstadoSeguimiento estado) {
    	this.estado = estado;
    }
    public void realizarSeguimiento() {
    }

    public void finalizarVisita(Visita visita) {
    }
    public void enviar() {
    }
	@Override
	public void realizarSeguimiento(Seguimiento segumiento) {
	}

	public Notificador getNotificador() {
		return notificador;
	}

	public void setNotificador(Notificador notificador) {
		this.notificador = notificador;
	}


	public CadenciaVisitas getCadenciaVisitas() {
		return cadenciaVisitas;
	}


	public void setCadenciaVisitas(CadenciaVisitas cadenciaVisitas) {
		this.cadenciaVisitas = cadenciaVisitas;
	}

	@Override
	public String toString() {
		return "Seguimiento [responsableSeguimiento=" + responsableSeguimiento + ", cadenciaVisitas=" + cadenciaVisitas
				+ ", estado=" + estado + ", visitas=" + visitas + "]";
	}

	public List<Visita> getVisitas() {
		return visitas;
	}

	public void setVisitas(Visita visita) {
		this.visitas.add(visita);
	}

	public Visitador getResponsableSeguimiento() {
		return responsableSeguimiento;
	}

	public void setResponsableSeguimiento(Visitador responsableSeguimiento) {
		this.responsableSeguimiento = responsableSeguimiento;
	}

	public EstadoSeguimiento getEstado() {
		return estado;
	}

	public void setEstado(EstadoSeguimiento estado) {
		this.estado = estado;
	}

	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;	
	}
	
	public Adopcion getAdopcion() {
		return adopcion;
	}

	public void setAdopcion(Adopcion adopcion) {
		this.adopcion = adopcion;
	}

	public void crearVisita() {
	    	Visita visita = new Visita();
	    	this.visitas.add(visita);
	    	Scanner sc = new Scanner(System.in);
	        boolean datosInvalidos = true;
	        do {
		        try {
				    System.out.println("Por favor indique la fecha cuando se va a realizar la visita: ");
				    visita.setFecha(Utilidades.solicitarUnaFecha());
			        System.out.print("Ingrese la hora de inicio del rango (formato: HH:mm): ");
			        String horaStr = sc.next();
			        LocalTime hora = LocalTime.parse(horaStr);
			        while(!Utilidades.estaEnRangoHorario(visita.getFecha(), this.cadenciaVisitas.getDia(), this.cadenciaVisitas.getRangoHorarioInicio(), this.cadenciaVisitas.getRangoHorarioFin())) {
					    System.out.println("La fecha ingresada no corresponde con lo solicitado por el cliente. La cadencia es: " + this.cadenciaVisitas);
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
	        notificacion.setCliente(this.adopcion.getCliente());
	        notificador.enviar(notificacion);
	    }
}