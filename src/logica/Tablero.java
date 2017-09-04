package logica;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

public class Tablero {
    
    private boolean estaDibujando;    
    private int posX, posY;
    private Baraja sistemabaraja;
    
    public Baraja getBaraja() {
        if (sistemabaraja == null) {
            sistemabaraja = new Baraja();
        }
        return sistemabaraja;
    }
   
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }  

    public void setEstaDibujando(boolean estaDibujando) {
        this.estaDibujando = estaDibujando;
    }
    
    public boolean isEstaDibujando() {
        return estaDibujando;
    }
    
    public Map<String, Image> getComponentesTablero() {
        
        Image imgEspacio = new ImageIcon(this.getClass().getResource("/repo/espacio.png")).getImage().getScaledInstance(130, 180, Image.SCALE_SMOOTH);
        Map<String, Image> imagenesLista = new HashMap<>();
        
        for(short i=0;i<8;i++){
            if(i==4){
                imgEspacio = new ImageIcon(this.getClass().getResource("/repo/espacioA.png")).getImage().getScaledInstance(130, 180, Image.SCALE_SMOOTH);
            }
           imagenesLista.put("espacio"+i, imgEspacio);
        }

        return imagenesLista;
    }
    
    public Map<String, String> getCoordenadasComponentesTablero() {
        
        Map<String, String> coordenadas = new HashMap<>();
        short xtamanodistancia = 150;
        
        for(short i=0;i<8;i++){
           coordenadas.put("espacio"+i,(getBaraja().getXcoordenadaInicial() + (xtamanodistancia*i)) + "," + 0);
        }        

        return coordenadas;
    }
}
