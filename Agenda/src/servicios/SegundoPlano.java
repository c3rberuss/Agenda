/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import agenda.Agenda;
import vistas.Notificacion;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 *
 * @author c3rberuss
 */
public class SegundoPlano implements Runnable{

    private Clip sonido;
    public static Connection db;
    private PreparedStatement statement;
    private ResultSet result;
    private Calendar calendario;
    private int hora, minuto, dia, mes, anio;
    private AudioInputStream ais;
    private BufferedInputStream bis; 
    private Notificacion noti;
    
   
    public SegundoPlano(){
        try {
            System.out.println(this.getClass().getResource("/recursos/sonidos/notificacion.wav"));
            bis = new BufferedInputStream(getClass().getResourceAsStream("/recursos/sonidos/notificacion.wav"));
            ais = AudioSystem.getAudioInputStream(bis);
            sonido = AudioSystem.getClip();
            
            conectar();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(SegundoPlano.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void notificar(){

        //Se muestra la notificación
        
        noti = new Notificacion(5, "evento", "Notificación".toUpperCase(), "Texto de prueba");
        //Suena para notificar
        sonar();
        
    }
    
    
    public String[] mostrarHora(){
        String[] fechaHora = new String[2];
        
        calendario = Calendar.getInstance();
        
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minuto = calendario.get(Calendar.MINUTE);
        
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH)+1;
        anio = calendario.get(Calendar.YEAR);
        
        fechaHora[0] = String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(anio);
        fechaHora[1] = String.valueOf(hora)+":"+String.valueOf(minuto);
        
        System.out.println(hora + ":" + minuto);
        System.out.println(fechaHora[0]);
        System.out.println(fechaHora[1]);
        
        return fechaHora;
    }
    
    
    public void conectar(){
        try {
            Class.forName("org.sqlite.JDBC");
            
            String separador = System.getProperty("file.separator");
            
            
            db = DriverManager.getConnection("jdbc:sqlite:"+Agenda.root+separador+"agenda.db");
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(SegundoPlano.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean buscarEventos(String fecha,String hora){
        
        boolean entro = false;
        
        try {
            String sql = "SELECT * FROM eventos where hora=? AND fecha=?";
            statement = this.db.prepareStatement(sql);
            
            statement.setString(2, fecha);
            statement.setString(1, hora);
            
            result = statement.executeQuery();
            
            while(result.next()){
                notificar();
                entro = true;
                System.out.println("Entro al ciclo");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SegundoPlano.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return entro;
    }
    
    public void sonar(){
        try {
            
            //Se carga el clip de audio
            bis = new BufferedInputStream(getClass().getResourceAsStream("/recursos/sonidos/notificacion2.wav"));
            ais = AudioSystem.getAudioInputStream(bis);
            sonido = AudioSystem.getClip();
            sonido.open(ais);
            
            //inicia la reproducción
            sonido.start();
            //Se pausa el hilo para esperar la reproducción del Sonido
            Thread.sleep(1000);
            //se cierra el clip de audio
            sonido.close();
            
        } catch (LineUnavailableException | IOException | InterruptedException | UnsupportedAudioFileException ex) {
            Logger.getLogger(SegundoPlano.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        
        String[] fecha;
        
        while(true){
            try {
                fecha = new String[2];
                fecha = mostrarHora();
                //notificar();
                
               if( !buscarEventos(fecha[0], fecha[1])){
                   Thread.sleep(9450);
               }else{
                   Thread.sleep(10000);
               }
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(SegundoPlano.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
