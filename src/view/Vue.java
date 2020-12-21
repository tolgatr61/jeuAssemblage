package src.view;

import src.model.jeu.Plateau;

import javax.swing.*;
import java.awt.*;

public class Vue extends JFrame {
    private final VueGrille vueGrille;
    private final PanelSouth panelSouth;

    // On définit la Vue.
    public Vue(Plateau jeu) {
        this.setTitle("Assemblago");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.vueGrille = new VueGrille(jeu, this);
        this.panelSouth = new PanelSouth(jeu);
        this.add(this.vueGrille, BorderLayout.CENTER);
        this.add(this.panelSouth, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }

    public VueGrille getVueGrille() {
        return this.vueGrille;
    }
}
