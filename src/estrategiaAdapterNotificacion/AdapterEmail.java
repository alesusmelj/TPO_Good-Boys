package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;

/**
 * 
 */
public class AdapterEmail implements AdapterNotificadorEmail {
	
    public AdapterEmail() {
		super();
	}

	public void enviarEmail(Notificacion notificacion) {
    	System.out.println("Enviando email a "+notificacion.getCliente().getNombre() + " " + notificacion.getCliente().getApellido()+" por Email: "+ " "+notificacion.getMensaje()+" ");
    }

}