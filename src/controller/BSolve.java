package src.controller;

import src.model.ia.Ia;
import src.model.ia.IaBruteForce;
import src.model.jeu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BSolve extends JButton implements ActionListener {


    private Plateau jeu;

    public BSolve(Plateau jeu) {

        super("Solve");
        this.jeu = jeu;
        this.addActionListener(this);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        setFocusable(false);

    }
    // Appel de l'IA et génération du plateau résolu.
    public void actionPerformed(ActionEvent e) {
        IaBruteForce iaBruteForce = new IaBruteForce(jeu);
        Ia ia = new Ia(iaBruteForce);
        Plateau plateau = ia.executeStrategy();
        jeu.setPieces(plateau.getPieces());
    }
}

