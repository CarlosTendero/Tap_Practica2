package Clases.AscensorPuertaState;

import java.util.concurrent.TimeUnit;

import Clases.Ascensor;
import Clases.Impl.State;

public class ParadoAbriendo implements State{

	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {
		
		//System.out.println("Esta abriéndose");
		ascensor.setAscensor_puerta("Puerta Abriéndose");
		//Tiempo
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		ascensor.setAscensor_estado(new ParadoAbierto());
		
	}

	@Override
	public void moverAscensor(Ascensor ascensor) {

		System.out.println("Espera a que deje de abrirse la puerta");
		
	}
}
