package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;

/**
 * 
 */
public interface AdapterNotificadorSMS {

    /**
     * @param notificacion 
     * @return
     */
    public void enviarSMS(Notificacion notificacion);

}