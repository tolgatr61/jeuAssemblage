package src.controller;

import src.model.jeu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import src.model.parser.ParserContext;
import src.model.parser.json.ParserJson;

public class BLoad extends JButton implements ActionListener {


    private final Plateau jeu;
    private final NameField nameField;
    private final ScoreField scoreField;

    public BLoad(Plateau jeu, NameField nameField, ScoreField scoreField) {

        super("Load");
        this.jeu = jeu;
        this.nameField = nameField;
        this.scoreField = scoreField;
        this.addActionListener(this);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        setFocusable(false);

    }

    // On charge le fichier et parse à travers les données de celui-ci un plateau.
    public void actionPerformed(ActionEvent e) {
        final JFileChooser fc = new JFileChooser();
        fc.addChoosableFileFilter(new JsonFilter());
        fc.setAcceptAllFileFilterUsed(false);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = new File(fc.getSelectedFile().getAbsolutePath());
            System.out.println(fc.getSelectedFile().getAbsolutePath());
            ParserContext parser = new ParserContext(new ParserJson());
            Plateau plateau = parser.executeStrategy(selectedFile);
            assert plateau != null;
            jeu.setPieces(plateau.getPieces());
            jeu.setPlayerName(plateau.getPlayerName());
            nameField.setText(jeu.getPlayerName());
            scoreField.setText(String.valueOf(jeu.isFinished()));
        }
    }
}


