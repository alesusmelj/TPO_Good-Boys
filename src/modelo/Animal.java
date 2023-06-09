package modelo;

import java.util.*;

public abstract class Animal {

    protected Especie especie;
    protected double altura;
    protected double peso;
    protected double edadAproximada;
    protected boolean isSaludable;
	
    public Animal(Especie especie, double altura, double peso, double edadAproximada) {
    	this.especie = especie;
    	this.altura = altura;
    	this.peso = peso;
    	this.edadAproximada = edadAproximada;
    	this.isSaludable = false;
    }

    public boolean esAdoptable() {
        // TODO implement here
        return false;
    }
    public void serAdoptado() {
    }

	@Override
	public String toString() {
		return  especie + " altura: " + altura + "cm, peso: " + peso + "kg, edad aproximada: "
				+ edadAproximada + " años ";
	}

	public Especie getEspecie() {
		return especie;
	}

	public boolean isSaludable() {
		return isSaludable;
	}

	public void setSaludable(boolean isSaludable) {
		this.isSaludable = isSaludable;
	}

}