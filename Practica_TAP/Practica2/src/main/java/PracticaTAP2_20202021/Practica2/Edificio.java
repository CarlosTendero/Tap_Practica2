package PracticaTAP2_20202021.Practica2;

public class Edificio {
	
	
	private Planta planta0;
	private Planta planta1;
	private Planta planta2;
	private Planta planta3;
	private Planta planta4;
	private Planta planta5;
	private Planta planta6;
	private PanelDeControl panelDeControl;
	
	
	public Edificio() {
				
		planta0 = new Planta(0);
		planta1 = new Planta(1);
		planta2 = new Planta(2);
		planta3 = new Planta(3);
		planta4 = new Planta(4);
		planta5 = new Planta(5);
		planta6 = new Planta(6);
		
		panelDeControl = new PanelDeControl();
		
	}

}
