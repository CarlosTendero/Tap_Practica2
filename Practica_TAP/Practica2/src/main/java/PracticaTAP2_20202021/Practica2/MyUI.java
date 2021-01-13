package PracticaTAP2_20202021.Practica2;

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
    	
		//Creación del layout y de la tabsheet
    	HorizontalLayout layout = new HorizontalLayout();
        TabSheet tabsheet = new TabSheet();
           
        //Creación de la pestaña de Panel de Control
        GridLayout tab1 = new GridLayout(3,4);
        tab1.setMargin(true);
        tab1.addStyleName("estiloTab");
    	tabsheet.addTab(tab1, "Panel de control");
    	
    	/*PANEL DE CONTROL*/
        //Imagen de ascensores
        Resource res1 = new ThemeResource("ascensor.png");

        //Añadir ascensores y estados
        for(int i= 0; i < 3; i++) {
        	tab1.addComponent(new Image(null, res1), i, 0);
        	tab1.addComponent(new Label("Estado movimiento A"+i), i, 1);
        	tab1.addComponent(new Label("Estado A"+i), i, 2);
        }
        
        //Añadir estado emergencia A
        for(int i= 0; i < 3; i++) {
        	tab1.addComponent(new Label("Estado emergencia A"+i), i, 3);
        }
        
        //Creación de las pestañas de Cabina del ascensor y planta
    	GridLayout tab2 = new GridLayout(3, 5);
        tab2.setMargin(true);
    	tabsheet.addTab(tab2, "Cabina del ascensor");
    	  	
        GridLayout tab3 = new GridLayout(8, 4);
        tab3.addStyleName("estiloTabPlanta");
        tab3.setMargin(true);
    	tabsheet.addTab(tab3, "Planta");
        layout.addComponents(tabsheet);
        
        /*CABINA ASCENSOR*/
        //Piso actual
        Label display = new Label("Display del piso actual");
        tab2.addComponent(display, 0, 0, 2, 0);
        
       
        //Botonera 1-6
        int boton=1;
        for (int fila= 1; fila < 3; fila++) {
        	for (int col=0; col < 3; col++) {
        		Button button = new Button(""+boton);
        		button.addStyleName("miBoton");
            	button.addClickListener(event ->
            	//edificio.ascensorxoLoquesea.planta...
            	System.out.println(button.getCaption()));
        		tab2.addComponent(button, col, fila);
        		boton++;
        	}
        }        
        //Boton abrir Puertas       
        Button abrirPeta = new Button("<>");
        abrirPeta.addStyleName("miBoton");
        abrirPeta.addClickListener(event ->
    	System.out.println(abrirPeta.getCaption()));
        tab2.addComponent(abrirPeta, 0, 3);

	    //Boton Cerrar Puertas	
	    Button cerrarPeta = new Button("><");
	    cerrarPeta.addStyleName("miBoton");
	    cerrarPeta.addClickListener(event ->
	    System.out.println(cerrarPeta.getCaption()));
        tab2.addComponent(cerrarPeta, 2, 3);
    	        
        //Planta baja  
        Button pb = new Button("PB");
	    pb.addStyleName("miBotonPB");
        pb.addClickListener(event ->
	    System.out.println(pb.getCaption()));  
        tab2.addComponent(pb, 1, 3);
   
        //Emergencia
        Button emergencia = new Button("🔔️");
	    emergencia.addStyleNames("miBotonEmergencia");
        emergencia.addClickListener(event ->
	    System.out.println(emergencia.getCaption()));  
        tab2.addComponent(emergencia, 0, 4, 2, 4);
       
        /*PLANTA*/      
        //Altavoz
        Label altavoz = new Label("🔊");
        altavoz.addStyleName("altavoz");
        altavoz.setSizeFull();
        tab3.addComponent(altavoz, 0, 0, 5, 0);

       //Display
       int asc = 1; 
       for(int i= 0; i < 6 ; i++) {
        	tab3.addComponent(new Label("display A"+asc), i, 1);
        	asc++;
        	i++;
        }	
       
       
       //Emergencia
       	boolean emg= false;
        
        for(int i= 1; i < 6; i+=2) {
        	if(emg) {
        		tab3.addComponent(new Label("⚠"), i, 1);
        	}
        	else {
        		tab3.addComponent(new Label("✓"), i, 1);
        	}
        }	

        //Ascensores
        for(int i= 0; i < 6; i+=2) {
        	tab3.addComponent(new Image(null, res1), i, 2);
        }
        
        //Llamar ascensor
       // int ascensorx = 1;
        for(int i= 1; i < 6; i+=2) {
        	Button boton1 = new Button("🔴");
            boton1.addStyleName("botonLlamar");
        	boton1.addClickListener(event ->
        	//edificio.ascensorxoLoquesea.planta...
        	System.out.println(boton1.getCaption()));

        	tab3.addComponent(boton1, i, 2);
        	//ascensorx++;
        }
        
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}


