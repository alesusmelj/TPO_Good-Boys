package testMain;
import modelo.Adopcion;
import modelo.Usuario;
import java.util.ArrayList;

public class Utilidades {
	public static int nroMatricula = 1;
	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	public static ArrayList<Adopcion> adopciones = new ArrayList<Adopcion>();
	public static int contadorNumeroMatricula() {
		int aux = nroMatricula;
		nroMatricula++;
		return aux;	
	}
	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public static void setUsuarios(ArrayList<Usuario> usuario) {
		Utilidades.usuarios = usuario;
	}
	public static void setUsuario(Usuario usuario) {
		Utilidades.usuarios.add(usuario);
	}
	public static void esperar(int segundos) {
		try {
			Thread.sleep(segundos*1000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
