
import java.util.*;

/**
 * 
 */
public class Veterinario extends Usuario {

    public Veterinario() {
    	this.tipoUsuario = EtipoUsuario.VETERINARIO;
    }

    private String nombreCompleto;
    private int nroMatricula;
    private EtipoUsuario tipoUsuario;

    /**
     * @param usuario 
     * @param password 
     * @param tipoUsuario 
     * @return
     */
    public boolean autenticar(String usuario, String password, EtipoUsuario tipoUsuario) {
        // TODO implement here
        return false;
    }

}