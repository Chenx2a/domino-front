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
    private Jugador jugador1;
    private Jugador jugador2;
    
    public model(){
    }
    
    public void iniciar(){
        this.pozo = new ArrayList();
        this.jugador1 = new Jugador();
        this.jugador2 = new Jugador();
    }
    
    public ArrayList getPozo(){
        return this.pozo;
    }
    
    public ArrayList getListaJ1(){
        return this.jugador1.getLista();
    }
    
    public ArrayList getListaJ2(){
        return this.jugador2.getLista();
    }
    
    public void setPozo(ArrayList pozo){
        this.pozo = pozo;
    }
    
    public void setListaJ1(ArrayList lista){
        this.jugador1.setLista(lista);
    }
    
    public void setListaJ2(ArrayList lista){
        this.jugador2.setLista(lista);
    }
    
}
