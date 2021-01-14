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
		//Cambiamos el mensaje del altavoz
		ascensor.setMensajeAltavoz("Abriendo Puertas");
		//Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
		
		//Tiempo - Funciona?
		/*
        try {
        	//Duerme el programa 1 segundo
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
		//ascensor.setMensajeAltavoz("Puerta Abiertas");
		
        //Cambiamos el estado del ascensor a ParadoAbierto (ya se ha abierto completamente)
		ascensor.setAscensor_estado(new ParadoAbierto());
		//Cambiamos el string del estado del ascensor.
		ascensor.setAscensor_puerta("Parado Abierto");
		//Cambiamos el mensaje del altavoz

		//Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
		//Llamamos a continuar el movimiento del ascensor.
		if(!(ascensor.getDestinos().isEmpty()))
			ascensor.getAscensor_estado().moverAscensor(ascensor, ascensor.getDestinos().get(0));
	}

	//Función de movimiento del ascensor
	@Override
	public void moverAscensor(Ascensor ascensor, int Destino) {

		//NO puedes moverte porque la puerta está abriéndose
		System.out.println("Espera a que deje de abrirse la puerta");	
	}

	//Función de acción a realizar al activar la alarma
	@Override
	public void activarAlarma(Ascensor ascensor) {
		//Cambiar la alarma.
		ascensor.setEmergencia(!ascensor.getEmergencia());

		//Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
	}
}
