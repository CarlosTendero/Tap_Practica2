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
    	
    	final HorizontalLayout layout = new HorizontalLayout();
    	
        TabSheet tabsheet = new TabSheet();
        
        
        //Crear Pestañas
        GridLayout tab1 = new GridLayout(3,4);
    	tabsheet.addTab(tab1, "Panel de control");

    	GridLayout tab2 = new GridLayout(3, 5);
    	tabsheet.addTab(tab2, "Cabina ascensor");
    	  	
        GridLayout tab3 = new GridLayout(6, 3);
    	tabsheet.addTab(tab3, "Planta");
    	
        layout.addComponents(tabsheet);
        
        //TAB1
        //Imagen de ascensores
        Resource res1 = new ThemeResource("ascensor.png");
 

        //Introducción de 3 imagenes
        Image ascensor = new Image(null , res1);   
        tab1.addComponent(ascensor, 0, 0);
        Image ascensor2 = new Image(null , res1); 
        tab1.addComponent(ascensor2, 1,0);
        Image ascensor3 = new Image(null , res1);
        tab1.addComponent(ascensor3, 2,0);
        
        //Estados
        Label button1A1 = new Label("Estado movimiento A1");
        tab1.addComponent(button1A1, 0,1);
        Label button2A1 = new Label("Estado movimiento A2");
        tab1.addComponent(button2A1, 1,1);
        Label button3A1 = new Label("Estado movimiento A3");
        tab1.addComponent(button3A1, 2,1);
        
        
        Label button1A2 = new Label("Estado A1");
        tab1.addComponent(button1A2, 0,2);
        Label button2A2 = new Label("Estado A2");
        tab1.addComponent(button2A2, 1,2);
        Label button3A2 = new Label("Estado A3");
        tab1.addComponent(button3A2, 2,2);
        
        Label button1A3 = new Label("Estado emergencia A1");
        tab1.addComponent(button1A3, 0,3);
        Label button2A3 = new Label("Estado emergencia A2");
        tab1.addComponent(button2A3, 1,3);
        Label button3A3 = new Label("Estado emergencia A3");
        tab1.addComponent(button3A3, 2,3);        

        //TAB 2
        Label display = new Label("Piso cansado");
        tab2.addComponent(display, 0, 0, 2, 0);

        
        //Botonera
        Button buttonPB = new Button("PB");
        buttonPB.setWidth("100.0%");
        buttonPB.setHeight("100.0%");
        tab2.addComponent(buttonPB, 1, 3);
        
        Button button1 = new Button("1");
        tab2.addComponent(button1, 0, 1);
        
        Button button2 = new Button("2");
        tab2.addComponent(button2, 1, 1);
        
        Button button3 = new Button("3");
        tab2.addComponent(button3, 2, 1);
        
        Button button4 = new Button("4");
        tab2.addComponent(button4, 0, 2);
        
        Button button5 = new Button("5");
        tab2.addComponent(button5, 1, 2);
        
        Button button6 = new Button("6");
        tab2.addComponent(button6, 2, 2);
        
        Button buttonAbrir = new Button("<->");
        buttonAbrir.setWidth("100.0%");
        buttonAbrir.setHeight("100.0%");
        tab2.addComponent(buttonAbrir, 0, 3);
        
        Button buttonCerrar = new Button("><");
        buttonCerrar.setWidth("100.0%");
        buttonCerrar.setHeight("100.0%");
        tab2.addComponent(buttonCerrar, 2, 3);
         
        //Emergencia
        Label emergencia = new Label("Botón de emergencia");
        tab2.addComponent(emergencia, 0, 4, 2, 4);
        
        //TAB 3
        //6x1 altavoz
        Label altavoz = new Label("altavoz");
        altavoz.setSizeFull();
        tab3.addComponent(altavoz, 0, 0, 5, 0);

        //Displays
        Label display1 = new Label("display ascensor 1");
        display1.setSizeFull();
        tab3.addComponent(display1,0, 1);
        
        Label display2 = new Label("display ascensor 2");
        display1.setSizeFull();
        tab3.addComponent(display2,2, 1);
        
        Label display3 = new Label("display ascensor 3");
        display1.setSizeFull();
        tab3.addComponent(display3,4, 1);
         
        //Emergencia
        Label emergenciaA1 = new Label("Emergencia A1");
        emergenciaA1.setSizeFull();
        tab3.addComponent(emergenciaA1,1, 1);
        
        Label emergenciaA2 = new Label("Emergencia A2");
        emergenciaA2.setSizeFull();
        tab3.addComponent(emergenciaA2,3, 1);
        
        Label emergenciaA3 = new Label("Emergencia A3");
        emergenciaA3.setSizeFull();
        tab3.addComponent(emergenciaA3,5, 1);

        //Ascensores 
        Label A1 = new Label("Ascensor 1");
        A1.setSizeFull();
        tab3.addComponent(A1,0, 2);
        
        Label A2 = new Label("Ascensor 2");
        ascensor2.setSizeFull();
        tab3.addComponent(A2,2, 2);
        
        Label A3 = new Label("Ascensor 3");
        A3.setSizeFull();
        tab3.addComponent(A3,4, 2);
        
        //Boton llamar
        Button llamarA1 = new Button("LLamar al ascensor 1");
        llamarA1.setSizeFull();
        tab3.addComponent(llamarA1, 1, 2);
        
        Button llamarA2 = new Button("LLamar al ascensor 1");
        llamarA2.setSizeFull();
        tab3.addComponent(llamarA2, 3, 2);
        
        Button llamarA3 = new Button("LLamar al ascensor 1");
        llamarA3.setSizeFull();
        tab3.addComponent(llamarA3, 5, 2);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}


