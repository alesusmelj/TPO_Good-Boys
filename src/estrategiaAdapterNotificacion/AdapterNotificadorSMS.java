package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;

public interface AdapterNotificadorSMS {
    public void enviarSMS(Notificacion notificacion);

}