package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Controlador implements ActionListener, MouseMotionListener{
    
    private final Vista ventana;

    public Controlador(Vista aThis) {
        ventana = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        ventana.getModelo().notificarCoordenadas(e.getX(), e.getY());
    }
}
