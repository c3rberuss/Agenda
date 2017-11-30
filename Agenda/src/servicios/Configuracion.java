/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import vistas.Perfil;

/**
 *
 * @author c3rberuss
 */
public class Configuracion {
    
    private String osName;
    private String rootPath;
    private Properties propiedades;
    private String separador;
    
    public Configuracion(){
        
        separador = System.getProperty("file.separator");
        osName = System.getProperty("os.name").toLowerCase();
        rootPath = System.getProperty("user.home")+System.getProperty("file.separator");
        
        propiedades = new Properties();
        
        if(osName.contains("linux")){
            
            rootPath = rootPath + ".Agenda";
           
        }else if(osName.contains("windows")){
                  
            rootPath = rootPath + "Agenda";
            
            System.out.println(rootPath);
        }
           
    }
    
    private void crearCarpeta(){
        
        try {
            
            File carpetaRaiz = new File(rootPath);
            
            if(!carpetaRaiz.exists()){
                carpetaRaiz.mkdir();

                if(osName.contains("windows")){
                    String[] cmd = {"ATTRIB", rootPath, "+H"};
                    System.out.println(rootPath);
                    Runtime.getRuntime().exec(cmd); 
                }
            }
            
        } catch (IOException ioe) {
            System.out.println (ioe);
        }
        
    }
    
    private void crearBD(){
        try {
            
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:"+rootPath+separador+"agenda.db"); 
            
            String sql ="CREATE TABLE `eventos` (\n" +
                        "	`titulo`	TEXT,\n" +
                        "	`descripcion`	TEXT,\n" +
                        "	`fecha`	TEXT,\n" +
                        "	`hora`	TEXT,\n" +
                        "	`categoria`	TEXT,\n" +
                        "	`repetir`	TEXT,\n" +
                        "	`dia`	INTEGER,\n" +
                        "	`id`	INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                        "	`mes`	INTEGER,\n" +
                        "	`horaFin`	TEXT,\n" +
                        "	`anio`	INTEGER,\n" +
                        "	`diaLetras`	TEXT,\n" +
                        "	`mesLetras`	TEXT,\n" +
                        "	`repeticion`	TEXT,\n" +
                        "	`lugar`	TEXT,\n" +
                        "	`diaSemana`	INTEGER\n" +
                        ");";
            
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
            
            
            sql="CREATE TABLE `perfil` (\n" +
                "	`nombre`	TEXT,\n" +
                "	`fechaNacimiento`	TEXT\n" +
                ");";
            
            statement = con.prepareStatement(sql);
            statement.executeUpdate();
            
            con.close();
                    
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void crearPropiedades(){
        
        String separador = System.getProperty("file.separator");
        
        try {
            File archivo = new File(rootPath+separador+"config.properties");
            BufferedWriter bw;
            
            if(!archivo.exists()) {

            
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write("root=none\n"+
                        "init=false"); 
                bw.close();
            
            }
            
        } catch (IOException ex) {
                Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    private void setPropiedad(){

        
        try {
            
            propiedades.load(new FileReader(rootPath+separador+"config.properties"));
            propiedades.setProperty("root", rootPath);
            propiedades.setProperty("init", "true");
            propiedades.store(new FileWriter(rootPath+separador+"config.properties"),"Carpeta raiz oculta");
            
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }
    
    public String getPropiedad(String key){
        
        String prop = null;
        
        try {
            
            propiedades.load(new FileReader(rootPath+separador+"config.properties"));
            
            switch(key.toLowerCase()){
                case "root":
                    prop = propiedades.getProperty("root");
                    break;
                
                case "init":
                    prop = propiedades.getProperty("init");
                    break;
                    
                default:
                    prop = "propiedad no definida";
            }
           
            
            
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return prop;
        
    }
    
    public void inicializar(){
        
        crearCarpeta();
        crearPropiedades();
        
        if(!Boolean.valueOf(getPropiedad("init"))){
            crearBD();
            setPropiedad();
        }
        
    }
}
