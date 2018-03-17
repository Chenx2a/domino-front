/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import LogicaNegocio.*;
import java.util.ArrayList;
/**
 *
 * @author Alonso
 */
public class model {
    private ArrayList<Ficha> pozo;
    private ArrayList<Jugador> jugadores;
    
    
    public model(){
    }
    
    public void iniciar(){
        this.pozo = new ArrayList();
        this.jugadores = new ArrayList();
    }
    
    public ArrayList getPozo(){
        return this.pozo;
    }
    
    public ArrayList getJugadores(){
        return this.jugadores;
    }
    
    public void setPozo(ArrayList pozo){
        this.pozo = pozo;
    }
    
    public void setJugadores(ArrayList lista){
        this.jugadores = lista;
    }
    
}
