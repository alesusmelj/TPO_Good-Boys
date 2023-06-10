package modelo;

public class AnimalSalvaje extends Animal {
	
	public AnimalSalvaje() {
		super();
	}
    public AnimalSalvaje(Especie especie, double altura, double peso, double edadAproximada) {
        super(especie, altura, altura, altura);
    }

    public boolean esAdoptable() {
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