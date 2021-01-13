package Clases.Impl;

//import Clases.Planta;

public interface AscensorImpl {

	public void moverAscensor(int Destino);	
	public void cambiarEstadoPuerta();
	public void activarAlarma(boolean emergencia);
	public void anyadirDestino(int destino);
	public int calculoDistancia(int destino);
	void mostrarPlantaActual();

}
