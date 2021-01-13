package Clases;

import java.util.ArrayList;

public class Edificio implements Clases.Impl.EdificioImpl{

	//Array para guardar los ascensores del edificio 
	ArrayList<Ascensor> ascensores 	= new ArrayList<Ascensor>();
	
	//Array para guardar las plantas del edificio
	ArrayList<Planta> 	plantas		= new ArrayList<Planta>();
	
	//Constructor del edificio
	public Edificio() {
		
		//Añadimos los 3 ascensores
		for (int i = 0; i < 4; i++)
			this.ascensores.add(new Ascensor(i, null, null));
		
		//Añadimos las 7 plantas
		for	(int i = 0; i < 8; i++)
			this.plantas.add(new Planta());
	}
	
	//¿Otro constructor?
	public Edificio(ArrayList<Ascensor> ascensores, ArrayList<Planta> plantas) {
		this.ascensores = ascensores;
		this.plantas = plantas;
	}
	
	//------------------------------------------------------------------------------
	//Getters y Setters
	
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
}
