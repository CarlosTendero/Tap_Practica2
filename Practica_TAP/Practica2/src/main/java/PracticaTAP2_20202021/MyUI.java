package PracticaTAP2_20202021;

import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Registration;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import Clases.Ascensor;
import Clases.Edificio;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */

@Theme("mytheme")

public class MyUI extends UI {

    private static final String DateField = null;
	
    //Arrays de elementos en los que vamos a guardar los labels que van a ir cambiando.
    //Variables de pestaña de panel de control
	private static ArrayList<Label> PC_estadoAscensores = new ArrayList<Label>();
	private static ArrayList<Label> PC_estadoEmergenciaAscensores = new ArrayList<Label>();
	private static ArrayList<Label> PC_pisoActualAscensores = new ArrayList<Label>();

    //Variables de pestaña de cabina ascensores
	private static ArrayList<Label> CA_pisoActualAscensores = new ArrayList<Label>();
	
    //Variables de pestaña de Plantas
	private static ArrayList<Label> PL_pisoActualAscensores = new ArrayList<Label>();
	private static ArrayList<Label> PL_estadoEmergenciaAscensores = new ArrayList<Label>();
	private static Label PL_MensajeAltavoz = new Label("Altavoz :");
     
	//Variables de emergencia
	private static final Label sinEmergencia = new Label("✓");
	private static final Label conEmergencia = new Label("⚠");
	
	//Variables de la planta.
	private static int planta_Actual = 0;
	
	
	private static int ascensor_Actual = 0;
	
	//Variable de edificio.
	private static Edificio edificio = new Edificio();

