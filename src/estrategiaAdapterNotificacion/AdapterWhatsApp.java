package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;

/**
 * 
 */
public class AdapterWhatsApp implements AdapterNotificadorWhatsApp {

    public AdapterWhatsApp() {
    }
    public void enviarWhatsApp(Notificacion notificacion) {
    	System.out.println("Enviando WhatsaApp a "+notificacion.getCliente().getNombre() + " " + notificacion.getCliente().getApellido()+" por WhatsApp: "+ " "+notificacion.getMensaje()+" ");
    }

}