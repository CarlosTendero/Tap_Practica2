package Clases.AscensorPuertaState;

import java.util.ArrayList;

import Clases.Ascensor;
import Clases.Impl.State;

public class ParadoCerrando implements State{

	//Función de cambio del estado de la puerta y del ascensor
	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {

		System.out.println("Esta cerrándose");

		//Cambiamos el estado del ascensor
		ascensor.setAscensor_estado(new ParadoCerrado());
		
		//---------------------------------------------------
		//Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
		//---------------------------------------------------
		
		//Cambiamos el mensaje del altavoz
		ascensor.setMensajeAltavoz("Cerrando");
	}

	//Función de movimiento del ascensor
	@Override
	public ArrayList<Integer> moverAscensor(Ascensor ascensor, int Destino) {

		System.out.println("Espera a que acabe de cerrarse la puerta");
		
		return null;
	}

	//Función de acción a realizar al activar la alarma en este estado
	@Override
	public void activarAlarma(Ascensor ascensor, boolean emergencia) {
		
		//La puerta no acaba de cerrarse del todo, sino que comienza a abrirse para que los ocupantes salgan
		
		//Cambiamos el estado de la puerta
		ascensor.setAscensor_puerta("Puerta abriéndose por emergencia");
		
		//Cambiamos el estado del ascensor
		ascensor.setAscensor_estado(new ParadoAbriendo());
		
		//Inmediatamente después, ejecutamos la función cambiarEstadoPuerta del nuevo estado (ParadoCerrando)
		//Así simulamos la transición de la puerta de abierto a cerrado 
		ascensor.getAscensor_estado().cambiarEstadoPuerta(ascensor);
		
		//---------------------------------------------------
		//Informamos a los observers de que hemos cambiado el estado del ascensor.
		ascensor.notifyAllObservers(ascensor);
		//---------------------------------------------------
	}
}
