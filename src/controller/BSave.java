package src.controller;

import src.model.jeu.*;
import src.model.parser.SaverContext;
import src.model.parser.json.SaveGameJson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JFileChooser;

public class BSave extends JButton implements ActionListener {


    private Plateau jeu;
    private NameField nameField;
    private ScoreField scoreField;

    public BSave(Plateau jeu, NameField nameField, ScoreField scoreField) {

        super("Save");
        this.jeu = jeu;
        this.addActionListener(this);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.nameField = nameField;
        this.scoreField = scoreField;
        setFocusable(false);

    }

    // On sauvegarde un fichier JSON.
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(new JsonFilter());
        int returnVal = fc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = new File(fc.getSelectedFile().getAbsolutePath());
            SaveGameJson saveGame = new SaveGameJson(selectedFile, jeu);
            SaverContext saver = new SaverContext(saveGame);
            saver.executeStrategy();
            nameField.setText(jeu.getPlayerName());
            scoreField.setText(String.valueOf(jeu.isFinished()));
        }
    }


}

