package Clases.Impl;

import java.util.ArrayList;

import Clases.Planta;

public interface AscensorImpl {

	public  ArrayList<Integer> movimientoAscensor(Planta Destino);	
	public void cambiarEstadoPuerta();
	public void cambiarEstadoAscensor();
	public void activarAlarma();
	public void anyadirDestino(int destino);
	public int calculoDistancia(int destino);
}
