package modelo;

import java.util.ArrayList;

public class Refugio {
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private static ArrayList<Adopcion> adopciones = new ArrayList<Adopcion>();
	private static ArrayList<Animal> animales = new ArrayList<Animal>();
	private static ArrayList<Especie> especies = new ArrayList<Especie>();
	private static ArrayList<Alarma> alarmas = new ArrayList<Alarma>();
	private static ArrayList<Notificacion> notificacionesVisitador = new ArrayList<Notificacion>();
	private static Usuario userConectado;
	
	public static Usuario getUserConectado() {
		return userConectado;
	}
	public static void setUserConectado(Usuario userConectado) {
		Refugio.userConectado = userConectado;
	}
	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public static void setUsuario(Usuario usuario) {
		Refugio.usuarios.add(usuario);
	}
	public static ArrayList<Adopcion> getAdopciones() {
		return adopciones;
	}
	public static void setAdopciones(Adopcion adopcion) {
		Refugio.adopciones.add(adopcion);
	}
	public static ArrayList<Animal> getAnimales() {
		return animales;
	}
	public static void setAnimales(Animal animal) {
		Refugio.animales.add(animal);
	}
	public static ArrayList<Especie> getEspecies() {
		return especies;
	}
	public static void setEspecies(Especie especie) {
		Refugio.especies.add(especie);
	}
	public static ArrayList<Alarma> getAlarmas() {
		return alarmas;
	}
	public static void setAlarma(Alarma alarma) {
		Refugio.alarmas.add(alarma);
	}
	
	public static void eliminarAlarma(Alarma alarma) {
		Refugio.alarmas.remove(alarma);
	}
}
