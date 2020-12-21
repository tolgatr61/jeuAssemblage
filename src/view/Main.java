package src.view;

import src.model.jeu.Plateau;
import src.model.jeu.PlateauRandomFactory;

public class Main {
    public static void main(String[] args) {
        Plateau plateau = PlateauRandomFactory.generateRandomPlateau(20, 20, 5);
        Vue vue = new Vue(plateau);
        plateau.ajoutEcouteur(vue.getVueGrille());
    }
}
