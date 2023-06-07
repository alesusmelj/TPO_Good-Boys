
import java.util.*;

/**
 * 
 */
public interface IAdapterAutenticador {

    /**
     * @param usuario 
     * @param password 
     * @return
     */
    public boolean autenticar(String usuario, String password);

}