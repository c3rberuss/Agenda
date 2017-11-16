/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import it.sauronsoftware.junique.AlreadyLockedException;
import it.sauronsoftware.junique.JUnique;
import javax.swing.JOptionPane;
import servicios.Configuracion;
import servicios.SegundoPlano;
import vistas.Cronometro;

/**
 *
 * @author c3rberuss
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    
    public static String root;
    private static Configuracion conf;
    
    public static void main(String[] args) {
        
        conf = new Configuracion();
        conf.inicializar(); 
        root = conf.getPropiedad("root");
         
        System.out.println(root);
        System.out.println(System.getProperty("os.name").toLowerCase());
       
        try {
            JUnique.acquireLock("Agenda-UES_FMO");
        } catch (AlreadyLockedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        
        Cronometro cron = new Cronometro();
        cron.setLocationRelativeTo(null);
        cron.setVisible(true);
        
        SegundoPlano background = new SegundoPlano();
        Thread hilo = new Thread(background); 
        hilo.start();
       
        
    }
    
}
