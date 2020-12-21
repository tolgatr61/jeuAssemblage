package src.controller;

import src.model.jeu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BReset extends JButton implements ActionListener {


    private Plateau jeu;

    public BReset(Plateau jeu) {

        super("Reset");
        this.jeu = jeu;
        this.addActionListener(this);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        setFocusable(false);

    }

    // Nouveau plateau aléatoire.
    public void actionPerformed(ActionEvent e) {
        jeu.ensembleAlea();
        this.repaint();

    }
}


