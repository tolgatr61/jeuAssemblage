package src.controller;

import src.model.jeu.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NameField extends JTextField {

    private Plateau plateau;

    // Structure champ de texte pour le prénom.
    public NameField(Plateau plateau) {
        super("Nom", 12);
        plateau = this.plateau;
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        setFocusable(false);
    }

}
