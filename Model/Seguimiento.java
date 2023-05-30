
import java.util.*;

/**
 * 
 */
public class Seguimiento implements EstadoSeguimiento {


    public Seguimiento() {
    }

    private Visitador responsableSeguimiento;
    private CadenciaVisitas cadenciaVisitas;
    private Adopcion adopcionAsociada;
    private EstadoSeguimiento estado;
    private List<Visita> visitas;
    public Notificador notificador;


    public void cambiarEstado() {
    }


    public void realizarSeguimiento() {
    }


    public void enviarEncuesta() {
    }


    public void finalizarVisita(Visita visita) {
    }


    public void enviar() {
    }


	@Override
	public void realizarSeguimiento(Seguimiento segumiento) {
		
	}


	@Override
	public void enviarEncuesta(Seguimiento seguimiento) {
		
	}

}