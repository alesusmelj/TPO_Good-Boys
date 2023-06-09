package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;

/**
 * 
 */
public interface AdapterNotificadorEmail {
    public void enviarEmail(Notificacion notificacion);

}