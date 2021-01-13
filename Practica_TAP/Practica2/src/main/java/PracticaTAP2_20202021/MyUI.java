package PracticaTAP2_20202021;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ClassResource;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

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
     
	@Override
    protected void init(VaadinRequest vaadinRequest) {
    	
		Edificio edificio = new Edificio();
		
    	final HorizontalLayout layout = new HorizontalLayout();
    	
        TabSheet tabsheet = new TabSheet();
        
        
        //Crear Pestañas
        GridLayout tab1 = new GridLayout(3,4);
        tab1.setWidth("80%");
        tab1.setHeight("80%");
    	tabsheet.addTab(tab1, "Panel de control");

    	GridLayout tab2 = new GridLayout(13, 13);
    	tabsheet.addTab(tab2, "Cabina ascensor");
    	  	
        GridLayout tab3 = new GridLayout(8, 4);
    	tabsheet.addTab(tab3, "Planta");
    	
        layout.addComponents(tabsheet);
        
        /*PANEL DE CONTROL*/
        //Imagen de ascensores
        Resource res1 = new ThemeResource("ascensor.png");

        //Añadir ascensores
        for(int i= 0; i < 3; i++) {
        	tab1.addComponent(new Image(null, res1), i, 0);
        }
        
        //Añadir Mov A     
        
        /*------------------------------------------------------- Estado Ascensor -----------------------------------------------------------*/
        
    	tab1.addComponent(new Label("Estado movimiento "+ edificio.getAscensores().get(0).getPuerta_estado()), 0, 1);
    	tab1.addComponent(new Label("Estado movimiento "+ edificio.getAscensores().get(1).getPuerta_estado()), 1, 1);
    	tab1.addComponent(new Label("Estado movimiento "+ edificio.getAscensores().get(2).getPuerta_estado()), 2, 1);
        
        //Añadir estado A
    	
        for(int i= 0; i < 3; i++) {
        	tab1.addComponent(new Label("Estado A"+i), i, 2);
        }
        //Añadir estado emergencia A
        /*----------------------------------------------------- Estado Emergencia -----------------------------------------------------------*/
        
        tab1.addComponent(new Label("Estado movimiento "+ edificio.getAscensores().get(0).getEmergencia() ), 0, 3);
    	tab1.addComponent(new Label("Estado movimiento "+ edificio.getAscensores().get(1).getEmergencia() ), 1, 3);
    	tab1.addComponent(new Label("Estado movimiento "+ edificio.getAscensores().get(2).getEmergencia() ), 2, 3);

        /*------------------------------------------------------CABINA ASCENSOR--------------------------------------------------------------*/
    	
        //Piso actual
        Label display_A1 = new Label("piso actual:" + edificio.getAscensores().get(0).getPlanta_actual());
        tab2.addComponent(display_A1, 0, 0, 2, 0);
        Label display_A2 = new Label("piso actual:" + edificio.getAscensores().get(1).getPlanta_actual());
        tab2.addComponent(display_A2, 3, 0, 5, 0);
        Label display_A3 = new Label("piso actual:" + edificio.getAscensores().get(2).getPlanta_actual());
        tab2.addComponent(display_A3, 6, 0, 8, 0);
        
        //Display Ascensores
        tab2.addComponent(new Label("Ascensor 1"), 0, 4, 2, 4);
        tab2.addComponent(new Label("Ascensor 2"), 3, 4, 5, 4);
        tab2.addComponent(new Label("Ascensor 3"), 6, 4, 8, 4);

        //------------------------------------------------------------------------			ASCENSOR 1

        //Botonera 1-6
        int boton=1;
        for (int fila= 1; fila < 3; fila++) {
            for (int col=0; col < 3; col++) {
                Button button = new Button(""+boton); 
                button.addClickListener(event ->{
                	edificio.getAscensores().get(0).anyadirDestino(Integer.parseInt(button.getCaption()));
                });
                tab2.addComponent(button, col, fila);
                boton++;
            }
        } 
        
        //Boton abrir/cerrar
        Button abrirPeta = new Button("<>");
        abrirPeta.addClickListener(event ->{
        	edificio.getAscensores().get(0).cambiarEstadoPuerta();
        });
        tab2.addComponent(abrirPeta, 0, 3);

        //Planta baja
        Button pb = new Button("PB");
        pb.addClickListener(event ->{
        	edificio.getAscensores().get(0).anyadirDestino(0);
        });
        tab2.addComponent(pb, 1, 3);
        
        //Emergencia
        Button emergencia = new Button("!");
        emergencia.addClickListener(event ->{
        	edificio.getAscensores().get(0).activarAlarma();
        });
        tab2.addComponent(emergencia, 2,3);     
        
        //---------------------------------------------------------------------------		ASCENSOR 2
        
        //Botonera 1-6
        boton=1;
        for (int fila= 1; fila < 3; fila++) {
            for (int col=3; col < 6; col++) {
                Button button = new Button(""+boton); 
                button.addClickListener(event ->{
                	edificio.getAscensores().get(1).anyadirDestino(Integer.parseInt(button.getCaption()));
                });
                tab2.addComponent(button, col, fila);
                boton++;
            }
        }  
        //Boton abrir
        Button abrirPeta2 = new Button("<>");
        abrirPeta2.addClickListener(event ->{
        	edificio.getAscensores().get(1).cambiarEstadoPuerta();
        });
        tab2.addComponent(abrirPeta2, 3, 3);

        //Planta baja
        Button pb2 = new Button("PB");
        pb2.addClickListener(event ->{
        	edificio.getAscensores().get(1).anyadirDestino(0);
        });
        tab2.addComponent(pb2, 4, 3);
        
        //Emergencia
        Button emergencia2 = new Button("!");
        emergencia2.addClickListener(event ->{
        	edificio.getAscensores().get(1).activarAlarma();
        });
        tab2.addComponent(emergencia2, 5, 3);
        
        //-----------------------------------------------------------------------------  	ASCENSOR 3
        
        //Botonera 1-6
        boton=1;
        for (int fila= 1; fila < 3; fila++) {
            for (int col=6; col < 9; col++) {
                Button button = new Button(""+boton); 
                button.addClickListener(event ->{
                	edificio.getAscensores().get(2).anyadirDestino(Integer.parseInt(button.getCaption()));
                });
                tab2.addComponent(button, col, fila);
                boton++;
            }
        }  
        //Boton abrir
        Button abrirPeta3 = new Button("<>");
        abrirPeta3.addClickListener(event ->{
        	edificio.getAscensores().get(2).cambiarEstadoPuerta();
        });
        tab2.addComponent(abrirPeta3, 6, 3);

        //Planta baja
        Button pb3 = new Button("PB");
        pb3.addClickListener(event ->{
        	edificio.getAscensores().get(2).anyadirDestino(0);
        });
        tab2.addComponent(pb3, 7, 3);
        
        //Emergencia
        Button emergencia3 = new Button("!");
        emergencia3.addClickListener(event ->{
        	edificio.getAscensores().get(2).activarAlarma();
        });
        tab2.addComponent(emergencia3, 8, 3);
        
        
        
        
        /*------------------------------------------------------PANTALLA PLANTA--------------------------------------------------------------*/
        
        //Altavoz
        Label altavoz = new Label("Altavoz:");
        altavoz.setSizeFull();
        tab3.addComponent(altavoz, 0, 0, 5, 0);
        
       //Display
       int asc = 1; 
       for(int i= 0; i < 6 ; i++) {
        	tab3.addComponent(new Label("Ascensor "+asc), i, 1);
        	asc++;
        	i++;
        }	 
       
       //Emergencia
       	boolean emg= false;       
        for(int i= 1; i < 6; i+=2) {
        	if(emg) {
        		tab3.addComponent(new Label("PELIGRO!"), i, 1);
        	}
        	else {
        		tab3.addComponent(new Label("OK"), i, 1);
        	}
        }	       
        //Ascensores
        for(int i= 0; i < 6; i+=2) {
        	tab3.addComponent(new Image(null, res1), i, 2);
        }  
        //Llamar ascensor
        int ascensorx = 1;
        for(int i= 1; i < 6; i+=2) {
        	Button boton1 = new Button(""+ascensorx);
        	boton1.addClickListener(event ->{
        		edificio.getPlantas().get(Integer.parseInt(boton1.getCaption())).llamarAscensor(edificio.getAscensores().get(Integer.parseInt(boton1.getCaption())));
        	});
        	tab3.addComponent(boton1, i, 2);
        	ascensorx++;
        }
        setContent(layout);
    }

	//Array List con los elementos web de vaadin que van a cambiar referenciados y pasarlos por parámetro al pulsar un boton. 
	
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}



