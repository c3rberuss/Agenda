/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.awt.GridBagConstraints;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vistas.MostrarEventos;
import vistas.MostrarNota;
import vistas.Notas;
import vistas.TarjetaEvento;

/**
 *
 * @author c3rberuss
 */
public class Registros {
    
    private PreparedStatement statement;
    private String sql;
    private ResultSet rs;
    private Map meses;
    private Map diaSemana;
    
    private String[] fecha;
    
    
    public Registros(){
        
        meses = new HashMap();
        diaSemana = new HashMap();
        fecha = new String[2];
        
        meses.put("0", "ENE");
        meses.put("1", "FEB");
        meses.put("2", "MAR");
        meses.put("3", "ABR");
        meses.put("4", "MAY");
        meses.put("5", "JUN");
        meses.put("6", "JUL");
        meses.put("7", "AGO");
        meses.put("8", "SEP");
        meses.put("9", "OCT");
        meses.put("10", "NOV");
        meses.put("11", "DIC");
        
        diaSemana.put("1", "Domingo");
        diaSemana.put("2", "Lunes");
        diaSemana.put("3", "Martes");
        diaSemana.put("4", "Miercoles");
        diaSemana.put("5", "Jueves");
        diaSemana.put("6", "Viernes");
        diaSemana.put("7", "Sábado");
        
    }
    
