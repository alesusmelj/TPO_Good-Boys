
import java.util.*;

/**
 * 
 */
public class Visitador extends Usuario {
	

    private EtipoUsuario tipoUsuario;

    public Visitador() {
    	this.tipoUsuario = EtipoUsuario.VISITADOR;
    }

    public boolean autenticar(String usuario, String password, EtipoUsuario tipoUsuario) {
        // TODO implement here
        return false;
    }

    public void completarEncuesta(EncuestaVisitador encuesta) {
    }

}