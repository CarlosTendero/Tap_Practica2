package Clases.AscensorPuertaState;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import Clases.Ascensor;
import Clases.Impl.State;

public class ParadoAbriendo implements State{

	
	//Función de cambio de estado de la puerta y del ascensor
	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {
		//System.out.println("Esta abriéndose");
		ascensor.setAscensor_puerta("Puerta Abriéndose");
		
		//Tiempo
        try {
        	//Duerme el programa 1 segundo
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //Cambiamos el estado del ascensor a ParadoAbierto (ya se ha abierto completamente)
		ascensor.setAscensor_estado(new ParadoAbierto());
		
		//---------------------------------------------------
		//Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
		//---------------------------------------------------	

		//Cambiamos el mensaje del altavoz
		ascensor.setMensajeAltavoz("Abriendo");
	}

	//Función de movimiento del ascensor
	@Override
	public ArrayList<Integer> moverAscensor(Ascensor ascensor, int Destino) {



		//NO puedes moverte porque la puerta está abriéndose

		System.out.println("Espera a que deje de abrirse la puerta");
		
		return null;
		
	}

	//Función de acción a realizar al activar la alarma
	@Override
	public void activarAlarma(Ascensor ascensor, boolean emergencia) {
		//Se activa o no se activa la emergencia? Independientemente de que haga algo.
		//Tampoco hacer nada, esperar a que la puerta se abra y fin

		
		//---------------------------------------------------
		//Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
		//---------------------------------------------------
	}
}
