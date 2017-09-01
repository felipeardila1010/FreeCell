package logica;

public class Tablero {
    
    private boolean estaDibujando;    
    private int posX, posY;    
   

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
    
}
