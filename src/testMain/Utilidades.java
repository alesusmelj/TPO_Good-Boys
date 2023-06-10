package testMain;
import modelo.Adopcion;
import modelo.Refugio;
import modelo.Usuario;
import java.util.ArrayList;

public class Utilidades {
	public static int nroMatricula = 1;
	public static int contadorNumeroMatricula() {
		int aux = nroMatricula;
		nroMatricula++;
		return aux;	
	}
	public static ArrayList<Usuario> getUsuarios() {
		return Refugio.usuarios;
	}
	public static void setUsuarios(ArrayList<Usuario> usuario) {
		Refugio.usuarios = usuario;
	}
	public static void setUsuario(Usuario usuario) {
		Refugio.usuarios.add(usuario);
	}
	public static void esperar(int segundos) {
		try {
			Thread.sleep(segundos*1000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
