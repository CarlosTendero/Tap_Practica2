package PracticaTAP2_20202021.Practica2;

public class Edificio {
	
	private Ascensor ascensor1;
	private Ascensor ascensor2;
	private Ascensor ascensor3;
	private Planta planta0;
	private Planta planta1;
	private Planta planta2;
	private Planta planta3;
	private Planta planta4;
	private Planta planta5;
	private Planta planta6;
	private PanelDeControl panelDeControl;
	
	
	public Edificio() {
		ascensor1 = new Ascensor();
		ascensor2 = new Ascensor();
		ascensor3 = new Ascensor();
		
		planta0 = new Planta();
		planta1 = new Planta();
		planta2 = new Planta();
		planta3 = new Planta();
		planta4 = new Planta();
		planta5 = new Planta();
		planta6 = new Planta();
		
		panelDeControl = new PanelDeControl();
		
	}

}
