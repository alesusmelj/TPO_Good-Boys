package modelo;

import java.util.*;

public class AnimalDomestico extends Animal {

	public AnimalDomestico() {
		super();
	}
    
    public AnimalDomestico(Especie especie, double altura, double peso, double edadAproximada) {
        super(especie, altura, peso, edadAproximada);
    }

    public boolean esAdoptable() {
        return true;
    }

    public void recuperar(Animal animal) {
        this.estado.recuperar(this);
    }

    public void serAdoptado(Animal animal) {
        this.estado.serAdoptado(this);
    }
}