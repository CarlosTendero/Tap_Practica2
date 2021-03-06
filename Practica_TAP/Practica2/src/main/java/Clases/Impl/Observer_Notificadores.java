package Clases.Impl;

import java.util.ArrayList;

import Clases.Ascensor;

public abstract class Observer_Notificadores {
	//Variables.
	protected ArrayList<Observer> listaObservers;
	
	public Observer_Notificadores() {
		listaObservers = new ArrayList<Observer>();
	}
	
	//Funciones.
	public void notifyAllObservers(Ascensor asc){
	      for (Observer observer : listaObservers) {
	         observer.update(asc);
	      }
	} 	
	
   public void attach(Observer observer){
	   listaObservers.add(observer);		
   }
}
