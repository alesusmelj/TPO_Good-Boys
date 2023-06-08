package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;

/**
 * 
 */
public class NotificacionPorSMS implements EstrategiaDeNotificacion {

    private AdapterNotificadorSMS adapter;
    
    public NotificacionPorSMS(AdapterNotificadorSMS adapter) {
        super();
        this.adapter = adapter;
    }
    public void enviar(Notificacion notificacion) {
    	this.adapter.enviarSMS(notificacion);

    }

}