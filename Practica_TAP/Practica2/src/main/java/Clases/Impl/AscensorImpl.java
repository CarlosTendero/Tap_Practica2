package Clases.Impl;

import java.util.ArrayList;

import Clases.Planta;

public interface AscensorImpl {

	public  ArrayList<Planta> movimientoAscensor(Planta Destino);	
	public void cambiarEstadoPuerta();
	public void cambiarEstadoAscensorMovimiento();
	public void mostrarPlantaActual();
	public void activarAlarma();
}