    //muestra las "tarjetas"con los eventos guardados
    public int cargarTarjetas(JPanel panel, Map componentes, MostrarEventos ev, String categoria, String orden){
        int count= 0;
        
        try {
            
           switch(orden.toLowerCase()){
               case "general":
                   
                   sql = "SELECT id, titulo, diaLetras, mesLetras from eventos where categoria='"+categoria+"'"
                           + " order by anio, dia, mes ASC";
                   
                   break;
               case "por día":
                   
                   sql = "SELECT id, titulo, diaLetras, mesLetras from eventos where "
                           + "categoria='"+categoria+"' order by diaSemana, mes ASC";
                   
                   break;
               case "por mes":
                   sql = "SELECT id, titulo, diaLetras, mesLetras from eventos where "
                           + "categoria='"+categoria+"' order by mes ASC";

                   break;
               case "por año":
                   
                   sql = "SELECT id, titulo, diaLetras, mesLetras from eventos where "
                           + "categoria='"+categoria+"' order by anio ASC";
                   
                   break;
           }
            
            statement = SegundoPlano.db.prepareStatement(sql);
            
            rs = statement.executeQuery();
            
            GridBagConstraints constraints = new GridBagConstraints();
            int fila = 0;
            int columna = 0;
            
            while(rs.next()){
                
                if(columna == 2){
                    fila++;
                    columna = 0;
                }
                
                TarjetaEvento tarjeta = new TarjetaEvento(rs.getString("mesLetras"));
                tarjeta.titulo.setText(rs.getString("titulo"));
                tarjeta.Mes.setText(rs.getString("mesLetras"));
                tarjeta.Fecha.setText(rs.getString("diaLetras"));
                tarjeta.Ver.setActionCommand(rs.getString("id"));
                tarjeta.Ver.addActionListener(ev);
                
                constraints = new GridBagConstraints();
                
                constraints.gridx = columna;
                constraints.gridy = fila;
                constraints.gridwidth = 1;
                constraints.gridheight = 1;
                constraints.weightx = 1.0;
                constraints.weighty = 0.8;
                constraints.fill = GridBagConstraints.NONE;
                
                panel.add(tarjeta, constraints);
                panel.updateUI();
                componentes.put(rs.getString("id"), tarjeta);
                count++;
                columna++;

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return count; 
        
    }
    
    //Guarda eventos en la base de datos
    public void crearEvento(Map datos){
    
        try {
            
            sql = "INSERT INTO eventos VALUES(?, ?, ?, ?, ?, ?, ?, null, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            statement = SegundoPlano.db.prepareStatement(sql);
            
            statement.setString(1, datos.get("titulo").toString());
            statement.setString(2, datos.get("descripcion").toString());
            statement.setString(3, datos.get("fecha").toString());
            statement.setString(4, datos.get("hora").toString());
            statement.setString(5, datos.get("categoria").toString());
            statement.setString(6, datos.get("repetir").toString());
            statement.setInt(7, Integer.valueOf(datos.get("dia").toString()));
            
            statement.setInt(8, Integer.valueOf(datos.get("mes").toString()));
            statement.setString(9, datos.get("horaFin").toString());
            statement.setInt(10, Integer.valueOf(datos.get("anio").toString()));
            
            String diaLetras = diaSemana.get(String.valueOf(datos.get("diaLetras"))) + 
                    ", "+String.valueOf(datos.get("dia"));
            
            System.out.println(diaLetras);
            
            statement.setString(11, diaLetras);
           

            String mesLetras = meses.get(datos.get("mesLetras").toString()).toString();
            statement.setString(12, mesLetras);
            statement.setString(13, datos.get("repeticion").toString());
            
            statement.setString(14, datos.get("lugar").toString());
            
            statement.setInt(15, Integer.valueOf(datos.get("diaSemana").toString()));
            
            statement.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    //Elimina Eventos de la Base de Datos 
    public void eliminarEvento(String id){
        sql = "DELETE FROM eventos WHERE id=?";
        
        try {
            
            statement = SegundoPlano.db.prepareStatement(sql);
            
            statement.setInt(1, Integer.valueOf(id));
            
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Metodo para mostrar en detalle cada uno de los eventos
    String[] datos = new String[11];
    public String[] detalle(String id){
        
        try {
            
            sql = "SELECT titulo, descripcion, dia, mes, anio, hora, categoria, repetir, repeticion, lugar, horaFin "
                    + "from eventos where id=?";
            
            statement = SegundoPlano.db.prepareStatement(sql);
            statement.setInt(1, Integer.valueOf(id));
            
            rs = statement.executeQuery();
            
            while(rs.next()){
                
                datos[0] = rs.getString("titulo");
                datos[1] = rs.getString("descripcion");
                datos[2] = rs.getString("anio");
                datos[3] = rs.getString("mes");
                datos[4] = rs.getString("dia");
                datos[5] = rs.getString("hora");
                datos[6] = rs.getString("categoria");
                datos[7] = rs.getString("repetir");
                datos[8] = rs.getString("repeticion");
                datos[9] = rs.getString("lugar");
                datos[10] = rs.getString("horaFin");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    
    
    //guarda los cambios realiados en la vista detallada de cada evento 
    public void guardarCambios(String id, String[] datos, Calendar cal, MostrarEventos event){
        try {
            sql = "UPDATE eventos SET titulo = ?,dia=?, mes=?, anio=?, mesLetras=?, "
                    + "diaLetras=? ,fecha = ?, hora=?, categoria=?, descripcion=?, "
                    + "repetir=?, repeticion=?, lugar=?, horaFin=? where id=?";
            
            statement = SegundoPlano.db.prepareStatement(sql);
            
            fecha(cal);
            
            
            statement.setString(1, datos[0]);
            statement.setString(2, datos[1]);
            statement.setString(3, datos[2]);
            statement.setString(4, datos[3]);
           
            statement.setString(5, this.meses.get(datos[2]).toString());
            statement.setString(6, this.diaSemana.get(datos[4]).toString() + ", "+datos[1]);
            statement.setString(7, datos[5]);
            
            statement.setString(8, datos[6]);
            statement.setString(9, datos[7]);
            statement.setString(10, datos[8]);
            statement.setString(11, datos[9]);
            statement.setString(12, datos[10]);
            statement.setString(13, datos[11]);
            statement.setString(14, datos[12]);
            
            statement.setString(15, id);
            
            statement.executeUpdate();
            
            
            actualizarTarjeta(MostrarEventos.componentes, id, this.meses.get(datos[2]).toString(), 
                    this.diaSemana.get(datos[4]).toString() + ", "+datos[1], datos[0]);
                        
            JOptionPane.showMessageDialog(null, "Los cambios se guardaron exitosamente.");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //actualiza la UI de la tarjeta especificada
    public void actualizarTarjeta(Map tarjetas, String id, String mes, String dia, String titulo){
        
        Iterator it = tarjetas.entrySet().iterator();
        
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            
            String itm = entry.getKey().toString();
            
            if(itm.equals(id)){
                ((TarjetaEvento)entry.getValue()).titulo.setText(titulo);
                ((TarjetaEvento)entry.getValue()).Mes.setText(mes);
                ((TarjetaEvento)entry.getValue()).Fecha.setText(dia);
                
                ((TarjetaEvento)entry.getValue()).updateUI();
            }
        }
        
    }
    
    //actualiza la fecha del evento en la base de Datos
    public void actualizarFecha(String id, String fecha){
        
        int dia, mes, anio, diaSem;
        String fechaFormato = null;
        Date date = new Date();
        
        dia = Integer.valueOf(fecha.substring(0, 2));
        mes = Integer.valueOf(fecha.substring(3, 5)) - 1;
        anio = Integer.valueOf(fecha.substring(6));
        
        fechaFormato = String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(anio);
        
        Calendar cal = Calendar.getInstance();
        cal.set(anio, mes, dia);
        diaSem = cal.get(Calendar.DAY_OF_WEEK);
        
        sql = "UPDATE eventos SET dia=?, mes=?, anio=?, diaLetras=?, mesLetras=? WHERE id=?";
        
        try {
            statement = SegundoPlano.db.prepareStatement(sql);
            
            statement.setInt(1, dia);
            statement.setInt(2, mes);
            statement.setInt(3, anio);
            
            statement.setString(4, diaSemana.get(String.valueOf(diaSem)).toString()+", "+dia);
            statement.setString(5, meses.get(String.valueOf(mes)).toString());
            
            statement.setString(6, id);
            
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    //Retorna el dia de la semana y la abreviación del mes  
    public void fecha(Calendar calendario){

        String dia = String.valueOf(calendario.get(Calendar.DAY_OF_WEEK));
        String mes = String.valueOf(calendario.get(Calendar.MONTH));
        
        fecha[0] = diaSemana.get(dia).toString() + ", "+calendario.get(Calendar.DAY_OF_MONTH);
        fecha[1] = meses.get(mes).toString(); 
        
    }
    
   //guarda el perfil y crear el evento del cumpleaños
    public void guardarPerfil(String nombre, Calendar fecha_){
        
        sql = "INSERT INTO perfil VALUES(?, ?)";
        String fechaNac = null;
        
        try {
            
            statement = SegundoPlano.db.prepareStatement(sql);
            
            statement.setString(1, nombre);
            
            fechaNac = String.valueOf(fecha_.get(Calendar.DAY_OF_MONTH))+"/"+
                       String.valueOf(fecha_.get(Calendar.MONTH)+1)+"/"+
                       String.valueOf(fecha_.get(Calendar.YEAR));
            
            statement.setString(2, fechaNac);
            
            statement.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Map datos = new HashMap();
        
        datos.put("titulo", ".* Mi Cumpleaños *.");
        datos.put("descripcion", "Uno de los días más esperados.");
        datos.put("fecha", fechaNac);
        datos.put("hora", "05:00");
        datos.put("categoria", "Cumpleaños");
        datos.put("repetir", "SI");
        datos.put("dia", String.valueOf(fecha_.get(Calendar.DAY_OF_MONTH)));
        datos.put("mes", String.valueOf(fecha_.get(Calendar.MONTH)));
        datos.put("horaFin", "23:59");
        datos.put("anio", String.valueOf(fecha_.get(Calendar.YEAR)));
        datos.put("diaLetras", fecha_.get(Calendar.DAY_OF_WEEK));
        
        datos.put("mesLetras", fecha_.get(Calendar.MONTH));
        datos.put("repeticion", "Anualmente");
        datos.put("lugar", "Indefinido");
        datos.put("diaSemana", fecha_.get(Calendar.DAY_OF_WEEK));
        
        crearEvento(datos);
        
    }
    
    //agrega apuntes o notas a la Base de Datos
    public void agregarApunte(String titulo, String contenido){
        
        sql = "INSERT INTO apuntes VALUES(null, ?, ?)";
        
        try {
            
            statement = SegundoPlano.db.prepareStatement(sql);
            
            statement.setString(1, titulo);
            statement.setString(2, contenido);
            
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    //Guarda los cambios hechos en los apuntes a detalle
    public void guardarApunte(String id, String titulo, String contenido){
        
        sql = "UPDATE apuntes SET titulo=?, contenido=? WHERE id=?";
        
        try {
            
            statement = SegundoPlano.db.prepareStatement(sql);
            
            statement.setString(1, titulo);
            statement.setString(2, contenido);
            statement.setString(3, id);

            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //elimina el apunte seleccionado de la basede datos
    public void eliminarApunte(String id){
        
        sql = "DELETE FROM apuntes WHERE id=?";
        
        try {
            
            statement = SegundoPlano.db.prepareStatement(sql);
            
            statement.setString(1, id);

            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    //muestra a detalle apunte/nota seleccionado
    String[] cont = new String[3];     
    public String[] mostrarApunte(String id){
        
        sql = "SELECT * FROM apuntes WHERE id=?";
        
        try {
            
            statement = SegundoPlano.db.prepareStatement(sql);
            
            statement.setString(1, id);

            rs = statement.executeQuery();
            
            while(rs.next()){
                cont[0] = rs.getString("id");
                cont[1] = rs.getString("titulo");
                cont[2] = rs.getString("contenido");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cont;
    }
    
    
    //carga las tarjetas de las notas
    public int cargarNotas(JPanel panel, Map notas, MostrarNota ev){
        
       sql = "SELECT * FROM apuntes";
       int count = 0;
       
        try {
            
            statement = SegundoPlano.db.prepareStatement(sql);
            
            rs = statement.executeQuery();
            
            GridBagConstraints constraints = new GridBagConstraints();
            
            int fila = 0;
            int columna = 0;
            
            while(rs.next()){
                
                if(columna == 2){
                    fila++;
                    columna = 0;
                }
                
                Notas tarjeta = new Notas();
                tarjeta.titulo.setText(rs.getString("titulo"));
                tarjeta.contenido.setText(rs.getString("contenido")+"...");
                tarjeta.Ver.setActionCommand(rs.getString("id"));
                tarjeta.Ver.addActionListener(ev);
                
                constraints = new GridBagConstraints();
                
                constraints.gridx = columna;
                constraints.gridy = fila;
                constraints.gridwidth = 1;
                constraints.gridheight = 1;
                constraints.weightx = 1.0;
                constraints.weighty = 0.8;
                constraints.fill = GridBagConstraints.NONE;
                
                panel.add(tarjeta, constraints);
                panel.updateUI();
                notas.put(rs.getString("id"), tarjeta);
                count++;
                columna++;

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return 0;
    }
    
    //carga el perfil antes guardado
    public String[] cargarPerfil(){
        
        String[] datos = new String[2];
        int count = 0;
        
        sql = "SELECT nombre, fechaNacimiento FROM perfil";
        
        try {
            
            statement = SegundoPlano.db.prepareStatement(sql);
            
            rs = statement.executeQuery();
            
            while(rs.next()){
                datos[0] = rs.getString("nombre");
                datos[1] = rs.getString("fechaNacimiento");
                count++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(count < 1){
            datos[0] = "Indefinido";
            datos[1] = "28/08/1998";
        }
        
        return datos;
    }
    
    
    public int count(){
        int c = 0;
        
        sql = "SELECT COUNT(*) FROM eventos WHERE titulo=?";
        
        try {
            
            statement = SegundoPlano.db.prepareStatement(sql);
            
            statement.setString(1, ".* Mi Cumpleaños *.");
            
            rs = statement.executeQuery();
            
            while(rs.next()){
                c++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        return c;
    }
    
    
    //actualiza perfil del usuario
    public void actualizarPerfil(String nombre, Calendar fecha_){
        
        sql = "update perfil set nombre=?, fechaNacimiento=?";
        String fechaNac = null;
        
        try {
            
            statement = SegundoPlano.db.prepareStatement(sql);
            
            statement.setString(1, nombre);
            
            fechaNac = String.valueOf(fecha_.get(Calendar.DAY_OF_MONTH))+"/"+
                       String.valueOf(fecha_.get(Calendar.MONTH))+"/"+
                       String.valueOf(fecha_.get(Calendar.YEAR));
            
            statement.setString(2, fechaNac);
            
            statement.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
