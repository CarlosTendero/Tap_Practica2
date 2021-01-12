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
	public ArrayList<Integer> moverAscensor(Ascensor ascensor, int Destino) {

		// Lógica de actualizar planta.
		// Calcular tiempo en subir según cuantas plantas subamos.
		// Al cambiar de planta informar a los observers.
		// listadeObservers.actualizarPisoActual(int plantaActual).
		// Al terminar cambiar estado.
		
		ArrayList<Integer> plantasVisitadas = new ArrayList<Integer>();

		// Sube 0-4
		if (ascensor.getPlanta_actual() < Destino) {
			for (int i = ascensor.getPlanta_actual(); i <= Destino; i++) {
				plantasVisitadas.add(i);
				//sleep
				ascensor.setPlanta_actual(i);
			}
		}
		// Baja 4-0
		else if (ascensor.getPlanta_actual() > Destino) {
			for (int i = ascensor.getPlanta_actual(); i <= Destino; i++) {
				plantasVisitadas.add(i);
				//sleep
				ascensor.setPlanta_actual(i);
			}
			
		}
		// Igual 4 ParadoCerrado - 4 ParadoAbriendo -> ParadoAbierto
		else {
			ascensor.setAscensor_estado(new ParadoAbriendo());
		}
		return plantasVisitadas;
	}

	@Override
	public void activarAlarma(Ascensor ascensor, boolean emergencia) {
		// TODO Auto-generated method stub
		
		while(emergencia) {
			//Si es igual a la planta máxima bajamos a la planta más cercana
			if(ascensor.getPlanta_actual() == 7) {
				ascensor.setAscensor_estado(new ParadoCerrando());
				//moverAscensor(this, ascensor.getPlanta_actual() - 1);
				emergencia = false;
			}
			//Si es igual a la planta mínima bajamos a la planta más cercana
			else if(ascensor.getPlanta_actual() == 1) {			//antes ponia this preguntar Belen
				
				//this.ascensor_estado.moverAscensor(this, this.getPlanta_actual() + 1);
				ascensor.getAscensor_estado().moverAscensor(ascensor, ascensor.getPlanta_actual() + 1);	
				emergencia = false;
			}
			else {
				//this.ascensor_estado.moverAscensor(this, this.getPlanta_actual() + 1);
				ascensor.getAscensor_estado().moverAscensor(ascensor, ascensor.getPlanta_actual() + 1);

				emergencia = false;
			}
			
		}
		
	}


}
