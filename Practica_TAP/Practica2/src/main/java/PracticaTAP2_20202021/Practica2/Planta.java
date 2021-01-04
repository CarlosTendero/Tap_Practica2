package PracticaTAP2_20202021.Practica2;

public class Planta {

	//Atributos
	BotonLlamar botonAsc1;
	BotonLlamar botonAsc2;
	BotonLlamar botonAsc3;
	
	DisplayAscensorPlanta displayAsc1;
	DisplayAscensorPlanta displayAsc2;
	DisplayAscensorPlanta displayAsc3;
	
	DisplayAltavoz altavoz;

	public Planta(int pisoActual, Ascensor asc){
	     
	     BotonLlamar botonAsc1 = new BotonLlamar(pisoActual, asc);

	}
}
