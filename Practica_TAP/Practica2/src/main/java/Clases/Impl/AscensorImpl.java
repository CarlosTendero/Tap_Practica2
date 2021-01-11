package Clases.Impl;

import java.util.ArrayList;

import Clases.Planta;

public interface AscensorImpl {

	public  ArrayList<Integer> movimientoAscensor(Planta Destino);	
	public void cambiarPiso(Planta Destino);
	public void cambiarEstadoPuerta();
	public void cambiarEstadoAscensor();
	public void mostrarPlantaActual();
	public void activarAlarma();
}
