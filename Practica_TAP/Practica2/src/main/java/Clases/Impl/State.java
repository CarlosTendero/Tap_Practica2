package Clases.Impl;

import java.util.ArrayList;

import Clases.Ascensor;

public interface State {
	
	void cambiarEstadoPuerta(Ascensor ascensor);
	ArrayList<Integer> moverAscensor(Ascensor ascensor, int Destino);
}
