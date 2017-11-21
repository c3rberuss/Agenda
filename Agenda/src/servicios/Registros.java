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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vistas.Eventos;
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
    
    public int cargarCumpleanios(JPanel panel, Map componentes, MostrarEventos ev){
        
        int count= 0;
        
        try {
            
            
            sql = "SELECT id, titulo, dia, mes from eventos where categoria='Cumpleaños'";
            
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
                tarjeta.Mes.setText(rs.getString("mes"));
                tarjeta.Fecha.setText(rs.getString("dia"));
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
    
        
    public int cargarCitas(JPanel panel, Map componentes, MostrarEventos ev){
        
        int count= 0;
        
        try {
            
            
            sql = "SELECT id, titulo, dia, mes from eventos where categoria='Cita Médica'";
            
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
                tarjeta.Mes.setText(rs.getString("mes"));
                tarjeta.Fecha.setText(rs.getString("dia"));
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
        
     
    public int cargarReuniones(JPanel panel, Map componentes, MostrarEventos ev){
        
        int count= 0;
        
        try {
            
            
            sql = "SELECT id, titulo, dia, mes from eventos where categoria='Reuniones'";
            
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
                tarjeta.Mes.setText(rs.getString("mes"));
                tarjeta.Fecha.setText(rs.getString("dia"));
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
    
    public int cargarBodas(JPanel panel, Map componentes, MostrarEventos ev){
        
        int count= 0;
        
        try {
            
            
            sql = "SELECT id, titulo, dia, mes from eventos where categoria='Bodas'";
            
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
                tarjeta.Mes.setText(rs.getString("mes"));
                tarjeta.Fecha.setText(rs.getString("dia"));
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
    
    public int cargarOtros(JPanel panel, Map componentes, MostrarEventos ev){
        
        int count= 0;
        
        try {
            
            
            sql = "SELECT id, titulo, dia, mes from eventos where categoria='Otros'";
            
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
                tarjeta.Mes.setText(rs.getString("mes"));
                tarjeta.Fecha.setText(rs.getString("dia"));
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
    
    String[] datos = new String[5];
    public String[] detalle(String id){
        
        try {
            
            
            sql = "SELECT titulo, descripcion, fecha, hora, categoria from eventos where id=?";
            
            statement = SegundoPlano.db.prepareStatement(sql);
            statement.setInt(1, Integer.valueOf(id));
            
            rs = statement.executeQuery();
            
            while(rs.next()){
                
                datos[0] = rs.getString("titulo");
                datos[1] = rs.getString("descripcion");
                datos[2] = rs.getString("fecha");
                datos[3] = rs.getString("hora");
                datos[4] = rs.getString("categoria");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    
}
