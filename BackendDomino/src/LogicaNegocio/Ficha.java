package LogicaNegocio;

import javax.swing.ImageIcon;

/**
 *
 * @author Daniel Gutierrez
 */
public class Ficha {
    private int valor1, valor2;
    private String imagen;
    private boolean visible; // 0 no - 1 si
    private int ubicacion; // 0 pozo - 1 Jug1 - 2 Jug2 - 3 Jug3 - 4 Jug4, 5 Jugada

    public Ficha() {
    }
    
    public Ficha(int valor1, int valor2, String imagen, boolean visible, int ubicacion) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.imagen = imagen;
        this.visible = visible;
        this.ubicacion = ubicacion;
    }

    public int getValor1() {
        return valor1;
    }

    public void setValor1(int valor1) {
        this.valor1 = valor1;
    }

    public int getValor2() {
        return valor2;
    }

    public void setValor2(int valor2) {
        this.valor2 = valor2;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public int getValorTotal(){
        return this.valor1 + this.valor2;
    }
    
    public int isDoble(){
        return this.valor1 = this.valor2;
    }
}
