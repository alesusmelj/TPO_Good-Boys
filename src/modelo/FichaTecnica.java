package modelo;

import java.util.*;

import estrategiaExportacion.IExportar;

/**
 * 
 */
public class FichaTecnica {

    public FichaTecnica(Animal animal) {
    	this.animal = animal;
    	
    }

    private Animal animal;
    private List<TratamientoMedico> tratamiento;
    private List<Control> controles;
    
    public void agregarTratamiento(TratamientoMedico tratamientoMedico) {
    	this.tratamiento.add(tratamientoMedico);
    }
    
    public void agregarControl(Control control) {
    	this.controles.add(control);
    }

	@Override
	public String toString() {
		return "FichaTecnica [animal=" + animal + "]";
	}

}