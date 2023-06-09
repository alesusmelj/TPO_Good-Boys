package modelo;

import java.util.*;

/**
 * 
 */
public class Adopcion {

    public Adopcion(Cliente cliente, Animal animal) {
    	this.cliente = cliente;
    	this.animal = animal;
    }

    private Cliente cliente;
    private Animal animal;

}