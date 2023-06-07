package modelo;

import java.util.*;

import estadoCondicionMedica.EstadoCondicionMedica;

/**
 * 
 */
public abstract class Animal {

    public Animal() {
    }

    private Especie especie;
    private double altura;
    private double peso;
    private double edadAproximada;
    private EstadoCondicionMedica estado;

    public boolean esAdoptable() {
        // TODO implement here
        return false;
    }


    public void cambiarEstado(EstadoCondicionMedica estado) {

    }


    public void recuperar() {

    }

    public void serAdoptado() {

    }

}