package estadoCondicionMedica;

import modelo.Animal;

public class Enfermo implements EstadoCondicionMedica {

    @Override
    public void recuperar(Animal animal) {
        System.out.println("El animal se recuperó");
        animal.setEstado(new Saludable());

    }

    @Override
    public void serAdoptado(Animal animal) {
        // TODO Auto-generated method stub

    }

}