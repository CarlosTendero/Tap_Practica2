package Clases;

import java.util.ArrayList;

import Clases.Impl.State;

public class Ascensor implements Clases.Impl.AscensorImpl{

	Planta planta_actual;
	
	private State puerta_estado;
	
	public Ascensor(Planta planta_actual, State puerta_estado) {

		this.planta_actual = planta_actual;
		this.puerta_estado = puerta_estado;
	}

	public Planta getPlanta_actual() {
		return planta_actual;
	}

	public void setPlanta_actual(Planta planta_actual) {
		this.planta_actual = planta_actual;
	}

	public State getPuerta_estado() {
		return puerta_estado;
	}

	public void setPuerta_estado(State puerta_estado) {
		this.puerta_estado = puerta_estado;
	}


	@Override
	public ArrayList<Planta> movimientoAscensor(Planta Destino) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cambiarEstadoPuerta() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarEstadoAscensorMovimiento() {
		// TODO Auto-generated method stub
		
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
