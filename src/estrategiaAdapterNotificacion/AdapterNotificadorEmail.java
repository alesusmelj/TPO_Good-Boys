package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;

/**
 * 
 */
public interface AdapterNotificadorEmail {

    /**
     * @param notificacion 
     * @return
     */
    public void enviarEmail(Notificacion notificacion);

}