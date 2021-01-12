package Clases.Impl;

import java.util.ArrayList;

//import Clases.Planta;

public interface AscensorImpl {

	public void moverAscensor(int Destino, int plantas);	
	public void cambiarEstadoPuerta();
	public void mostrarPlantaActual();
	public void activarAlarma();
	public void anyadirDestino(int destino);
	public int calculoDistancia(int destino);
}
