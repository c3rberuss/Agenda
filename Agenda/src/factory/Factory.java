/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import javax.swing.JDialog;
import javax.swing.JFrame;
import servicios.Configuracion;
import servicios.Fuente;
import servicios.Registros;
import servicios.SegundoPlano;
import vistas.AgregarEvento;
import vistas.AgregarNota;
import vistas.Crono;
import vistas.DetalleEvento;
import vistas.MostrarEventos;

/**
 *
 * @author c3rberuss
 */
public class Factory {
    
    public Configuracion configuracion(){
        return new Configuracion();
    }
    
    public Fuente fuente(String nombreFuente){
        return new Fuente(nombreFuente);
    }
    
    public Registros registros(){
        return new Registros();
    }
    
    public SegundoPlano segundoPlano(){
        return new SegundoPlano();
    }
    
    public AgregarEvento agregarEvento(JDialog padre, boolean modal){
        return new AgregarEvento(padre, modal);
    }
    
    public AgregarNota agregarNota(JDialog padre, boolean modal){
        return new AgregarNota(padre, modal);
    }
    
    public Crono cronometro(JFrame padre, boolean modal){
        return new Crono(padre, modal);
    }
    
    public DetalleEvento detalleEvento(JFrame padre, boolean modal, String id, MostrarEventos evt){
        return new DetalleEvento(padre, modal, id, evt);
    }
    
}
