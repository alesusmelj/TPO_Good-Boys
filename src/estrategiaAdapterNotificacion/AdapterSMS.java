package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;

/**
 * 
 */
public class AdapterSMS implements AdapterNotificadorSMS {

    public AdapterSMS() {
    }

    public void enviarSMS(Notificacion notificacion) {
    	System.out.println("Enviando SMS a "+notificacion.getCliente().getNombre() + " " + notificacion.getCliente().getApellido()+" por SMS: "+ " "+notificacion.getMensaje()+" ");
    }

}