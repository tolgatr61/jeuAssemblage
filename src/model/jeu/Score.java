/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.jeu;

import src.model.piece.Case;
import src.model.piece.Piece;

/**
 * @author tolga
 */
public class Score {

    private final Plateau plateau;

    public Score(Plateau plateau) {
        this.plateau = plateau;
    }

    public int evaluation() {
        // Point le plus grand (en bas à droite) B
        int minXa = 0;
        int minYa = 0;

        // Point le plus petit (en haut à gauche) D
        int maxXb = 1000;
        int maxYb = 1000;

        // Point perpendiculaire au plus petit. (en haut à droite) C
        int a = 0;
        int b = 0;

        // Point perpendiculaire au plus grand. (en bas à gauche) A
        int aa = 0;
        int bb = 0;
        // On recupère les cordonnées les plus petites et grande parmi celle existante dans tout le plateau.
        for (Piece p : plateau.getPieces()) {
            for (Case c : p.getCases()) {
                if (c.getX() + p.getPosition()[0] > minXa) {
                    minXa = c.getX() + p.getPosition()[0];
                }
                if (c.getY() + p.getPosition()[1] > minYa) {
                    minYa = c.getY() + p.getPosition()[1];
                }
                if (c.getX() + p.getPosition()[0] < maxXb) {
                    maxXb = c.getX() + p.getPosition()[0];
                }
                if (c.getY() + p.getPosition()[1] < maxYb) {
                    maxYb = c.getY() + p.getPosition()[1];
                }
            }
        }
        // On initialise nos points.
        a = minXa;
        b = maxYb;
        aa = maxXb;
        bb = minYa;
        // On calcule la longueur et largeur. Puis, on retourne l'aire.
        int longueur = (int) Math.sqrt(Math.pow(a - maxXb, 2) + Math.pow(b - maxYb, 2));
        int largeur = (int) Math.sqrt(Math.pow(a - minXa, 2) + Math.pow(b - minYa, 2));

        return longueur * largeur;

    }

}