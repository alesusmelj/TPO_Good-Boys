package modelo;

import java.util.*;

/**
 * 
 */
public class AnimalDomestico extends Animal {

    public AnimalDomestico(Especie especie, double altura, double peso, double edadAproximada) {
    	super(especie, altura, peso, edadAproximada);
    }

    public boolean esAdoptable() {
    	return isSaludable;
    }

}