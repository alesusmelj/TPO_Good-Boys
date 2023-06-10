package testMain;
import modelo.Adopcion;
import modelo.Refugio;
import modelo.Usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

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
	public LocalDateTime solicitarUnaFecha() {
        Scanner scanner = new Scanner(System.in);
        // Solicitar al usuario que ingrese una fecha
        System.out.print("Ingrese una fecha (formato: dd/MM/yyyy HH:mm:ss): ");
        String fechaIngresada = scanner.nextLine();
        // Definir el formato de la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime fecha = LocalDateTime.parse(fechaIngresada, formatter);
		return fecha;
	 
    } 
	
}
