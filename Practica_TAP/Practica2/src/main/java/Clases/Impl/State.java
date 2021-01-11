package Clases.Impl;

import Clases.Ascensor;

public interface State {
	
	void cambiarEstadoPuerta(Ascensor ascensor);
	void moverAscensor(Ascensor ascensor);
}
