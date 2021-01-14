package Clases.Impl;

import java.util.ArrayList;

import Clases.Ascensor;

public interface State {
	
	void cambiarEstadoPuerta(Ascensor ascensor);
	void moverAscensor(Ascensor ascensor, int Destino);
	void activarAlarma(Ascensor ascensor);
}
