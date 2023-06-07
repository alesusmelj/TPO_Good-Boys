package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;

/**
 * 
 */
public interface EstrategiaDeNotificacion {

    /**
     * @param notificacion
     */
    public void enviar(Notificacion notificacion);

}