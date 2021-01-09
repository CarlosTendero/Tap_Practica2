package Clases.Impl;

import Clases.Ascensor;

public interface State {
	
	void abrirPuerta(Ascensor ascensor);
	void cerrarPuerta(Ascensor ascensor);
	void subiendo(Ascensor ascensor);
	void bajando (Ascensor ascensor);
}
