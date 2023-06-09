package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;

/**
 * 
 */
public class NotificacionPorEmail implements EstrategiaDeNotificacion {

    private AdapterNotificadorEmail adapter;

    public NotificacionPorEmail(AdapterNotificadorEmail adapter) {
    	super();
    	this.adapter = adapter;
    }

    public void enviar(Notificacion notificacion) {
    	this.adapter.enviarEmail(notificacion);
    }

	public void setAdapter(AdapterNotificadorEmail adapter) {
		this.adapter = adapter;
	}
}