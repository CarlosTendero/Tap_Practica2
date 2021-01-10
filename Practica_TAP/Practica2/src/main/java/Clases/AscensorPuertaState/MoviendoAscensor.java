package Clases.AscensorPuertaState;

import Clases.Ascensor;
import Clases.Impl.State;

public class MoviendoAscensor implements State{

	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {

		System.out.println("Espera que te estas moviendo");
		
	}

	@Override
	public void cambiarEstadoAscensor(Ascensor ascensor) {

		//Añadir planta al array del ascensor para que sea la siguiente planta a la que ir 
		
	}

}
