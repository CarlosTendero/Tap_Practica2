package Clases;

import java.util.ArrayList;

public class Edificio implements Clases.Impl.EdificioImpl{


	ArrayList<Ascensor> ascensores 	= new ArrayList<Ascensor>();
	ArrayList<Planta> 	plantas		= new ArrayList<Planta>();
	
	public Edificio() {
		for (int i = 0; i < 4; i++)
			this.ascensores.add(new Ascensor(i, null, "Tu no eres una princesa"));
		for	(int i = 0; i < 8; i++)
			this.plantas.add(new Planta());
	}
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
	
	
}
