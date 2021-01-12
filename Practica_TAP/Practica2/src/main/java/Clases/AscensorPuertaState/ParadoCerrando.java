package Clases.AscensorPuertaState;

import Clases.Ascensor;
import Clases.Impl.State;

public class ParadoCerrando implements State{

	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {

		System.out.println("Esta cerrándose");
		
		ascensor.setAscensor_estado(new ParadoCerrado());
		
	}

	@Override
	public void moverAscensor(Ascensor ascensor) {

		System.out.println("Espera a que acabe de cerrarse la puerta");
		
	}

}
