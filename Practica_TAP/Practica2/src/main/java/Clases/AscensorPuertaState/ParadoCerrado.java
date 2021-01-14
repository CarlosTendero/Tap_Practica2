package Clases.AscensorPuertaState;

import java.util.ArrayList;

import Clases.Ascensor;
import Clases.Impl.State;

public class ParadoCerrado implements State{

	//Función de cambio del estado de la puerta y del ascensor
	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {
		
		//Cambiamos el estado de la puerta a abierto
		ascensor.setAscensor_puerta("Puerta Abierta");
		
		//Cambiamos el estado del ascensor a ParadoAbriendo
		ascensor.setAscensor_estado(new ParadoAbriendo());
		
		//Inmediatamente después, ejecutamos la función cambiarEstadoPuerta del nuevo estado (ParadoCerrando)
		//Así simulamos la transición de la puerta de abierto a cerrado 
		ascensor.getAscensor_estado().cambiarEstadoPuerta(ascensor);
		
		//---------------------------------------------------
		//Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
		//---------------------------------------------------

		//Cambiamos el mensaje del altavoz
		ascensor.setMensajeAltavoz(" ");
	}

	//Función de movimiento del ascensor en este estado
	@Override
	public void moverAscensor(Ascensor ascensor, int Destino) {
		//mover el ascensor
		ascensor.setAscensor_estado(new MoviendoAscensor());
		ascensor.getAscensor_estado().moverAscensor(ascensor, Destino);	
		
	}

	//Función de la acción a realizar al activar la alarma estando en este estado
	@Override
	public void activarAlarma(Ascensor ascensor, boolean emergencia) {
				
		//Cambiamos el estado de la puerta a un mensaje de emergencia
		ascensor.setAscensor_puerta("Puerta abriéndose por emergencia");
		
		//Cambiamos el estado del ascensor a abriendo
		ascensor.setAscensor_estado(new ParadoAbriendo());
		
		//Directamente despues de estar en el estado abriendo, cambiamos de estado abriendo a abierto
		//Para simular lo que tarda una puerta en abrirse 
		ascensor.getAscensor_estado().cambiarEstadoPuerta(ascensor);
		
		
		//---------------------------------------------------
		//Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
		//---------------------------------------------------		
	}
}
