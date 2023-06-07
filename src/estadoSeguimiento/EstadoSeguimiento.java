package estadoSeguimiento;

import java.util.*;

/**
 * 
 */
public interface EstadoSeguimiento {

    /**
     * @param segumiento 
     * @return
     */
    public void realizarSeguimiento(Seguimiento segumiento);

    /**
     * @param seguimiento 
     * @return
     */
    public void enviarEncuesta(Seguimiento seguimiento);

}