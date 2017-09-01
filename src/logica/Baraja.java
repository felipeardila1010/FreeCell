package logica;

import java.awt.Image;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ImageIcon;

public class Baraja {
    private final Map<String, Image> imagenesLista = new HashMap<>();
    private final Map<String, String> coordenadasImagenes = new HashMap<>();
    private final String[] tiposCartas = {"corazones","diamantes","picas","treboles"};
    private final String[] cartas = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private final short xcoordenadaInicial = 100;
    private final short ycoordenadaInicial = 140;
    
    public Map<String,Image> getImagesLists() {

        for (String tipoCarta : tiposCartas) {
            for (String carta : cartas) {
                imagenesLista.put(tipoCarta+carta, new ImageIcon(this.getClass().getResource("/repo/"+tipoCarta+"/"+carta+".png")).getImage());
            }
        }
        
        return imagenesLista;
    }
    public Map<String, String> asignarPosicionesCartas(Map<String,Image> imagenesLista){
        short temporalX = xcoordenadaInicial;
        short temporalY = ycoordenadaInicial;
        short numeroCartasEspacio = 0;
        Map.Entry<String, Image> mapTemporal;
        
        Iterator<Map.Entry<String, Image>> it = imagenesLista.entrySet().iterator();
        
        while (it.hasNext()) {
            if(numeroCartasEspacio == 7){
                numeroCartasEspacio = 0;
                temporalX = xcoordenadaInicial;
                temporalY += 60;
            }
            mapTemporal = it.next();
            coordenadasImagenes.put(mapTemporal.getKey(),temporalX + "," + temporalY);
            temporalX += 200;
            numeroCartasEspacio++;
        }
        
        return coordenadasImagenes;
    }
}
