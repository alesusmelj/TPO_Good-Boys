package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;
import modelo.Refugio;
import modelo.Visita;
import modelo.Visitador;
import testMain.Utilidades;

public class AdapterEmail implements AdapterNotificadorEmail {
	
    public AdapterEmail() {
		super();
	}

	public void enviarEmail(Notificacion notificacion, Visita visita) {
		if(Refugio.getInstance().getUserConectado().getClass().equals(Visitador.class)) {
			Utilidades.claseTimerSeguimientosVisitaEmail(notificacion, visita, notificacion.getDiasPreferencia());
		}
    }

}