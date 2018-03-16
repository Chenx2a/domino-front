/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Collection;
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
    
    public controlDomino(control controlador, model modelo, VentanaPrincipal vista ){
        modelo.iniciar();
        this.domainControl = controlador;
        this.modelo = modelo;
        this.vista = vista;
        
    }
    
    public void setControlDomino(control control){
        this.domainControl = control;
    }
    
    public void repartir() throws Exception {
        modelo.setPozo((ArrayList)domainControl.listarFichas());
    }
    
}
