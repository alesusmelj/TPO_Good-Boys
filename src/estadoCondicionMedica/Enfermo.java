package estadoCondicionMedica;

import modelo.Animal;

public class Enfermo implements EstadoCondicionMedica {

    public void recuperar(Animal animal) {
        System.out.println("El animal se recuperó.");
        animal.cambiarEstado(new Saludable());
        animal.setSaludable(true);
    }

    public void serAdoptado(Animal animal) {
        System.out.println("El animal no puede ser adoptado, debe recuperarse antes.");
    }
}