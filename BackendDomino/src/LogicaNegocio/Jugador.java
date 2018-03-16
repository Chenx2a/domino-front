/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

import java.util.ArrayList;

/**
 *
 * @author Daniel Gutierrez
 */
public class Jugador {
    private int numero;
    private int  puntuacion;
    private ArrayList <Ficha> fichas;

    public Jugador() {
        this.numero = 0;
        this.puntuacion = 0;
        this.fichas = new ArrayList();
    }
    
    public Jugador(int numero, int puntuacion, ArrayList fichas) {
        this.numero = numero;
        this.puntuacion = puntuacion;
        this.fichas = fichas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public ArrayList getLista() {
        return fichas;
    }

    public void setLista(ArrayList fichas) {
        this.fichas = fichas;
    }
}