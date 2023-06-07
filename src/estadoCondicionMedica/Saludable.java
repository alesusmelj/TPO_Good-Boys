package estadoCondicionMedica;
import java.util.*;

public class Saludable implements EstadoCondicionMedica {


    public Saludable() {
    }
    
    public void serAdoptado(Animal animal) {
        animal.cambiarEstado(new Adoptado())
    }


    public void recuperar(Animal animal) {
    }

}