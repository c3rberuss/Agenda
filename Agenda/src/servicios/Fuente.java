/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.awt.Font;
import java.io.InputStream;

/**
 *
 * @author c3rberuss
 */
public class Fuente {
    
    private Font font= null;
    
    public Fuente(String fuente){
        String fontName = "8-bit.ttf" ;
        try {
            //Se carga la fuente
            InputStream is =  getClass().getResourceAsStream("/recursos/fuentes/"+fuente+".ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            //Si existe un error se carga fuente por defecto ARIAL
            System.err.println(fuente+".ttf" + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);            
        }
    }
    
    /* Font.PLAIN = 0 , Font.BOLD = 1 , Font.ITALIC = 2
 * tamanio = float
 */
    public Font MiFont( int estilo, float tamanio)
    {
        Font tfont = font.deriveFont(estilo, tamanio);
        return tfont;
    }
    
}
