/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.control;
import control.controlDomino;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.model;

/**
 *
 * @author Alonso
 */
public class VentanaPrincipal extends JFrame{
    private JLabel panelPrincipal;
    private JLabel panelTabla;
    private JButton botonJugar;
    private JButton botonRanking;
    private JButton botonComer;
    private JButton botonComer2;
    private JPanel panelJugador1;
    private JPanel panelJugador2;
    private JButton btnFicha0;
    private controlDomino control;
    private model modelo;
    
    
    
    
    public VentanaPrincipal(controlDomino nuevoGestor) {
        super("Domino");
        ajustarConfiguracionInicial();
        agregarComponentes(this.getContentPane());
        control = nuevoGestor;
    }
    
    public void iniciar() throws Exception {
        this.setVisible(true);
        control.repartir();
    }

    private void ajustarConfiguracionInicial() {
        this.setSize(500, 350);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void ventanaJugar() {
        JDialog panelJugar = new JDialog();
        panelJugar.setTitle("Bienvenido a la mesa \"UNA\"");
        panelJugar.setSize(700, 550);
        panelJugar.setLocationRelativeTo(null);
        panelJugar.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        panelJugar.setVisible(true);
        panelJugar.setBackground(Color.yellow);
        
        panelJugar.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Insets margen = new Insets(5, 5, 5, 5);

        //  PANEL DEL POZO
        JPanel panelCartas = new JPanel();
        panelCartas.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelCartas.setBorder(BorderFactory.createTitledBorder("Pozo"));
        btnFicha0 = new JButton(new ImageIcon(this.getClass().getResource("../imagenes/0-0.jpg")));
        panelCartas.add(btnFicha0);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.75;
        gbc.insets = margen;
        panelJugar.add(panelCartas, gbc);

         // PANEL DE JUGADORES
        panelJugador1 = new JPanel();
        panelJugador1.setLayout(new GridLayout(1, 2));

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.75;
        gbc.insets = margen;
        panelJugar.add(panelJugador1, gbc);
        
        panelJugador2 = new JPanel();
        panelJugador2.setLayout(new GridLayout(1, 2));
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.75;
        gbc.insets = margen;
        panelJugar.add(panelJugador2, gbc);
        
        //  PANEL DE OPCIONES DEL JUGADOR
        JPanel panelOpciones = new JPanel();
        panelOpciones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelOpciones.setBorder(BorderFactory.createTitledBorder("Opciones de juego"));
        //agregar estos botones a los atributos
        botonComer = new JButton("Comer del Pozo Jugador 1");
        panelOpciones.add(botonComer);
        botonComer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelJugador1.add(new JButton(new ImageIcon(this.getClass().getResource("../imagenes/0-0.jpg"))));
                panelJugador1.revalidate();
                validate();
            }
        });
        botonComer2 = new JButton("Comer del Pozo Jugador 2");
        panelOpciones.add(botonComer2);
        botonComer2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            panelJugador2.add(new JButton(new ImageIcon(this.getClass().getResource("../imagenes/0-0.jpg"))));
            panelJugador2.revalidate();
            validate();
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.75;
        gbc.insets = margen;


        panelJugar.add(panelOpciones, gbc);

    }

    private void agregarComponentes(Container contentPane) {
        setLayout(new BorderLayout());
        panelPrincipal = new JLabel();
        panelPrincipal.setLayout(new GridBagLayout());
        panelPrincipal.setBorder(BorderFactory.createTitledBorder("Menu Principal"));

        GridBagConstraints gbc = new GridBagConstraints();
        Insets margen = new Insets(15, 5, 15, 5);

        botonJugar = new JButton("Jugar");
        botonJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ventanaJugar();
            }

        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.75;
        gbc.insets = margen;
        panelPrincipal.add(botonJugar, gbc);

        botonRanking = new JButton("Recuperar Partida");
        botonRanking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //recuperar partida
            }

        });

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.75;
        gbc.insets = margen;
        
        panelPrincipal.add(botonRanking, gbc);
        contentPane.add(panelPrincipal);
        
    }
    
}