package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;
import modelo.Refugio;
import modelo.Visita;
import modelo.Visitador;
import testMain.Utilidades;

/**
 * 
 */
public class AdapterWhatsApp implements AdapterNotificadorWhatsApp {

    public AdapterWhatsApp() {
    }
    public void enviarWhatsApp(Notificacion notificacion, Visita visita) {
		if(Refugio.getInstance().getUserConectado().getClass().equals(Visitador.class)) {
			Utilidades.claseTimerSeguimientosVisitaWhatsapp(notificacion, visita, notificacion.getDiasPreferencia());
		}
    }

}