	@Override
    protected void init(VaadinRequest vaadinRequest) {
    	

		//Creación del layout y de la tabsheet. Era final horizontal antes.	
    	HorizontalLayout layout = new HorizontalLayout();	

        TabSheet tabsheet = new TabSheet();
        
        //Creamos las distintas pestañas.
        
        //-------------------------------------------------------------------------
        //PESTAÑA 1: Panel de control.
        //-------------------------------------------------------------------------
        
        //Creamos el gridlayout.
        GridLayout tab1 = new GridLayout(3,4);
        //Modificaciones del ancho y alto del MyUI sin el css.
        tab1.setMargin(true);
        tab1.addStyleName("estiloTab");
    	tabsheet.addTab(tab1, "Panel de control");

    	//Imagen de ascensores.
        Resource res1 = new ThemeResource("ascensor.png");
   
        //Añadimos los ascensores y su estado.
        for(int i= 0; i < 3; i++) {
        	tab1.addComponent(new Image(null, res1), i, 0);
        	//PLanta actual.
        	Label label0 = new Label("Ascensor en planta "+ edificio.getAscensores().get(i).getPlanta_actual());
        	PC_pisoActualAscensores.add(label0);
        	tab1.addComponent(label0, i, 1);
        	//Estado ascernsor.
        	Label label1 = new Label("Estado: "+ edificio.getAscensores().get(i).getPuerta_estado());
        	PC_estadoAscensores.add(label1);
        	tab1.addComponent(label1, i, 2);
        	//Emergencia.
        	Label label2 = new Label("Estado emergencia "+ edificio.getAscensores().get(i).getEmergencia());
			PC_estadoEmergenciaAscensores.add(label2);
        	tab1.addComponent(label2, i, 3);
        }

                
        //-------------------------------------------------------------------------
        //PESTAÑA 2: Planta.
        //-------------------------------------------------------------------------
        
    	//Creamos el gridlayout.
        GridLayout tab3 = new GridLayout(13, 24);
        tab3.addStyleName("estiloTabPlanta");
        tab3.setMargin(true);
        tabsheet.addTab(tab3, "Planta");
        layout.addComponents(tabsheet);
        
        //Altavoz
        Label altavoz = new Label("🔊");
        altavoz.addStyleName("altavoz");
        altavoz.setSizeFull();
        PL_MensajeAltavoz = altavoz;
        tab3.addComponent(altavoz, 0, 2, 8, 2);
        
       //Display
       for(int i= 0; i < 3 ; i++) {
    	   Label label3 = new Label("Piso actual: " + edificio.getAscensores().get(i).getPlanta_actual());
    	   PL_pisoActualAscensores.add(label3); 
    	   tab3.addComponent(label3, i*2, 3);
        }	 
       
       //Emergencia
       for(int i= 0; i < 3 ; i++) {
    	   Label label4 = new Label("✓");
    	   PL_estadoEmergenciaAscensores.add(label4);
    	   tab3.addComponent(label4, (i*2)+1, 3);
       }

        //Ascensores
        for(int i= 0; i < 6; i+=2) {
        	tab3.addComponent(new Image(null, res1), i, 4);
        }  
        


        //Lista con los botones de la planta actual y sus registration.
    	ArrayList<Button> botonesPlanta = new ArrayList<Button>();
    	ArrayList<Registration> botonesPlanta_Registration = new ArrayList<Registration>();


        //Botones para llamar a los ascensores de la planta actual.
    	
    	//Button 1
    	Button boton1 = new Button("🔴");
        boton1.addStyleName("botonLlamar");
    	        	
        botonesPlanta_Registration.add(boton1.addClickListener(event ->{
    		edificio.getPlantas().get(planta_Actual).llamarAscensor(edificio.getAscensores().get(0));
    		
    		ascensor_Actual = 0;
    		
    		System.out.println(planta_Actual);
    		ActualizarCaptions();
    	}));
        botonesPlanta.add(boton1);
    	tab3.addComponent(boton1, 1, 4);
    	
    	//Button 2
    	Button boton2 = new Button("🔴");
        boton2.addStyleName("botonLlamar");
    	        	
        botonesPlanta_Registration.add(boton2.addClickListener(event ->{
    		edificio.getPlantas().get(planta_Actual).llamarAscensor(edificio.getAscensores().get(1));
    		
    		ascensor_Actual = 1;

    		
    		System.out.println(planta_Actual);
    		ActualizarCaptions();
    	}));
        botonesPlanta.add(boton2);
    	tab3.addComponent(boton2, 3, 4);
    	
    	//Button 3
    	Button boton3 = new Button("🔴");
        boton3.addStyleName("botonLlamar");
    	        	
        botonesPlanta_Registration.add(boton3.addClickListener(event ->{
    		edificio.getPlantas().get(planta_Actual).llamarAscensor(edificio.getAscensores().get(2));
    		
    		ascensor_Actual = 2;

    		
    		System.out.println(planta_Actual);
    		ActualizarCaptions();
    	}));

        botonesPlanta.add(boton3);
    	tab3.addComponent(boton3, 5, 4);
        

        //Selección de la planta modificar 
        Label planta = new Label("Estamos en la planta baja");
        //Siento el nombre pero es que no funcionaba con otro nombre tal y como label_planta
        planta.addStyleName("jacinta");

        //Selección de la planta
        Button planta0 = new Button("Planta Baja");
        Button planta1 = new Button("Planta 1");
        Button planta2 = new Button("Planta 2");
        Button planta3 = new Button("Planta 3");
        Button planta4 = new Button("Planta 4");
        Button planta5 = new Button("Planta 5");
        Button planta6 = new Button("Planta 6");

        // AQUI SE MODIFICA EL OBJETO EDIFICIO PARA SELECCIONAR LA PLANTA
    	
        //Cada vez que se pulse el botón de seleccionar planta, 
        //el evento de pulsar el boton de llamar ascensor debe cambiar.
        //Y así llamar al ascensor a la planta actual.
        //Se elimina el registration con remove() y se añade el clicklistener al boton.
        
 
        
        //Al pulsar el piso 0.
        planta0.addClickListener(event ->{
        	planta_Actual = 0;
	        planta.setValue("Estamos en la planta Baja");
	        ActualizarCaptions();
        });
        
        //Al pulsar el piso 1.        
        planta1.addClickListener(event ->{
        	planta_Actual = 1;
	        planta.setValue("Estamos en la planta 1");
	        ActualizarCaptions();
        });
        
        //Al pulsar el piso 2.
        planta2.addClickListener(event ->{
        	planta_Actual = 2;
	        planta.setValue("Estamos en la planta 2");
	        ActualizarCaptions();
        });
        
        //Al pulsar el piso 3.
        planta3.addClickListener(event ->{
        	planta_Actual = 3;
	        planta.setValue("Estamos en la planta 3");
	        ActualizarCaptions();
        });
        
        //Al pulsar el piso 4.
        planta4.addClickListener(event ->{
        	planta_Actual = 4;
        	planta.setValue("Estamos en la planta 4");
	        ActualizarCaptions();
        });
        
        //Al pulsar el piso 5.
        planta5.addClickListener(event ->{
        	planta_Actual = 5;
	        planta.setValue("Estamos en la planta 5");
	        ActualizarCaptions();
        });
        
        //Al pulsar el piso 6.
        planta6.addClickListener(event ->{
        	planta_Actual = 6;
	        planta.setValue("Estamos en la planta 6");
	        ActualizarCaptions();
        });
        Label label = new Label("");
        label.addStyleName("lineavacia2");
        
        tab3.addComponent(planta0, 0,0);
        tab3.addComponent(planta1, 1,0);
        tab3.addComponent(planta2, 2,0);
        tab3.addComponent(planta3, 3,0);
        tab3.addComponent(planta4, 4,0);
        tab3.addComponent(planta5, 5,0);
        tab3.addComponent(planta6, 7,0);
        tab3.addComponent(label, 6,0);
        tab3.addComponent(planta,0,1, 7,1); 

        //--------------ASCENSOR 1-----------------
    	
    	Label labelnew = new Label("");
    	labelnew.addStyleName("lineavacia");
    	tab3.addComponent(labelnew, 0, 5, 11, 5);

        //Botonera 1-6
        int boton=1;
        GridLayout botonera = new GridLayout(4,4);
        for (int fila= 0; fila < 2; fila++) {
            for (int col=0; col < 3; col++) {
                Button button = new Button(""+boton); 
        		button.addStyleName("miBoton");
                button.addClickListener(event ->{
                	edificio.getAscensores().get(0).anyadirDestino(Integer.parseInt(button.getCaption()));
                });
                botonera.addComponent(button, col, fila);
                boton++;
            }
        } 

        //Boton abrir/cerrar
        Button abrirPeta = new Button("<>");
        abrirPeta.addStyleName("miBoton");
        abrirPeta.addClickListener(event ->{
        	edificio.getAscensores().get(0).cambiarEstadoPuerta();
        });
        botonera.addComponent(abrirPeta, 0, 2);

        //Planta baja
        Button pb = new Button("PB");
	    pb.addStyleName("miBotonPB");
        pb.addClickListener(event ->{
        	edificio.getAscensores().get(0).anyadirDestino(0);
        });
        botonera.addComponent(pb, 1, 2);
        
        //Emergencia
        Button emergencia = new Button("🔔");
	    emergencia.addStyleNames("miBotonEmergencia");
        emergencia.addClickListener(event ->{
        	edificio.getAscensores().get(0).activarAlarma();
        });
        botonera.addComponent(emergencia, 2,2);
        
        tab3.addComponent(botonera, 0, 9);
        
        //--------------ASCENSOR 2-----------------     
        
        //Botonera 1-6
        boton=1;
        GridLayout botonera2 = new GridLayout(4,4);
        for (int fila= 0; fila < 2; fila++) {
            for (int col=0; col < 3; col++) {
                Button button = new Button(""+boton);         		
                button.addStyleName("miBoton");
                button.addClickListener(event ->{
                	edificio.getAscensores().get(1).anyadirDestino(Integer.parseInt(button.getCaption()));
                });
                botonera2.addComponent(button, col, fila);
                boton++;
            }
        }  
        //Boton abrir
        Button abrirPeta2 = new Button("<>");
        abrirPeta2.addStyleName("miBoton");

        abrirPeta2.addClickListener(event ->{
        	edificio.getAscensores().get(1).cambiarEstadoPuerta();
        });
        botonera2.addComponent(abrirPeta2, 0, 2);

        //Planta baja
        Button pb2 = new Button("PB");
	    pb2.addStyleName("miBotonPB");
        pb2.addClickListener(event ->{
        	edificio.getAscensores().get(1).anyadirDestino(0);
        });
        botonera2.addComponent(pb2, 1, 2);
        
        //Emergencia
        Button emergencia2 = new Button("🔔");
	    emergencia2.addStyleNames("miBotonEmergencia");
        emergencia2.addClickListener(event ->{
        	edificio.getAscensores().get(1).activarAlarma();
        });
        botonera2.addComponent(emergencia2, 2, 2);
        
        tab3.addComponent(botonera2, 2, 9);
        
        //--------------ASCENSOR 3-----------------        
        
      //Botonera 1-6
        boton=1;
        GridLayout botonera3 = new GridLayout(4,4);
        for (int fila= 0; fila < 2; fila++) {
            for (int col=0; col < 3; col++) {
                Button button = new Button(""+boton);         		
                button.addStyleName("miBoton");
                button.addClickListener(event ->{
                	edificio.getAscensores().get(2).anyadirDestino(Integer.parseInt(button.getCaption()));
                });
                botonera3.addComponent(button, col, fila);
                boton++;
            }
        }  
        //Boton abrir
        Button abrirPeta3 = new Button("<>");
        abrirPeta3.addStyleName("miBoton");

        abrirPeta3.addClickListener(event ->{
        	edificio.getAscensores().get(2).cambiarEstadoPuerta();
        });
        botonera3.addComponent(abrirPeta3, 0, 2);

        //Planta baja
        Button pb3 = new Button("PB");
	    pb3.addStyleName("miBotonPB");
        pb3.addClickListener(event ->{
        	edificio.getAscensores().get(2).anyadirDestino(0);
        });
        botonera3.addComponent(pb3, 1, 2);
        
        //Emergencia
        Button emergencia3 = new Button("🔔");
	    emergencia3.addStyleNames("miBotonEmergencia");
        emergencia3.addClickListener(event ->{
        	edificio.getAscensores().get(2).activarAlarma();
        });
        botonera3.addComponent(emergencia3, 2, 2);
        
        tab3.addComponent(botonera3, 4, 9);

        
        
        //ESTO VA LO ÚLTIMO.
        setContent(layout);
    }
	
