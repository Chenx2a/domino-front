/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

import AccesoDatos.ServicioFicha;
import AccesoDatos.ServicioJugador;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Daniel Gutierrez
 */

public class FlujoPrincipal {
    private final ServicioFicha servicioFicha;
    private final ServicioJugador servicioJugador;
    private static FlujoPrincipal uniqueInstance;

    public static FlujoPrincipal instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new FlujoPrincipal();
        }
        return uniqueInstance;
    }

    public FlujoPrincipal() {
        servicioFicha = new ServicioFicha();
        servicioJugador = new ServicioJugador();
    }
    
    public ArrayList<Ficha> listarFichas() throws Exception{
        return servicioFicha.listarFichas();
    }
    
    public void actualizarFicha(Ficha laFicha) throws Exception{
        servicioFicha.actualizarFicha(laFicha);
    }
    
    public void insertarJugador(Jugador elJugador) throws Exception{
        servicioJugador.insertarJugador(elJugador);
    }
}
