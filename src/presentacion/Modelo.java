package presentacion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.Map;
import logica.Baraja;
import logica.Tablero;

public class Modelo implements Runnable{

    private Tablero sistemaTablero;
    private Baraja sistemaBaraja;
    private Vista ventanaPrincipal;
    private Thread hiloDibujo;
    private BufferedImage dobleBuffer;

    public Modelo() {
        hiloDibujo = new Thread(this);
    }
    
    public Tablero getTablero() {
        if(sistemaTablero == null){
            sistemaTablero = new Tablero();
        }
        return sistemaTablero;
    }

    public Baraja getBaraja() {
        if(sistemaBaraja == null){
            sistemaBaraja = new Baraja();
        }
        return sistemaBaraja;
    }
    public Vista getVentanaPrincipal() {
        if(ventanaPrincipal == null){
            ventanaPrincipal = new Vista(this);
        }
        return ventanaPrincipal;
    }
    
    public void iniciar() {
        Canvas lienzo = getVentanaPrincipal().getLienzo();
        lienzo.setSize(getVentanaPrincipal().getSize());
        dobleBuffer = new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
        getVentanaPrincipal().setVisible(true);
        getTablero().setEstaDibujando(true);
        hiloDibujo.start();
    }
    
    public void dibujar(){
        Canvas lienzo = getVentanaPrincipal().getLienzo();
        Graphics lapiz = lienzo.getGraphics();
        Graphics lapizInvisible = dobleBuffer.getGraphics();

        lapizInvisible.setColor(Color.GRAY);
        lapizInvisible.fillRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
        lapizInvisible.setColor(new Color(255, 155, 54));
        
        dibujarTablero(lapizInvisible, lienzo);        
        lapiz.drawImage(dobleBuffer, 0, 0, lienzo);
    }

    private void dibujarTablero(Graphics lapiz, Canvas lienzo) {
        Map<String, Image> imagenesLista = getBaraja().getImagesLists();
        Map<String, String> coordenadasImagenes = getBaraja().asignarPosicionesCartas(imagenesLista);
        String[] dividirCoordenadas;
        
        Map.Entry<String, Image> mapTemporal;
        Iterator<Map.Entry<String, Image>> imagenesTemporal =imagenesLista.entrySet().iterator();
        while (imagenesTemporal.hasNext()) {
            mapTemporal = imagenesTemporal.next();
            dividirCoordenadas = coordenadasImagenes.get(mapTemporal.getKey()).split(",");
            lapiz.drawImage(mapTemporal.getValue(), Integer.parseInt(dividirCoordenadas[0]),Integer.parseInt(dividirCoordenadas[1]), lienzo);
        }
    }
    @Override
    public void run() {
        while (getTablero().isEstaDibujando()) {            
            dibujar();
        }
    }

    public void notificarCoordenadas(int x, int y) {
        getTablero().setPosX(x);
        getTablero().setPosY(y);
    }

    public void terminar() {
        System.exit(0);
    }
}
