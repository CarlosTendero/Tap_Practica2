package Clases;

import java.util.ArrayList;

import Clases.AscensorPuertaState.ParadoCerrado;

public class Edificio{


	//--------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------

	//Array para guardar los ascensores del edificio 
	ArrayList<Ascensor> ascensores 	= new ArrayList<Ascensor>();
	ArrayList<Planta> 	plantas		= new ArrayList<Planta>();
	PanelControl panelControl;
	private static Edificio instancia;
	
	//--------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------	
	public Edificio() {
		
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
	
	public ArrayList<Ascensor> getAscensores() {
		return ascensores;
	}
	
	public void setAscensores(ArrayList<Ascensor> ascensores) {
		this.ascensores = ascensores;
	}
	
	public ArrayList<Planta> getPlantas() {
		return plantas;
	}
	
	public void setPlantas(ArrayList<Planta> plantas) {
		this.plantas = plantas;
	}

	public PanelControl getPanelControl() {
		return panelControl;
	}
	public void setPanelControl(PanelControl panelControl) {
		this.panelControl = panelControl;
	}
	
	//--------------------------------------------------------------
	//Funciones
	//--------------------------------------------------------------
	public static Edificio instancia() {
        if(Edificio.instancia == null) {
            Edificio.instancia = new Edificio();
        }
        return Edificio.instancia;
    }
	
}
