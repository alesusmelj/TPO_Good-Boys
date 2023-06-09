package estadoCondicionMedica;

import modelo.Animal;

public class Adoptado implements EstadoCondicionMedica {

    @Override
    public void recuperar(Animal animal) {
        System.out.println("hola");

    }

    @Override
    public void serAdoptado(Animal animal) {
        // TODO Auto-generated method stub

    }

}