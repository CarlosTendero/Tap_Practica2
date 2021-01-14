package Clases.AscensorPuertaState;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import Clases.Ascensor;
import Clases.Impl.State;

public class ParadoCerrando implements State{

	//Función de cambio del estado de la puerta y del ascensor
	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {
		
		//Cambiamos los estados.
        ascensor.setAscensor_puerta("Puerta Cerrándose");
        ascensor.setMensajeAltavoz("Cerrando Puertas");
		
        //Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
		
        //Timer 
		//Tiempo - Funciona?
		/*System.out.println("Empezando timer");
        try {
        	//Duerme el programa 1 segundo
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
		System.out.println("acabando timer");
		//Cambiamos el estado del ascensor
		ascensor.setAscensor_estado(new ParadoCerrado());
		//Cambiamos el string del estado del ascensor.
		ascensor.setAscensor_puerta("Parado Cerrado");
		//Cambiamos el mensaje del altavoz
		ascensor.setMensajeAltavoz("");
		
        //Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
		
		if(!ascensor.getDestinos().isEmpty())
			ascensor.getAscensor_estado().moverAscensor(ascensor, ascensor.getDestinos().get(0));		
	}

	//Función de movimiento del ascensor
	@Override
	public void moverAscensor(Ascensor ascensor, int Destino) {

		//System.out.println("Espera a que acabe de cerrarse la puerta");
		
	}

	//Función de acción a realizar al activar la alarma en este estado
	@Override
	public void activarAlarma(Ascensor ascensor) {
		//Cambiar la alarma.
		ascensor.setEmergencia(!ascensor.getEmergencia());
		if(ascensor.getEmergencia()) {
			//Cambiamos el estado del ascensor a abriendo
			ascensor.setAscensor_estado(new ParadoAbriendo());
			
			//Directamente despues de estar en el estado abriendo, cambiamos de estado abriendo a abierto
			//Para simular lo que tarda una puerta en abrirse 
			ascensor.getAscensor_estado().cambiarEstadoPuerta(ascensor);
		}
		//Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
	}
}
