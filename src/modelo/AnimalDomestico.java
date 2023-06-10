package modelo;

import java.util.*;

import estadoCondicionMedica.Saludable;

/**
 
*/
public class AnimalDomestico extends Animal {

	public AnimalDomestico() {
		super();
	}
    public AnimalDomestico(Especie especie, double altura, double peso, double edadAproximada) {
        super(especie, altura, peso, edadAproximada);
    }

    public boolean esAdoptable() {
    	if(this.estado.getClass().equals(Saludable.class)) {
    		return true;
    	}
        return false;
    }

    @Override
    public void recuperar(Animal animal) {
        this.estado.recuperar(this);

    }

    @Override
    public void serAdoptado(Animal animal) {
        this.estado.serAdoptado(this);

    }

}