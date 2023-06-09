package estadoCondicionMedica;

import modelo.Animal;

public class Saludable implements EstadoCondicionMedica {

    @Override
    public void recuperar(Animal animal) {
        System.out.println("El animal esta sano");
        animal.setEstado(new Enfermo());

    }

    @Override
    public void serAdoptado(Animal animal) {
//        if(animal.esAdoptable()) {
//            System.out.println("El animal puede ser adoptado");
//        }

    }

}