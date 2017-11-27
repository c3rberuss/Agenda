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
import java.text.SimpleDateFormat;
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
    
    
    public int cargarTarjetas(JPanel panel, Map componentes, MostrarEventos ev, String categoria){
        int count= 0;
        
        try {
            
            
            sql = "SELECT id, titulo, diaLetras, mesLetras from eventos where categoria='"+categoria+"'";
            
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
                
                TarjetaEvento tarjeta = new TarjetaEvento();
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
    
    public void crearEvento(String titulo, String descripcion, String fecha, String hora, String tipo, boolean repetir){
    
        try {
            
            sql = "INSERT INTO Agenda VALUES(?, ?, ?, ?, ?, ?)";
            
            statement = SegundoPlano.db.prepareStatement(sql);
            statement.setString(1, titulo);
            statement.setString(2, descripcion);
            statement.setString(3, fecha);
            statement.setString(4, hora);
            statement.setString(5, tipo);
            statement.setBoolean(6, repetir);
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Se guardó su Evento/Recordatorio Exitósamente.");
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    String[] datos = new String[10];
    public String[] detalle(String id){
        
        try {
            
            
            sql = "SELECT titulo, descripcion, dia, mes, anio, hora, categoria, repetir, repeticion, lugar "
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
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    
    
    public void guardarCambios(String id, String[] datos, Calendar cal, MostrarEventos event){
        try {
            sql = "UPDATE eventos SET titulo = ?,dia=?, mes=?, anio=?, mesLetras=?, "
                    + "diaLetras=? ,fecha = ?, hora=?, categoria=?, descripcion=?, "
                    + "repetir=?, repeticion=?, lugar=? where id=?";
            
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
            
            statement.setString(14, id);
            
            statement.executeUpdate();
            
            
            actualizarTarjeta(MostrarEventos.componentes, id, this.meses.get(datos[2]).toString(), 
                    this.diaSemana.get(datos[4]).toString() + ", "+datos[1], datos[0]);
                        
            JOptionPane.showMessageDialog(null, "Los cambios se guardaron exitosamente.");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
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
    
    public void actualizarFecha(String id, String fecha){
        
        int dia, mes, anio, diaSem;
        String fechaFormato = null;
        Date date = new Date();
        
        dia = Integer.valueOf(fecha.substring(0, 2));
        mes = Integer.valueOf(fecha.substring(3, 5)) - 1;
        anio = Integer.valueOf(fecha.substring(6));
        
        Calendar cal = Calendar.getInstance();
        cal.set(anio, mes, dia);
        diaSem = cal.get(Calendar.DAY_OF_WEEK);
        
        sql = "UPDATE eventos SET dia=?, mes=?, anio=?, diaLetra=?, mesLetras=? WHERE id=?";
        
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
    
    
    public void fecha(Calendar calendario){

        String dia = String.valueOf(calendario.get(Calendar.DAY_OF_WEEK));
        String mes = String.valueOf(calendario.get(Calendar.MONTH));
        
        fecha[0] = diaSemana.get(dia).toString() + ", "+calendario.get(Calendar.DAY_OF_MONTH);
        fecha[1] = meses.get(mes).toString(); 
        
    }
    
    
    
    
}
