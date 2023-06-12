package modelo;

import java.util.*;
import estrategiaAdapterNotificacion.EstrategiaDeNotificacion;

public class Notificador {

    private EstrategiaDeNotificacion estrategiaNotificacion;
    private Notificacion notificacion;
	
    public Notificador() {}

    public void enviar(Notificacion notificacion) {
    	this.estrategiaNotificacion.enviar(notificacion);
    }

    public void cambiarEstrategiaNotificacion(EstrategiaDeNotificacion nuevaEstrategia) {
    	this.estrategiaNotificacion = nuevaEstrategia;
    }
}