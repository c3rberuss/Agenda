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
import vistas.Principal;

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
    public static boolean perfilIniciado;
    
    public static void main(String[] args) {
        
        conf = new Configuracion();
        conf.inicializar(); 
        root = conf.getPropiedad("root");
        
        //se inicializa la variable 
        perfilIniciado = Boolean.valueOf(conf.getPropiedad("perfil"));
       
        //se verifica si la aplicacion ya se está ejecutando
        try {
            JUnique.acquireLock("Agenda-UES_FMO");
        } catch (AlreadyLockedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        
        //se inicia un nuevo hilo. (se encarga de ver si hay eventos programados en la fecha y hora actual)
        SegundoPlano background = new SegundoPlano();
        Thread hilo = new Thread(background); 
        hilo.start();
        
        //se inicia la pnatalla principal
        Principal principal = new Principal();
        principal.setVisible(true);
        
    }
    
}
