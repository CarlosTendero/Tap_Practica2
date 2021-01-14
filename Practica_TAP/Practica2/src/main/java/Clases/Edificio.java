package Clases;

import java.util.ArrayList;

import Clases.AscensorPuertaState.ParadoCerrado;

public class Edificio{

	//--------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------

	ArrayList<Ascensor> ascensores 	= new ArrayList<Ascensor>();	// Array ascensores
	ArrayList<Planta> 	plantas		= new ArrayList<Planta>();		// Array plantas
	PanelControl panelControl;										// Panel Control
	private static Edificio instancia;								// instancia Edificio para el singleton
	
	//--------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------	
	public Edificio() {		// Generamos edificio
		for (int i = 0; i < 3; i++)
			this.ascensores.add(new Ascensor(0, new ParadoCerrado(), "Parado Cerrado", i));
		for	(int i = 0; i < 7; i++)
			this.plantas.add(new Planta(ascensores,i));
	
		this.panelControl = new PanelControl(ascensores);
		
		//Añadimos los observers a los ascensores. Observers = Plantas + Panel de Control.
		
		for (int i = 0; i < 3; i++) {
			this.ascensores.get(i).attach(this.panelControl);
			for(int j=0; j<plantas.size();j++)
				this.ascensores.get(i).attach(this.plantas.get(j));
		 
		}
		
	}
	//--------------------------------------------------------------
	//Setters y getters
	//--------------------------------------------------------------
	public Edificio(ArrayList<Ascensor> ascensores, ArrayList<Planta> plantas) {	
		this.ascensores = ascensores;
		this.plantas = plantas;
	}
	
	public ArrayList<Ascensor> getAscensores() {				// Devuelve el array de ascensores
		return ascensores;
	}
	
	public void setAscensores(ArrayList<Ascensor> ascensores) {	// Actualiza el array de ascensores
		this.ascensores = ascensores;
	}
	
	public ArrayList<Planta> getPlantas() {						// Devuelve el array de plantas
		return plantas;
	}
	
	public void setPlantas(ArrayList<Planta> plantas) {			// Actualiza el array de plantas
		this.plantas = plantas;
	}

	public PanelControl getPanelControl() {						// Devuelve el Panel de Control
		return panelControl;
	}
	public void setPanelControl(PanelControl panelControl) {	// Actualiza el Panel de Control
		this.panelControl = panelControl;
	}
	//--------------------------------------------------------------
	//Funciones
	//--------------------------------------------------------------
	public static Edificio instancia() {						// Instancia para realizar el Singleton
        if(Edificio.instancia == null) {
            Edificio.instancia = new Edificio();
        }
        return Edificio.instancia;
    }
	
}
