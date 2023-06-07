package modelo;

import java.util.*;

/**
 * 
 */
public class Cliente {

    public Cliente() {
    }

    private String estadoCivil;
    private String nombre;
    private String apellido;
    private String email;
    private int telefono;
    private String ocupacion;
    private boolean otrasMascotas;
    private String motivoAdopcion;
    private List<Especie> tipoAnimalInteresado;
    private EpreferenciaRecordatorio preferenciaRecordatorio;
    private int animalesAdoptados;


    public void solicitarAdopcion() {

    }

    public boolean puedeAdoptar() {
        // TODO implement here
        return false;
    }

}