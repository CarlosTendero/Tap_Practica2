package Clases.AscensorPuertaState;

import java.util.ArrayList;

import Clases.Ascensor;
import Clases.Impl.State;

public class ParadoCerrando implements State{

	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {

		System.out.println("Esta cerrándose");
		
		ascensor.setAscensor_estado(new ParadoCerrado());
		
	}

	@Override
	public ArrayList<Integer> moverAscensor(Ascensor ascensor, int Destino) {

		System.out.println("Espera a que acabe de cerrarse la puerta");
		
		return null;
		
	}

	@Override
	public void activarAlarma(Ascensor ascensor, boolean emergencia) {
		// TODO Auto-generated method stub
		
	}

}
