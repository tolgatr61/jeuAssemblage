package src.controller;

import src.model.jeu.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScoreField extends JTextField {

    private Plateau plateau;

    // Structure champ de texte pour le score.
    public ScoreField(Plateau plateau) {
        super("", 3);
        plateau = this.plateau;
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        setFocusable(false);
    }

}

