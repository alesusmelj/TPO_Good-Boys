package modelo;

import java.util.ArrayList;

public class Refugio {
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Adopcion> adopciones = new ArrayList<Adopcion>();
	private ArrayList<Animal> animales = new ArrayList<Animal>();
	private ArrayList<Especie> especies = new ArrayList<Especie>();
	private ArrayList<Alarma> alarmas = new ArrayList<Alarma>();
	private ArrayList<Notificacion> notificacionesVisitador = new ArrayList<Notificacion>();
	private ArrayList<Seguimiento> seguimientoAdopciones = new ArrayList<Seguimiento>();
	private Usuario userConectado;
	private static Refugio instance;
	
	
	private Refugio() {};
	public static Refugio getInstance() {
		if(instance == null) {
			instance = new Refugio();
		}
		return instance;
	}
	public void listarAnimales() {
		for(Animal animal: animales) {
			System.out.println(animal);
		}
	}
	
	public Animal buscarAnimal(int idAnimal) {
		for(Animal animal: animales) {
			if(animal.getIdAnimal() == idAnimal) {
				return animal;
			}
		}
		return null;
	}
	public void listarAlarmas() {
		int cont = 0;
		for(Alarma alarma: alarmas) {
			cont++;
			System.out.println(cont+"- "+alarma);
		}
	}
	
	public void listarSeguimientos() {
		int cont = 0;
		for(Seguimiento seguimiento: seguimientoAdopciones) {
			cont++;
			System.out.println(cont+"- "+seguimiento);
		}
	}
	public void listarVisitasDeSeguimiento(Seguimiento seguimiento) {
		int cont = 0;
			for(Visita visita: seguimiento.getVisitas()) {
				cont++;
				System.out.println(" "+cont+"- "+visita);
			}
		}
	
	public Usuario getUserConectado() {
		return userConectado;
	}
	public void setUserConectado(Usuario userConectado) {
		this.userConectado = userConectado;
	}
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	public ArrayList<Adopcion> getAdopciones() {
		return adopciones;
	}
	public void setAdopciones(Adopcion adopcion) {
		this.adopciones.add(adopcion);
	}
	public ArrayList<Animal> getAnimales() {
		return animales;
	}
	public void setAnimales(Animal animal) {
		this.animales.add(animal);
	}
	public ArrayList<Especie> getEspecies() {
		return especies;
	}
	public void setEspecies(Especie especie) {
		this.especies.add(especie);
	}
	public ArrayList<Alarma> getAlarmas() {
		return alarmas;
	}
	public void setAlarma(Alarma alarma) {
		this.alarmas.add(alarma);
	}
	
	public void eliminarAlarma(Alarma alarma) {
		this.alarmas.remove(alarma);
	}
	public ArrayList<Seguimiento> getSeguimientoAdopciones() {
		return seguimientoAdopciones;
	}
	public void setSeguimientoAdopcion(Seguimiento seguimientoAdopciones) {
		this.seguimientoAdopciones.add(seguimientoAdopciones);
	}
	public void eliminarSeguimiento(Seguimiento seguimientoAdopciones) {
		this.alarmas.remove(seguimientoAdopciones);
	}
}
