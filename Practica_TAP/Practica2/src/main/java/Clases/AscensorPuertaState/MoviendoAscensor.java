package Clases.AscensorPuertaState;

import Clases.Ascensor;
import Clases.Impl.State;

public class MoviendoAscensor implements State{

	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {

		System.out.println("Espera que te estas moviendo");
		/*Ayuda*/
		//No hacer nada.
	}

	@Override
	public void moverAscensor(Ascensor ascensor) {
		
		//Lógica de actualizar planta.
		//Calcular tiempo en subir según cuantas plantas subamos.
		//Al cambiar de planta informar a los observers.
			//listadeObservers.actualizarPisoActual(int plantaActual).
		//Al terminar cambiar estado.
		
	}
}
