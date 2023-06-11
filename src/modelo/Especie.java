package modelo;

import java.util.*;

public class Especie {

    private String nombre;
    private EtipoAnimal tipoAnimal;

	public Especie(String nombre, EtipoAnimal tipoAnimal) {
		this.nombre = nombre;
		this.tipoAnimal = tipoAnimal;
    }

	public String toString() {
		return nombre + " " + tipoAnimal + "";
	}
}