package modelo;

import java.util.*;

/**
 * 
 */
public class AnimalSalvaje extends Animal {
    public AnimalSalvaje(Especie especie, double altura, double peso, double edadAproximada) {
    	super(especie, altura, altura, altura);
    }

    /**
     * @return
     */
    public boolean esAdoptable() {
    	return false;
    }

}