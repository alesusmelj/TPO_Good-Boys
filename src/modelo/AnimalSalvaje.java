package modelo;

public class AnimalSalvaje extends Animal {
	
	public AnimalSalvaje() {
		super();
	}
    public AnimalSalvaje(Especie especie, double altura, double peso, double edadAproximada) {
        super(especie, altura, peso, edadAproximada);
    }

    public boolean esAdoptable() {
        return false;
    }

    public void recuperar(Animal animal) {
        this.estado.recuperar(this);
    }

    public void serAdoptado(Animal animal) {
        this.estado.serAdoptado(this);
    }
}