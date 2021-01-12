package Clases;

import java.util.ArrayList;

public class Edificio implements Clases.Impl.EdificioImpl{

	//--------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------
	
	ArrayList<Ascensor> ascensores 	= new ArrayList<Ascensor>();
	ArrayList<Planta> 	plantas		= new ArrayList<Planta>();
	PanelControl panelControl;
	
	//--------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------
	
	public Edificio() {
		panelControl = new PanelControl(ascensores);
		
		for (int i = 0; i < 3; i++)
			this.ascensores.add(new Ascensor(0, new Clases.AscensorPuertaState.ParadoCerrado(), "Parado Cerrado", i));
		for	(int i = 0; i < 7; i++)
			this.plantas.add(new Planta(ascensores,i));
		
		//Añadimos los observers a los ascensores. Observers = Plantas + Panel de Control.
		for (int i = 0; i < 3; i++) {
			this.ascensores.get(i).attach(panelControl);;
			for(int j=0; j<plantas.size();j++)
				this.ascensores.get(i).attach(plantas.get(j));
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
	
	//--------------------------------------------------------------
	//Funciones?
	//--------------------------------------------------------------
	
}
