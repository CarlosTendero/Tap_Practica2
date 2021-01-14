package Clases.AscensorPuertaState;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import Clases.Ascensor;
import Clases.Impl.State;

public class MoviendoAscensor implements State {


	//Función para cambiar el estado de la puerta y del ascensor
	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {

		System.out.println("Espera que te estas moviendo");
		// No hacer nada.
		
		//Cambiamos el mensaje del altavoz
		ascensor.setMensajeAltavoz(" ");
	}

	//Función de movimiento del ascensor
	@Override
	public void moverAscensor(Ascensor ascensor, int Destino) {
		//Si estamos en otra planta que no es la de destino.
		if((Destino != ascensor.getPlanta_actual())) {			
			
			//Si hay que subir plantas
			if (ascensor.getPlanta_actual() < Destino) {
				for (int i = ascensor.getPlanta_actual(); i <= Destino; i++) {
			        //Timer 
					//Tiempo - Funciona?
					System.out.println("Empezando timer");
			        try {
			        	//Duerme el programa 1 segundo
			            TimeUnit.SECONDS.sleep(1);
			        } catch (InterruptedException e) {
			            e.printStackTrace();
			        }
					System.out.println("acabando timer");
					ascensor.setPlanta_actual(i);
					//Informamos a los observers de que hemos cambiado el estado del ascensor.
					ascensor.notifyAllObservers(ascensor);
				}
			}
			
			//Si hay que bajar plantas.
			else if (ascensor.getPlanta_actual() > Destino) {
				for (int i = ascensor.getPlanta_actual(); i >= Destino; i--) {
					//sleep
					ascensor.setPlanta_actual(i);
					//Informamos a los observers de que hemos cambiado el estado del ascensor.
					ascensor.notifyAllObservers(ascensor);
				}
			}
		}
			//Al terminar, abrimos las puertas y notificamos a los observers.
			ascensor.setAscensor_estado(new ParadoAbriendo());
			//Quitamos el piso destino de la lista.
			ascensor.getDestinos().remove(0);
			ascensor.getAscensor_estado().cambiarEstadoPuerta(ascensor);
	}

	//Función de acción de la alarma al ser activada
	@Override
	public void activarAlarma(Ascensor ascensor, boolean emergencia) {		

		//---------------------------------------------------
		//Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
		//---------------------------------------------------
		
		if(emergencia) {
			//Si es igual a la planta máxima bajamos a la planta más cercana
			if(ascensor.getPlanta_actual() == 7) {
				ascensor.setAscensor_estado(new ParadoCerrando());
				ascensor.getAscensor_estado().moverAscensor(ascensor, ascensor.getPlanta_actual() - 1);	
				emergencia = false;
			}
			//Si es igual a la planta mínima bajamos a la planta más cercana

			else if(ascensor.getPlanta_actual() == 1) {			//antes ponia this preguntar Belen		
				//this.ascensor_estado.moverAscensor(this, this.getPlanta_actual() + 1);

				ascensor.getAscensor_estado().moverAscensor(ascensor, ascensor.getPlanta_actual() + 1);	
				emergencia = false;
			}
			else {
				ascensor.getAscensor_estado().moverAscensor(ascensor, ascensor.getPlanta_actual() + 1);
				emergencia = false;
			}
			ascensor.setEmergencia(emergencia);
		}

		//---------------------------------------------------
		//Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
		//---------------------------------------------------
		
	}
}
