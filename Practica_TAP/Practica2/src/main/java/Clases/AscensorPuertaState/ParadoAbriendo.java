package Clases.AscensorPuertaState;

import Clases.Ascensor;
import Clases.Impl.State;

public class ParadoAbriendo implements State{

	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {

		System.out.println("Esta abriéndose");
		
		ascensor.setAscensor_estado(new ParadoAbierto());
		
	}

	@Override
	public void cambiarEstadoAscensor(Ascensor ascensor) {

		System.out.println("Espera a que deje de abrirse la puerta");
		
	}

}
