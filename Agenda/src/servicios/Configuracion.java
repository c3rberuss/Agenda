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
        
        //se obtiene datos del sistema como el nombre del sistema operativo
        //el serapador de archivos y la carpeta home del usuario
        
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
    
    //crear la carpeta Agenda en la carpera HOME del usuario y la oculta
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
    
    //Se crea la Base de datos con SQLite
    private void crearBD(){
        try {
            
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:"+rootPath+separador+"agenda.db"); 
            
            String sql ="CREATE TABLE IF NOT EXISTS `eventos` (\n" +
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
            
            sql = "CREATE TABLE IF NOT EXISTS `apuntes` (\n" +
                "	`id`	INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                "	`titulo`	TEXT,\n" +
                "	`contenido`	TEXT\n" +
                ");";
            
            statement = con.prepareStatement(sql);
            statement.executeUpdate();
            
            con.close();
                    
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //crea el archivo de propiedades en la carpeta Agenda en el user.home
    private void crearPropiedades(){
        
        String separador = System.getProperty("file.separator");
        
        try {
            File archivo = new File(rootPath+separador+"config.properties");
            BufferedWriter bw;
            
            if(!archivo.exists()) {

                //inserta las propiedades en el archivo
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write("root=none\n"+
                        "init=false\n"
                        + "perfil=false"); 
                bw.close();
            
            }
            
        } catch (IOException ex) {
                Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    //cambia el valor de las propiedades del archivo 
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
    
    //modifica solo una propiedad del archivo
    public void modificarPropiedad(String key, String valor){
         try {
            
            propiedades.load(new FileReader(rootPath+separador+"config.properties"));
            propiedades.setProperty("perfil", valor);
            propiedades.store(new FileWriter(rootPath+separador+"config.properties"),"perfil creado");
            
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //retorna la propiedad con x Key (o identificador)
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
                
                case "perfil":
                    prop = propiedades.getProperty("perfil");
                    break;
                    
                default:
                    prop = "propiedad no definida";
            }
           
            
            
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return prop;
        
    }
    
    //ejecuta alguna de las funciones anteriores
    public void inicializar(){
        
        crearCarpeta();
        crearPropiedades();
        
        //verifica si la aplicacion ya ha sido inicializada
        if(!Boolean.valueOf(getPropiedad("init"))){
            crearBD();
            setPropiedad();
        }
        
    }
}
