/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import LogicaNegocio.FlujoPrincipal;
import LogicaNegocio.Jugador;
import java.util.Collection;
import model.model;
/**
 *
 * @author Alonso
 */
public class control {

    private FlujoPrincipal fp;

    private static control uniqueInstance;

    public static control instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new control();
        }
        return uniqueInstance;
    }

    public control() {
        fp = new FlujoPrincipal();
    }

    public Collection listarFichas () throws Exception {
        return fp.listarFichas();
    }
    
    public void insertarJugador (Jugador elJugador) throws Exception {
        fp.insertarJugador(elJugador);
    }
    
    

}
