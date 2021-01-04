package PracticaTAP2_20202021.Practica2;

public class Planta {


	//Atributos
	// no se si va aqui, es para no instanciar 21 planas en edificio 
	private Ascensor ascensor1;
	private Ascensor ascensor2;
	private Ascensor ascensor3;
	
	
	private BotonLlamar botonAsc1;
	private BotonLlamar botonAsc2;
	private BotonLlamar botonAsc3;
	
	private DisplayAscensorPlanta displayAsc1;
	private DisplayAscensorPlanta displayAsc2;
	private DisplayAscensorPlanta displayAsc3;
	
	DisplayAltavoz altavoz;

	public Planta(int pisoActual){
	     
	     this.botonAsc1 = new BotonLlamar(pisoActual, ascensor1);

	}

}
