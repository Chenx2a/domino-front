/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend_domino;
import control.control;
import control.controlDomino;
import model.model;
import vista.VentanaPrincipal;

/**
 *
 * @author Alonso
 */
public class FrontEnd_Domino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        control control = new control();
        VentanaPrincipal ventana = new VentanaPrincipal();
        model modelo = new model();
        controlDomino domino = new controlDomino(control, modelo, ventana);
        domino.ingresarJugador();
        ventana.iniciar();
    }
    
}
