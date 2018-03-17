/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import LogicaNegocio.Ficha;
import LogicaNegocio.Jugador;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import model.model;
import vista.VentanaPrincipal;

/**
 *
 * @author Alonso
 */
public class controlDomino {
    private control domainControl;
    private model modelo;
    private VentanaPrincipal vista;
    private int NUM_FICHAS = 28;
    private int NUM_RANDOM;
    
    public controlDomino(control controlador, model modelo, VentanaPrincipal vista ) throws Exception{
        modelo.iniciar();
        this.domainControl = controlador;
        this.modelo = modelo;
        this.vista = vista;
        vista.setControlDomino(this);
        vista.setModel(modelo);
    }
    
    public void setControlDomino(control control){
        this.domainControl = control;
    }
    
    public String getImagen(int i) {
        ArrayList pozo = (ArrayList)modelo.getPozo();
        Ficha ficha = (Ficha) pozo.get(i);
        return ficha.getImagen();
    }
    
    public int getNUMRANDOM(){
        return NUM_RANDOM;
    }
    
    public void repartir() throws Exception {
        modelo.setPozo((ArrayList)domainControl.listarFichas());
    }
    
    public void ingresarJugador () throws Exception{
        
        Jugador elJugador = new Jugador(1, 0, new ArrayList());
        Jugador elJugador1 = new Jugador(2, 0, new ArrayList());
        ArrayList jugadores = new ArrayList();
        jugadores.add(elJugador);
        jugadores.add(elJugador1);
        modelo.setJugadores(jugadores);
        //domainControl.insertarJugador(elJugador);
        //domainControl.insertarJugador(elJugador1);
    }
    
    public void cargarFichas() {
       ArrayList<Ficha> fichas = new ArrayList();
       Random rand = new Random();
       for(int i = 0; i < 2; i++){
        Jugador j = (Jugador) modelo.getJugadores().get(i);
        for (int k = 0; k < 7; k++) {
            NUM_RANDOM = rand.nextInt(NUM_FICHAS--);
            fichas.add((Ficha) modelo.getPozo().get(NUM_RANDOM));
            modelo.getPozo().remove(NUM_RANDOM);
        }
        j.setLista(fichas);
       }
    }
    
}
