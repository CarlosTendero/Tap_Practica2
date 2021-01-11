package Clases.Impl;

import java.util.ArrayList;

import Clases.Planta;

public interface AscensorImpl {

	public  ArrayList<Integer> moverAscensor(Planta Destino);	
	public void cambiarEstadoPuerta();
	public void cambiarEstadoAscensor();
	public void mostrarPlantaActual();
	public void activarAlarma();
	public void anyadirDestino(int destino);
	public int calculoDistancia(int destino);
}
