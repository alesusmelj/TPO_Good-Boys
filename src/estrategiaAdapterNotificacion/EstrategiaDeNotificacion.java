package estrategiaAdapterNotificacion;

import java.util.*;
import modelo.Notificacion;

public interface EstrategiaDeNotificacion {

    public void enviar(Notificacion notificacion);

}