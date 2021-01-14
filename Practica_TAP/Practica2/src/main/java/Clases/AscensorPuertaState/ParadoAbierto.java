package Clases.AscensorPuertaState;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import Clases.Ascensor;
import Clases.Impl.State;

public class ParadoAbierto implements State{
	
	//Función de cambio de estado de la puerta y del ascensor
	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {
		
		//Al pulsar el usuario cerrar puertas cambiamos el estado.
		ascensor.setAscensor_estado(new ParadoCerrando());
	
		//Inmediatamente después, ejecutamos la función cambiarEstadoPuerta del nuevo estado (ParadoCerrando)
		//Así simulamos la transición de la puerta de abierto a cerrado 
		ascensor.getAscensor_estado().cambiarEstadoPuerta(ascensor);	
	}

	//Función de movimiento del ascensor
	@Override
	public void moverAscensor(Ascensor ascensor, int Destino) {
		if(!ascensor.getDestinos().isEmpty()) {
			//Tiempo - Funciona?
	        /*try {
	        	//Duerme el programa 1 segundo
	            TimeUnit.SECONDS.sleep(1);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }*/
	        
	        //Cambiamos el estado y su mensaje y el mensaje del altavoz. 
	        ascensor.setAscensor_estado(new ParadoCerrando());
	        ascensor.getAscensor_estado().cambiarEstadoPuerta(ascensor);
		}		
	}

	//Función de la acción a realizar cuando se activa la alarma
	@Override
	public void activarAlarma(Ascensor ascensor) {
		//Cambiar la alarma.
		ascensor.setEmergencia(!ascensor.getEmergencia());
		ascensor.notifyAllObservers(ascensor);
	}

}
