package estadoSeguimiento;

import modelo.Seguimiento;
import modelo.Visita;

/**
 * 
 */
public class EnCurso implements EstadoSeguimiento {


    public EnCurso() {
    }


    public void realizarSeguimiento(Seguimiento seguimiento) {
    	Visita visita = new Visita();
    	seguimiento.setVisitas(visita);
    }


}