package modelo;

import java.util.*;

/**
 * 
 */
public class Cliente {
    private String nombre;
    private String apellido;
    private String estadoCivil;
    private String email;
    private String telefono;
    private String ocupacion;
    private boolean otrasMascotas;
    private String motivoAdopcion;
    private Especie tipoAnimalInteresado;
    private EpreferenciaRecordatorio preferenciaRecordatorio;
    private int animalesAdoptados;
    
    public Cliente(String nombre, String apellido, String estadoCivil, String email, String telefono, String ocupacion, boolean otrasMascotas, String motivoAdopcion,
    	Especie tipoAnimalInteresado, int animalesAdoptados){
    	this.nombre = nombre;
    	this.apellido = apellido;
    	this.estadoCivil = estadoCivil;
    	this.email = email;
    	this.telefono = telefono;
    	this.ocupacion = ocupacion;
    	this.otrasMascotas = otrasMascotas;
    	this.motivoAdopcion = motivoAdopcion;
    	this.tipoAnimalInteresado = tipoAnimalInteresado;
    	this.animalesAdoptados = animalesAdoptados;
    }


    public boolean solicitarAdopcion(Animal animal,Visitador visitador, CadenciaVisitas cadencia,EpreferenciaRecordatorio preferenciaRecordatorio) {
    	if(animal.esAdoptable() && this.puedeAdoptar()) {
    		Seguimiento seguimiento= new Seguimiento(new Adopcion(this,animal),visitador,cadencia);
    		this.preferenciaRecordatorio = preferenciaRecordatorio;
    		System.out.println("El animal "+animal.getEspecie()+" ha sido adoptado por: "+this.nombre+" "+this.apellido);
    		return true;
    	}
    	System.out.println(this.nombre+" "+this.apellido+" no pudo adoptar al animal "+animal.getEspecie());
    	return false;
    }

    public boolean puedeAdoptar() {
    	if(animalesAdoptados >= 2) {
    		return false;
    	}
    	return true;

    }

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}


	public EpreferenciaRecordatorio getPreferenciaRecordatorio() {
		return preferenciaRecordatorio;
	}


	public void setPreferenciaRecordatorio(EpreferenciaRecordatorio preferenciaRecordatorio) {
		this.preferenciaRecordatorio = preferenciaRecordatorio;
	}


	@Override
	public String toString() {
		return "Nombre: "+ nombre + " Apellido: " + apellido;
	}

}