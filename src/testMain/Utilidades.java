package testMain;

public class Utilidades {
	private static int nroMatricula = 1;
	public static int contadorNumeroMatricula() {
		int aux = nroMatricula;
		nroMatricula++;
		return aux;	
	}
}
