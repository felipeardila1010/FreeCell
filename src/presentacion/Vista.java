package presentacion;

import java.awt.Canvas;
import java.awt.Toolkit;

public class Vista extends javax.swing.JFrame{

    private final Modelo modelo;
    private Controlador control;
    
    public Vista(Modelo aThis) {
        modelo = aThis;
        initComponents();
        capturarEventos();
    }

     private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        setSize(xSize,ySize);
        
        lienzo = new Canvas(); 
        add(lienzo);
    }                       
     
    public Canvas getLienzo() {
        return lienzo;
    }
    
    public Modelo getModelo() {
        return modelo;
    }
    
    public Controlador getControl() {
        if(control == null){
            control = new Controlador(this);
        }
        return control;
    }
    
    // Variables declaration - do not modify     
    private Canvas lienzo;
    // End of variables declaration                   
    
    private void capturarEventos() {
        lienzo.addMouseMotionListener(getControl());
    }
        
}
