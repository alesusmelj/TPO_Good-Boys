package testMain;

import adapterAutentificador.Autenticador;
import adapterAutentificador.IAdapterAutenticador;
import modelo.Animal;
import modelo.AnimalDomestico;
import modelo.AnimalSalvaje;
import modelo.Cliente;
import modelo.Especie;
import modelo.EtipoAnimal;
import modelo.Refugio;
import modelo.Usuario;
import modelo.Veterinario;
import modelo.Visitador;

public class Mock {
    
    public Veterinario juan; 
    public Veterinario maria;
    public Visitador humberto;
    public Visitador pedro;
    public Animal primerGato;
    public Animal primerZorro;
	public Animal primerTortuga;
	public Animal primerHalcon;
	public Cliente pablo;
	public Cliente matias;
	public Cliente claudio;

    public void ingresoMock(){

        IAdapterAutenticador autenticacion = new Autenticador();

        // ---Veterinarios---
        juan = new Veterinario("Juan","Martinez","juan2023","12345");
		juan.setAdapter(autenticacion);
		Refugio.setUsuario(juan);

		maria = new Veterinario("Maria","Gomez","maria2023","6789");
		maria.setAdapter(autenticacion);
		Refugio.setUsuario(maria);
        
        // ---Visitadores---
		humberto = new Visitador("Humberto","Felk","humberto2023","123");
		humberto.setAdapter(autenticacion);
		Refugio.setUsuario(humberto);

		pedro = new Visitador("Pedro","Dominguez","pedro2023","456");
		pedro.setAdapter(autenticacion);
		Refugio.setUsuario(pedro);    
        
        // ---Clientes---
        pablo = new Cliente("Pablo","Diaz","Soltero","pablodiaz@gmail.com","12345","empleado",false,"quiero adoptar","Gato",0);
        matias = new Cliente("Matias", "Yune", "Soltero", "matiasyune@gmail.com", "6789", "autonomo", true, "motivos educativos", "perro", 1);
        claudio = new Cliente("Claudio", "Godin", "Soltero", "claudiogodin@gmail.com", "321", "empleado",  true, "universidad", "loro", 2);
        
        // ---Especies---

        Especie perro = new Especie("Perro",EtipoAnimal.DOMESTICO);
		Refugio.setEspecies(perro);
		Especie gato = new Especie("Gato",EtipoAnimal.DOMESTICO);
		Refugio.setEspecies(gato);
		Especie canario = new Especie("Canario",EtipoAnimal.DOMESTICO);
		Refugio.setEspecies(canario);
		Especie loro = new Especie("Loro",EtipoAnimal.DOMESTICO);
		Refugio.setEspecies(loro);
		Especie tortuga = new Especie("Tortuga",EtipoAnimal.DOMESTICO);
		Refugio.setEspecies(tortuga);
		Especie zorro = new Especie("Zorro",EtipoAnimal.SALVAJE);
		Refugio.setEspecies(zorro);
		Especie pinguino = new Especie("Pinguino",EtipoAnimal.SALVAJE);
		Refugio.setEspecies(pinguino);
		Especie halcon = new Especie("Halcon",EtipoAnimal.SALVAJE);
		Refugio.setEspecies(halcon);

        // ---Animales---

        primerGato = new AnimalDomestico(gato,15,3,5);
		System.out.println(primerGato.toString());

        primerTortuga = new AnimalDomestico(tortuga,7,9,17);
		System.out.println(primerTortuga.toString());

        primerZorro = new AnimalSalvaje(zorro, 20, 5, 7);
		System.out.println(primerZorro.toString());

        primerHalcon = new AnimalSalvaje(halcon, 19, 29, 20);
		System.out.println(primerHalcon.toString());		
    }
}
