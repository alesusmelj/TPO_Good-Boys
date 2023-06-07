package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;

/**
 * 
 */
public interface AdapterNotificadorWhatsApp {

    /**
     * @param notificacion 
     * @return
     */
    public void enviarWhatsApp(Notificacion notificacion);

}