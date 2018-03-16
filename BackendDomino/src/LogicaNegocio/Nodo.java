/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

/**
 *
 * @author Daniel Gutierrez
 */
public class Nodo {
    private Ficha ficha;
    private Nodo ant,sig;

    Nodo() {
    }

    public Nodo(Ficha ficha, Nodo ant, Nodo sig) {
        this.ficha = ficha;
        this.ant = ant;
        this.sig = sig;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}