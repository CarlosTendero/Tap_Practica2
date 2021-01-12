package Clases.AscensorPuertaState;

import java.util.ArrayList;

import Clases.Ascensor;
import Clases.Impl.State;

public class MoviendoAscensor implements State {

	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {

		System.out.println("Espera que te estas moviendo");
		/* Ayuda */
		// No hacer nada.
	}

	@Override
	public ArrayList<Integer> moverAscensor(Ascensor ascensor, int Destino, int plantas) {

		// Lógica de actualizar planta.
		// Calcular tiempo en subir según cuantas plantas subamos.
		// Al cambiar de planta informar a los observers.
		// listadeObservers.actualizarPisoActual(int plantaActual).
		// Al terminar cambiar estado.
		ArrayList<Integer> plantasVisitadas = new ArrayList<Integer>();

		//NO SABEMOS SI HARÍA FALTA EL WHILE O NO
		// Sube 0-4
		if (ascensor.getPlanta_actual() < Destino) {
			for (int i = ascensor.getPlanta_actual(); i <= Destino; i++) {
				plantasVisitadas.add(i);
			}
			ascensor.setPlanta_actual(Destino);
		}
		// Baja 4-0
		else if (ascensor.getPlanta_actual() > Destino) {
			for (int i = ascensor.getPlanta_actual(); i <= Destino; i++) {
				plantasVisitadas.add(i);
			}
			ascensor.setPlanta_actual(Destino);
		}
		// Igual 4 ParadoCerrado - 4 ParadoAbriendo -> ParadoAbierto
		else {
			ascensor.setAscensor_estado(new ParadoAbriendo());
		}
		return plantasVisitadas;
	}
}
