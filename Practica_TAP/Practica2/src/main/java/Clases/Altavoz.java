package Clases;

public class Altavoz {

	//Variable String con el estado del alatavoz
	private String altavoz;

	//Getters y setters
	
	public Altavoz(String s) {	// Actualiza el altavoz dado un string
		this.altavoz = s;
	}
	
	public String getAltavoz() { // Devuelve el altavoz
		return altavoz;
	}

	public void setAltavoz(String altavoz) { // Actualiza el altavoz
		this.altavoz = altavoz;
	}
	
}
