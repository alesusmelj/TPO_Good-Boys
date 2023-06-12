package estadoSeguimiento;

import java.util.*;

import modelo.Seguimiento;

public class Finalizado implements EstadoSeguimiento {

    public Finalizado() {
    }


    public void realizarSeguimiento(Seguimiento segumiento) {
    	System.out.println("El seguimiento se encuentra finalizado");
    }

}