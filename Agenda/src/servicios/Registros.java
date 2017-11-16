/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author c3rberuss
 */
public class Registros {
    
    private PreparedStatement statement;
    private String sql;
    
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
    
}
