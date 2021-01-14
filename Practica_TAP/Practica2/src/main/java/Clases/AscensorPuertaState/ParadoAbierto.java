package Clases.AscensorPuertaState;

import java.util.ArrayList;

import Clases.Ascensor;
import Clases.Impl.State;

public class ParadoAbierto implements State{
	
	//Función de cambio de estado de la puerta y del ascensor
	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {
		
		//Cambiamos el estado de la puerta a cerrándose
		ascensor.setAscensor_puerta("Puerta Cerrándose");	
		//Cambiamos el estado del ascensor a ParadoCerrando
		ascensor.setAscensor_estado(new ParadoCerrando());	
		//Inmediatamente después, ejecutamos la función cambiarEstadoPuerta del nuevo estado (ParadoCerrando)
		//Así simulamos la transición de la puerta de abierto a cerrado 

		ascensor.getAscensor_estado().cambiarEstadoPuerta(ascensor);		
		//Lista de observers a quien informar el cambio de estado de la puerta.
		
		//---------------------------------------------------
		//Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
		//---------------------------------------------------

		//Cambiamos el mensaje del altavoz
		ascensor.setMensajeAltavoz(" ");
	}
	

	//Función de movimiento del ascensor
	@Override
	public ArrayList<Integer> moverAscensor(Ascensor ascensor, int Destino) {

		System.out.println("Primero hay que cerrar la puerta");
		//No hacer nada.		
		return null;
	}

	//Función de la acción a realizar cuando se activa la alarma
	@Override
	public void activarAlarma(Ascensor ascensor, boolean emergencia) {

		//No hacer nada, la persona sale del ascensor sin más
		//Se activa o no se activa la emergencia? Independientemente de que haga algo.
		//---------------------------------------------------
		//Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
		//---------------------------------------------------
	}

}
