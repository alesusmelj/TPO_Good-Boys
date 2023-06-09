package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;

 
public class NotificacionPorWhatsApp implements EstrategiaDeNotificacion {
    private AdapterNotificadorWhatsApp adapter;
    public NotificacionPorWhatsApp(AdapterNotificadorWhatsApp adapter) {
        super();
        this.adapter = adapter;
    }

    public void enviar(Notificacion notificacion) {
    	this.adapter.enviarWhatsApp(notificacion);
    }

	public void setAdapter(AdapterNotificadorWhatsApp adapter) {
		this.adapter = adapter;
	}

}