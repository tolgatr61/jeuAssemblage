package	src.view;

import src.controller.*;
import src.model.jeu.Plateau;
import src.model.jeu.Score;
import src.model.jeu.listeners.EcouteurModele;

import javax.swing.*;
import java.awt.*;


public class PanelSouth extends JPanel {

    public PanelSouth(Plateau plateau){
        this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        // On ajoute tous les contrôleurs dans le Panel Sud.
        JLabel label1 = new JLabel("<html><p>Nom et score : </p> <p> (Si sauvegarder)</p></html>", SwingConstants.CENTER);
        NameField nameField = new NameField(plateau);
        ScoreField scoreField = new ScoreField(plateau);
        BReset reset = new BReset(plateau);
        BSolve solve = new BSolve(plateau);
        BSave save = new BSave(plateau, nameField, scoreField);
        BLoad load = new BLoad(plateau, nameField, scoreField);
        this.add(label1);
        this.add(nameField);
        this.add(scoreField);
        this.add(reset);
        this.add(save);
        this.add(load);
        this.add(solve);
    }
}
