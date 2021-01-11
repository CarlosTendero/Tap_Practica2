package Clases;

import java.util.ArrayList;

import Clases.Impl.State;

public class Ascensor implements Clases.Impl.AscensorImpl{

	Planta planta_actual;
	
	private State ascensor_estado;
	
	private String puerta_estado;
	
	public Ascensor(Planta planta_actual, State ascensor_estado) {

		this.planta_actual = planta_actual;
		this.ascensor_estado = ascensor_estado;
	}

	public Planta getPlanta_actual() {
		return planta_actual;
	}

	public void setPlanta_actual(Planta planta_actual) {
		this.planta_actual = planta_actual;
	}

	public State getAscensor_estado() {
		return ascensor_estado;
	}

	public void setAscensor_estado(State ascensor_estado) {
		this.ascensor_estado = ascensor_estado;
	}
	
	public void setAscensor_puerta(String puerta) {
		
		this.puerta_estado = puerta;
		
	}


	@Override
	public ArrayList<Planta> movimientoAscensor(Planta Destino) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cambiarEstadoPuerta() {

		this.ascensor_estado.cambiarEstadoPuerta(this);
		
	}

	@Override
	public void cambiarEstadoAscensor() {

		this.ascensor_estado.cambiarEstadoAscensor(this);
		
	}

	@Override
	public void mostrarPlantaActual() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activarAlarma() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