	static public void ActualizarCaptions() {
		
		//Actualizamos la pestaña Panel de Control.
		for(int i= 0; i < 3; i++) {
			PC_pisoActualAscensores.get(i).setValue("Ascensor en planta "+ edificio.getAscensores().get(i).getPlanta_actual());
			PC_estadoAscensores.get(i).setValue("Estado: "+ edificio.getAscensores().get(i).getPuerta_estado());
			PC_estadoEmergenciaAscensores.get(i).setValue("Estado emergencia "+ edificio.getAscensores().get(i).getEmergencia());
        }
		

		//Actualizamos la pestaña Cabina ascensores.
		/*
		for(int i= 0; i < 3; i++) {
			CA_pisoActualAscensores.get(i).setValue("Piso actual:" + edificio.getAscensores().get(i).getPlanta_actual());
		}*/
		

		//Actualizamos la pestaña plantas.
		for(int i= 0; i < 3; i++) {
			PL_pisoActualAscensores.get(i).setValue("Piso actual: " + edificio.getAscensores().get(i).getPlanta_actual());
			
			boolean estadoEmergenciaActual = edificio.getAscensores().get(i).getEmergencia();
			if(estadoEmergenciaActual)
				PL_estadoEmergenciaAscensores.get(i).setValue(conEmergencia.getValue());
			else if(!estadoEmergenciaActual)
				PL_estadoEmergenciaAscensores.get(i).setValue(sinEmergencia.getValue());		
		}	

		if( edificio.getAscensores().get(ascensor_Actual).getMensajeAltavoz()!= null)
			PL_MensajeAltavoz.setValue("🔊: "+ edificio.getAscensores().get(ascensor_Actual).getMensajeAltavoz());
		else			
			PL_MensajeAltavoz.setValue("🔊: "+ "Aun no ha llamado ningun ascensor");
		
		//Refresh all please <3.
		//It doesn't refresh... :(
	}

	//Array List con los elementos web de vaadin que van a cambiar referenciados y pasarlos por parámetro al pulsar un boton. 
	
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}